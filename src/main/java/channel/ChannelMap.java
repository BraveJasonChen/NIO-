package channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @description: ﻿内存映射文件
 * @author: brave.chen
 * @create: 2020-01-01 11:10
 **/
public class ChannelMap {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("blahblah.txt");
        FileChannel channel = fileOutputStream.getChannel();
        FileLock lock = channel.lock();
        channel.write(ByteBuffer.allocate(1024));
    }
}