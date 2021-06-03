package io;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream ps = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("rtest.dat"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        out.close();
        // InputStreamReader是一个适配器，将字节流转换为字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.out")));
        String s;
        while((s=br.readLine())!=null)
            System.out.println(s);
        System.setOut(ps);
    }
}
