package channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @description: 发散
 * ﻿通道提供了一种被称为 Scatter/Gather 的重要新功能（有时也被称为矢量 I/O）。 Scatter/Gather是一个简单却强大的概念(发散)，
 * 它是指在多个缓冲区上实现一个简单的 I/O 操作。
 * 对于一个 write 操作而言，数据是从几个缓冲区按顺序抽取（称为 gather）并沿着通道发送的。缓冲区本身并不需要具备这种 gather 的能力（通常它们也没有此能力）。该 gather 过程的效果就好比全部缓冲区的内容被连结起来，并在发送数据前存放到一个大的缓冲区中。对于 read 操作而言，从通道读取的数据会按顺序被散布（称为 scatter）到多个缓冲区，将每个缓冲区填满直至通道中的数据或者缓冲区的最大空间被消耗完。
 * 大多数现代操作系统都支持本地矢量 I/O（native vectored I/O）。当您在一个通道上请求一个Scatter/Gather 操作时，该请求会被翻译为适当的本地调用来直接填充或抽取缓冲区。这是一个很大的进步，因为减少或避免了缓冲区拷贝和系统调用。Scatter/Gather 应该使用直接的 ByteBuffers 以从本地 I/O 获取最大性能优势
 * @author: brave.chen
 * @create: 2019-12-31 19:49
 **/
public class ScatterAndGather {

    private static final String DEMOGRAPHIC = "blahblah.txt";

    // "Leverage frictionless methodologies"
    public static void main(String[] argv)
            throws Exception {
        int reps = 10;
        if (argv.length > 0) {
            reps = Integer.parseInt(argv[0]);
        }
        FileOutputStream fos = new FileOutputStream(DEMOGRAPHIC);
        GatheringByteChannel gatherChannel = fos.getChannel();
// Generate some brilliant marcom, er, repurposed content
        ByteBuffer[] bs = utterBS(reps);
// Deliver the message to the waiting market
        while (gatherChannel.write(bs) > 0) {
// Empty body
// Loop until write( ) returns zero
        }
        System.out.println("Mindshare paradigms synergized to "
                + DEMOGRAPHIC);
        fos.close();
    }

    // ------------------------------------------------
// These are just representative; add your own
    private static String[] col1 = {
            "Aggregate", "Enable", "Leverage",
            "Facilitate", "Synergize", "Repurpose",
            "Strategize", "Reinvent", "Harness"
    };
    private static String[] col2 = {
            "cross-platform", "best-of-breed", "frictionless",
            "ubiquitous", "extensible", "compelling",
            "mission-critical", "collaborative", "integrated"
    };
    private static String[] col3 = {
            "methodologies", "infomediaries", "platforms",
            "schemas", "mindshare", "paradigms",
            "functionalities", "web services", "infrastructures"
    };
    private static String newline = System.getProperty("line.separator");

    // The Marcom-atic 9000
    private static ByteBuffer[] utterBS(int howMany)
            throws Exception {
        List list = new LinkedList();
        for (int i = 0; i < howMany; i++) {
            list.add(pickRandom(col1, " "));
            list.add(pickRandom(col2, " "));
            list.add(pickRandom(col3, newline));
        }
        ByteBuffer[] bufs = new ByteBuffer[list.size()];
        list.toArray(bufs);
        return (bufs);
    }

    // The communications director
    private static Random rand = new Random();

    // Pick one, make a buffer to hold it and the suffix, load it with
// the byte equivalent of the strings (will not work properly for68
// non-Latin characters), then flip the loaded buffer so it's ready
// to be drained
    private static ByteBuffer pickRandom(String[] strings, String suffix)
            throws Exception {
        String string = strings[rand.nextInt(strings.length)];
        int total = string.length() + suffix.length();
        ByteBuffer buf = ByteBuffer.allocate(total);
        buf.put(string.getBytes("US-ASCII"));
        buf.put(suffix.getBytes("US-ASCII"));
        buf.flip();
        return (buf);
    }
}