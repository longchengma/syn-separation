package com.home.netty;

/**
 * Created by li.ma on 2018/8/7.
 */
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    int count=0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String body=(String)msg;
        System.out.println("服务器收到"+(++count)+"次客户端消息，消息是:"+body);
        body+="$_";
        ByteBuf rep=Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(rep);
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
