package com.home.nio;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by li.ma on 2018/8/23.
 *
 * 大文件无法在一个MappedByteBuffer存储，需要进行多个MappedByteBuffer读取
 */
public class BigMappedByteBufferReader {
    private MappedByteBuffer[] mappedByteBuffers;
    private FileInputStream inputStream;
    private FileChannel fileChannel;

    private int bufferCountIndex = 0;
    private int bufferCount;

    private int byteBufferSize;
    private byte[] byteBuffer;

    public BigMappedByteBufferReader(String fileName, int byteBufferSize) throws IOException {
        this.inputStream = new FileInputStream(fileName);
        this.fileChannel = inputStream.getChannel();

        long fileSize = fileChannel.size();
        this.bufferCount = (int) Math.ceil((double)fileSize / (double) Integer.MAX_VALUE);

        this.mappedByteBuffers = new MappedByteBuffer[bufferCount];
        this.byteBufferSize = byteBufferSize;

        long preLength = 0;
        long regionSize = Integer.MAX_VALUE;
        for (int i = 0; i < bufferCount; i++) {
            if (fileSize - preLength < Integer.MAX_VALUE) {
                regionSize = fileSize - preLength;
            }

            mappedByteBuffers[i] = fileChannel.map(FileChannel.MapMode.READ_ONLY, preLength, regionSize);

            preLength += regionSize;
        }
    }

    public synchronized int read() {
        if (bufferCountIndex >= bufferCount) {
            return -1;
        }

        int limit = mappedByteBuffers[bufferCountIndex].limit();
        int position = mappedByteBuffers[bufferCountIndex].position();

        int realSize = byteBufferSize;
        if (limit - position < byteBufferSize) {
            realSize = limit - position;
        }

        byteBuffer = new byte[realSize];
        mappedByteBuffers[bufferCountIndex].get(byteBuffer);

        if (realSize < byteBufferSize && bufferCountIndex < bufferCount) {
            bufferCountIndex ++;
        }

        return realSize;
    }

    public void close () throws IOException {
        IOUtils.closeQuietly(fileChannel);
        IOUtils.closeQuietly(inputStream);

        for (MappedByteBuffer mappedByteBuffer : mappedByteBuffers) {
            mappedByteBuffer.clear();
        }

        byteBuffer = null;
    }


    public synchronized byte[] getCurrentBytes() {
        return byteBuffer;
    }

    public static void main(String[] args) throws IOException {
        BigMappedByteBufferReader bigMappedByteBufferReader = new BigMappedByteBufferReader("D:\\brand_name.txt", 1024);

        while (bigMappedByteBufferReader.read() != -1) {
            byte[] bytes = bigMappedByteBufferReader.getCurrentBytes();

            System.out.println(new String(bytes, "UTF-8"));
        }

        bigMappedByteBufferReader.close();
    }
}
