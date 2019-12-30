package util;

import java.nio.Buffer;

/**
 * @description:
 * @author: brave.chen
 * @create: 2019-12-30 20:52
 **/
public class PrintUtil {
    public static void println(Buffer buffer){
        System.out.println ("pos=" + buffer.position( )
                + ", limit=" + buffer.limit( )
                + ", capacity=" + buffer.capacity( )
                + ": '" + buffer.toString( ) + "'");
    }
}
