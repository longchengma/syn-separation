package com.home.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by li.ma on 2018/8/7.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    int count = 0;

    static final String REQUEST_TEST_DATA="I love you....$_";



    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //发送消息,模拟发送向服务端发送1000条数据
        for(int i=0,j=1000;i<j;i++){
            ctx.writeAndFlush(Unpooled.copiedBuffer(REQUEST_TEST_DATA.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String sendMsg=(String)msg;
        System.out.println("客户端发送给服务器的次数:"+(++count)+"，服务器接收数据为："+sendMsg);
    }



    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
