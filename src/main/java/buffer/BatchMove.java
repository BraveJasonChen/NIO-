package buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @description: 批量移动
 * @author: brave.chen
 * @create: 2019-12-29 20:27
 **/
public class BatchMove {
    /**
     * ﻿有两种形式的 get( )可供从缓冲区到数组进行的数据复制使用。第一种形式只将一个数组
     * 作为参数，将一个缓冲区释放到给定的数组。
     * 第二种形式使用 offset 和 length 参数来指
     * 定目标数组的子区间。这些批量移动的合成效果与前文所讨论的循环是相同的，但是这些方法
     * 可能高效得多，因为这种缓冲区实现能够利用本地代码或其他的优化来移动数据。
     * 批量移动总是具有指定的长度。也就是说，您总是要求移动固定数量的数据元素。当参看
     * 程序签名时这一点还不明显，但是对 get( )的这一引用：
     */

    /**
     * ﻿buffer.get(myArray);
     * 等价于：
     * buffer.get(myArray,0,myArray.length);
     */

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(10000000);
        for( int i = 0;i< 100000;i++){
            buffer.put("aaaaaaaa2342344234323443432a23432434232342334324233434234234234234234234234234234324343244234");
        }
        long start = System.currentTimeMillis();
        move1(buffer);
        long end = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        move2(buffer);
        long end2 = System.currentTimeMillis();
        System.out.println("buffer.Position"  +
                         "batch move  waste time = "+ (end -start) +"\n"+
                        "single move  waste time = "+ (end2 -start2) +"\n");
    }

    /**
     *  10000000 内容 3 ms 耗时
     * @param buffer
     */
    public static void move1(CharBuffer buffer) {
        //旋转
        buffer.flip();
// Get count of chars remaining in the buffer
        char[] smallArray = new char[1000];
        while(buffer.hasRemaining()){
            int length = Math.min (buffer.remaining( ), smallArray.length);
            buffer.get (smallArray, 0, length);
            processData (smallArray, length);
        }
    }

    /**
     * 单个取出 24ms
     * @param buffer
     */
    public static void move2(CharBuffer buffer) {
        //旋转
        buffer.flip();
// Get count of chars remaining in the buffer
        char[] smallArray = new char[1000];
        while(buffer.hasRemaining()){
            int length = Math.min(buffer.remaining(), smallArray.length);
            for( int i = 0 ;i<length ; i ++){
                smallArray[i] = buffer.get();
            }
            processData (smallArray, length);
        }
    }
    private static void processData(char[] bigArray, int length) {
//        System.out.println("arr= " + new String(bigArray, 0, length));
    }
}
