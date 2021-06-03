package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
    public static void main(String[] args) throws IOException {
        // 标准输入流,从控制台输入
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=stdin.readLine())!=null && s.length()!=0){
            System.out.println(s);
        }
    }
}
