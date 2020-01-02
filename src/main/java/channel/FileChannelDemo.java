package channel;

/**
 * @description: 文件管道
 * @author: brave.chen
 * @create: 2019-12-31 20:33
 **/
public class FileChannelDemo {
    /**
     * ﻿FileChannel对象不能直接创建。一个FileChannel实例只能通过在一个
     * 打开的file对象（RandomAccessFile、 FileInputStream或 FileOutputStream）上调用getChannel( )方法
     * 获取 。调用getChannel( )方法会返回一个连接到相同文件的FileChannel对象且该FileChannel对象
     * 具有与file对象相同的访问权限，然后您就可以使用该通道对象来利用强大的FileChannel API了
     *
     * ﻿FileChannel 对象是线程安全（thread-safe）的。多个进程可以在同一个实例上并发调用方法而
     * 不会引起任何问题，不过并非所有的操作都是多线程的（multithreaded）。影响通道位置或者影响
     * 文件大小的操作都是单线程的（single-threaded）。如果有一个线程已经在执行会影响通道位置或文
     * 件大小的操作，那么其他尝试进行此类操作之一的线程必须等待。并发行为也会受到底层的操作系
     * 统或文件系统影响。
     * 同大多数 I/O 相关的类一样， FileChannel 是一个反映 Java 虚拟机外部一个具体对象的抽象。
     * FileChannel 类保证同一个 Java 虚拟机上的所有实例看到的某个文件的视图均是一致的，但是 Java
     * 虚拟机却不能对超出它控制范围的因素提供担保。通过一个 FileChannel 实例看到的某个文件的视
     * 图同通过一个外部的非 Java 进程看到的该文件的视图可能一致，也可能不一致。多个进程发起的
     * 并发文件访问的语义高度取决于底层的操作系统和（或）文件系统。一般而言，由运行在不同 Java
     * 虚拟机上的 FileChannel 对象发起的对某个文件的并发访问和由非 Java 进程发起的对该文件的并发
     * 访问是一致的。
     */

}
