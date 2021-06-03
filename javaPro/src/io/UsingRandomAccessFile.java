package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    static String file = "rtest.dat";
    public static void display() throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        for(int i=0; i<7; i++){
            System.out.println("value" + i + ": "+ raf.readDouble());
        }
        System.out.println(raf.readUTF());
        raf.close();
    }
    public static void main(String[] args) throws IOException{
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        for(int i=0; i<7; i++)
            raf.writeDouble(i);
        raf.writeUTF("The end of the file");
        raf.close();
        display();
        raf = new RandomAccessFile(file, "rw");
        raf.seek(5*8);
        raf.writeDouble(8);
        raf.close();
        display();
    }
}
