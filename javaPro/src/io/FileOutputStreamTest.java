package io;

import java.io.*;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException{
        File file1 = new File("testcharstream.txt");
        File file2 = new File("testbytestream.txt");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file1));
        osw.write("hello world");
        // 没有flush的时候字符流不会写入文件，字符流会先写入缓冲区
//        fos.flush();
        FileOutputStream fos = new FileOutputStream(file2);
        fos.write("hello world".getBytes());
    }
}
