package com.home.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TimeClient {

    public void connect(int port, String host) throws Exception {
        // 配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel arg0)
                                throws Exception {
                            System.out.println("client initChannel..");
                            //arg0.pipeline().addLast(new TimeClientHandler());


                            ByteBuf delimiter=Unpooled.copiedBuffer("$_".getBytes());//指定消息分割符
                            //arg0.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                           arg0.pipeline().addLast(new StringDecoder());
                            arg0.pipeline().addLast(new EchoClientHandler());

                           /* ByteBuf message = Unpooled.buffer("hello".getBytes().length) ;
                            message.writeBytes("hello".getBytes()) ;
                            ChannelFuture future = arg0.writeAndFlush("hello");
                            future.addListener((ChannelFutureListener) channelFuture ->
                                    System.out.println("客户端手动发消息成功={}" + "hello"));*/
                        }
                    });
            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();
            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 9000;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
            }
        }
        new TimeClient().connect(port, "127.0.0.1");
    }
}
