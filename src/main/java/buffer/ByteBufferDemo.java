package buffer;

import util.PrintUtil;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * @description: 字节缓冲区demo
 * @author: brave.chen
 * @create: 2019-12-30 20:26
 **/
public class ByteBufferDemo {
    public static void main(String[] args) {
        directBuffer();
        viewBuffer();
    }

    public static void directBuffer() {
//分配直接缓存区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);

        //判断是否是直接缓存区
        System.out.println(buf.isDirect());

    }

    /**
     * 试图缓冲区
     */
    public static void viewBuffer() {
        //创建一个1024大小的缓冲区,并且 从大到小排序
        ByteBuffer buf = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);

        buf.put(0, (byte) 0);

        buf.put(1, (byte) 'a');

        buf.put(2, (byte) 1);

        buf.put(3, (byte) 2);

        buf.put(4, (byte) 0);

        buf.put(5, (byte) 0);

        buf.put(6, (byte) 0);

        CharBuffer buffer = buf.asCharBuffer();
        PrintUtil.println(buffer);
        PrintUtil.println(buf);
    }


}
