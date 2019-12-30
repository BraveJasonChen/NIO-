package buffer;

import java.nio.CharBuffer;

/**
 * @description: 缓冲区的复制
 * ﻿如我们刚刚所讨论的那样，可以创建描述从外部存储到数组中的数据元素的缓冲区对象。
 * 但是缓冲区不限于管理数组中的外部数据。它们也能管理其他缓冲区中的外部数据。当一个管
 * 理其他缓冲器所包含的数据元素的缓冲器被创建时，这个缓冲器被称为视图缓冲器。大多数的
 * 视图缓冲器都是 ByteBuffer  的视图。
 *
 * 在继续前往字节缓冲器的细节之前，我们先将注意力放在所有存储器类型的共同视图上。
 *
 * 视图存储器总是通过调用已存在的存储器实例中的函数来创建。
 * 使用已存在的存储器实例中的工厂方法意味着视图对象为原始存储器的内部实现细节私有。
 *
 * 数据元素可以直接存取，无论它们是存储在数组中还是以一些其他的方式，而不需经过原始缓冲区对象的 get()/put()
 * API。
 *
 * 如果原始缓冲区是直接缓冲区，该缓冲区的视图会具有同样的效率优势。
 *
 * 映像缓冲区也是如此（将于第三章讨论）。
 *
 * 在这一章节中，我们将再次以 CharBuffer 为例，但同样的操作可被用于任何基本的缓
 * 冲区类型（参见图 2.1）。
 * @author: brave.chen
 * @create: 2019-12-29 21:39
 **/
public class CopyBuffer {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        CharBuffer buffer = CharBuffer.allocate(8);
        buffer.put("12345678");
        buffer.position(3).limit(6).mark().position(5);
        CharBuffer dupeBuffer = buffer.asReadOnlyBuffer();
        buffer.clear();
        System.out.println("buffer "+buffer +";dupeBuffer:"+dupeBuffer);
    }

    /**
     * 这里  sliceBuffer 只会占用   posistion只会为3
     *
     */
    public static void  test2(){
        CharBuffer buffer = CharBuffer.allocate(8);
        buffer.put("12345678");
        buffer.position(3).limit(6);
        CharBuffer sliceBuffer = buffer.slice();
        buffer.clear();

        System.out.println("buffer "+buffer +";sliceBuffer:"+sliceBuffer);
    }


}
