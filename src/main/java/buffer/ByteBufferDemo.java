package buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @description:
 * ﻿所有的缓冲区都具有四个属性来提供关于其所包含的数据元素的信息。它们是：
 *
 * 容量（Capacity）
 * 缓冲区能够容纳的数据元素的最大数量。这一容量在缓冲区创建时被设定，并且永远不能
 * 被改变。
 * 上界（Limit）
 * 缓冲区的第一个不能被读或写的元素。或者说，缓冲区中现存元素的计数。
 * 位置（Position）
 * 下一个要被读或写的元素的索引。位置会自动由相应的 get( )和 put( )函数更新。
 * 标记（Mark）
 * 一个备忘位置。调用 mark( )来设定 mark = postion。调用 reset( )设定 position =
 * mark。标记在设定前是未定义的(undefined)。
 * @author: brave.chen
 * @create: 2019-12-22 21:34
 **/
public class ByteBufferDemo {

       private static ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 4);

    public static void main(String[] args) {

        byteBuffer.put((byte)'h').put((byte)'l').put((byte)'l').put((byte)'o');
        Buffer mark = byteBuffer.mark();
        byteBuffer.put(0,(byte)'M').put((byte)'w');
        testInformation();
//        byteBuffer.reset();
        testMark();
//        ﻿byteBuffer.limit(byteBuffer.position()).position(0);
        get();
    }

    public static  void testInformation(){
        System.out.println("limit = "+ byteBuffer.limit());
        System.out.println("capacity = " + byteBuffer.capacity());
        System.out.println("position = " + byteBuffer.position());
    }

    public static void testMark(){
        System.out.println("mark = " + byteBuffer.position());
    }

    public static void get(){
        byteBuffer.flip();
        int count = byteBuffer.remaining();
        byte[] myByteArray = new byte[count];
        for (int i = 0; i < count; i++) {
            myByteArray [i] = byteBuffer.get( );
        }
        System.out.println(new String(myByteArray));
    }
}
