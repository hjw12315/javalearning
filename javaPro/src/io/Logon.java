package io;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable {
    public Date date = new Date();
    private String userName;
    private transient String password;    // 关键字transient，表示不可被序列化
    public Logon(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public String toString(){
        return "Logon info: \n userName: " + userName +
                "\n date: " + date + "\n password: " + password;
    }
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Logon.txt"));
        out.writeObject(a);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.txt"));
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Recovering object at: " + new Date());
        a = (Logon)in.readObject();
        System.out.println("logon a = " + a);
    }
}
