import java.util.TreeSet;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        TreeSet<StudentCollection> sc = new TreeSet<>(new Comparator<StudentCollection>(){
            @Override
            public int compare(StudentCollection s1, StudentCollection s2){
                int num = s2.getTotalScore() - s1.getTotalScore();
                int num2 = num==0? s1.getName().compareTo(s2.getName()): num;
                return num2;
            }
        });

        while(!flag){
            System.out.print("请输入姓名: ");
            String name = input.next();
            System.out.print("请输入语文成绩: ");
            int chinese = input.nextInt();
            System.out.print("请输入数学成绩: ");
            int math = input.nextInt();
            System.out.print("请输入英语成绩: ");
            int english = input.nextInt();
            System.out.print("是否结束输入(true/false): ");
            flag = input.nextBoolean();

            sc.add(new StudentCollection(name, chinese, math, english));
        }
        input.close();

        // 总成绩排序
        // 排序之后写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("scoresBufferedWriter.txt"));
        try(bw){
            bw.write("姓名,语文成绩,数学成绩,英语成绩");
            bw.newLine();
            bw.flush();
            for(StudentCollection s: sc){
                StringBuilder sb = new StringBuilder();
                sb.append(s.getName()+",").append(s.getChinese()+",").append(s.getMath()+",").append(s.getEnglish());
                bw.write(sb.toString());
                bw.newLine();
                bw.flush();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
