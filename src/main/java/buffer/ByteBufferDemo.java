package buffer;

import java.nio.ByteBuffer;

/**
 * @description: 字节缓冲区demo
 * @author: brave.chen
 * @create: 2019-12-30 20:26
 **/
public class ByteBufferDemo {
    public static void main(String[] args) {
        directBuffer();
    }

    public static void directBuffer(){
//分配直接缓存区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);

        //判断是否是直接缓存区
        System.out.println(buf.isDirect());

    }
}
