package netty;

import com.shangyi.netty.module.PushMsg;

import io.netty.channel.socket.SocketChannel;

/**
 * netty推送服务端
 *
 * @author 徐飞
 * @version 2016/02/25 16:38
 */
public class PushServer {

    public static void start(){
        try {
            new NettyServerBootstrap(9999);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void push(){
        SocketChannel channel = (SocketChannel) NettyChannelMap.get("001");
        if (channel != null) {
            PushMsg pushMsg = new PushMsg();
            pushMsg.setTitle("这是标题。");
            pushMsg.setContent("这是内容。");
            channel.writeAndFlush(pushMsg);
        }
    }
}
