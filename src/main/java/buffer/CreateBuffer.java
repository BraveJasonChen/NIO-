package buffer;

import java.nio.CharBuffer;

/**
 * @description: 创建缓冲区
 * @author: brave.chen
 * @create: 2019-12-29 21:18
 **/
public class CreateBuffer {

    public static void main(String[] args) {
        CharBuffer buffer1 = createByAllocate();
        CharBuffer buffer2 = createByArray();

    }

    /**
     * ﻿要分配一个容量为 100 个 char 变量的 Charbuffer:
     * CharBuffer charBuffer = CharBuffer.allocate (100);
     * 这段代码隐含地从堆空间中分配了一个 char 型数组作为备份存储器来储存 100 个 char
     * 变量。
     * @return
     */
    public static CharBuffer createByAllocate(){
        CharBuffer charBuffer = CharBuffer.allocate (100);
        return  charBuffer;
    }

    /**
     * ﻿char [] myArray = new char [100];
     * CharBuffer charbuffer = CharBuffer.wrap (myArray);
     * 这段代码构造了一个新的缓冲区对象，但数据元素会存在于数组中。这意味着通过调用
     * put()函数造成的对缓冲区的改动会直接影响这个数组，而且对这个数组的任何改动也会对这
     * 个缓冲区对象可见。带有 offset 和 length 作为参数的 wrap()函数版本则会构造一个按照
     * 您提供的 offset 和 length 参数值初始化位置和上界的缓冲区。这样做：
     * CharBuffer charbuffer = CharBuffer.wrap (myArray, 12, 42);
     * 创建了一个 position 值为 12， limit 值为 54，容量为 myArray.length 的缓冲
     * 区。
     * 这个函数并不像您可能认为的那样，创建了一个只占用了一个数组子集的缓冲区。这个缓
     * 冲区可以存取这个数组的全部范围； offset 和 length 参数只是设置了初始的状态。调用使
     * 用上面代码中的方法创建的缓冲区中的 clear()函数，然后对其进行填充，直到超过上界
     * 值，这将会重写数组中的所有元素。 Slice()函数（ 2.3 节将会讨论）可以提供一个只占用
     * 备份数组一部分的缓冲区。
     * 通过 allocate()或者 wrap()函数创建的缓冲区通常都是间接的（直接缓冲区会在
     * 2.4.2 节讨论）。间接的缓冲区使用备份数组，像我们之前讨论的，您可以通过上面列出的
     * API 函数获得对这些数组的存取权。 Boolean 型函数 hasArray()告诉您这个缓冲区是否有
     * 一个可存取的备份数组。如果这个函数的返回 true， array()函数会返回这个缓冲区对象所
     * 使用的数组存储空间的引用。
     * @return
     */
    public static CharBuffer createByArray(){
         char[] myArray = new char[100];
        CharBuffer charbuffer = CharBuffer.wrap (myArray,10,66);
        return  charbuffer;
    }
}
