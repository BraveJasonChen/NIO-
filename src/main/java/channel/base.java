package channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @description: 通道基础
 * @author: brave.chen
 * @create: 2019-12-31 19:00
 **/
public class base {

    public static void main(String[] args) throws IOException {
        openChannel();
//        useChannel();
    }

    public static void openChannel() throws IOException {
        ServerSocketChannel ssc  = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(9999));
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress(InetAddress.getLocalHost(),9999));
        RandomAccessFile raf = new RandomAccessFile ("/Users/chenwei/IdeaProjects/nio/src/main/resources/1.txt", "r");
        FileChannel fc = raf.getChannel( );
    }

    /**
     * file input stram 只读
     * Exception in thread "main" java.nio.channels.NonWritableChannelException
     * @throws IOException
     */
    public static void useChannel() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        for(int i = 0 ; i< 512;i++){
            byteBuffer.put((byte) i);
        }
        FileInputStream input = new FileInputStream("/Users/chenwei/IdeaProjects/nio/src/main/resources/1.txt");
        FileChannel channel = input.getChannel();
        channel.write(byteBuffer);
    }
}
