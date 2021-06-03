package project.util;

import java.util.Scanner;

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static char readChoice(){
        char c;
        while(true){
            String str = readKeyboard(5, false);
            //System.out.print(str);
            c = str.charAt(0);  //字符串类型变字符
            if(c!='1' && c!='2' && c!='3' && c!='4' && c!='5')
                System.out.println("请重新输入: ");
            else
                break;
        }
        return c;
    }

    public static String readString(int limit){
        String str = readKeyboard(limit, false);
        return str;
    }

    public static int readInt(){
        int age = 0;
        while(scanner.hasNextInt()){
            age = scanner.nextInt();
            if(age<0 || age>150){
                System.out.print("输入有误，请重新输入: ");
                continue;
            }
            break;
        }
        return age;
    }

    public static char readChar(){
        String line = scanner.nextLine();
        return line.charAt(0);
    }

    public static char readConfirmSelect(){
        String str = scanner.nextLine();
        char c = str.charAt(0);
        if(c=='Y' || c=='N')
            c += 32;
        return c;
    }

    // 需要改进
    public static String readKeyboard(int limit, boolean b){
        String line = "";
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.length()==0){
                if(b) return line;  //这是干嘛的？ b是true的话 输出""
                else continue;
            }
            if(line.length()>limit || line.length()<1) {
                System.out.print("输入的位数为(" +1+"-"+limit +")之间,请重新输入: ");
                continue;
            }
            break;
        }
        return line;
    }

}
