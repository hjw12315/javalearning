package containers.containerTestFramework;

import java.util.*;

public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParam =
            TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500); // 偶数为size,奇数为loops
    protected C initialize(int size) {return container;}
    protected C container;        // 要测试的容器类型
    private List<Test<C>> testList;  // 要测试的方法列表
    private String headline = "";
    private TestParam[] listParams = defaultParam;
    public Tester(C container, List<Test<C>> testList){
        this.container = container;
        this.testList = testList;
    }
    public Tester(C container, List<Test<C>> list, TestParam[] listParams){
        this(container, list);
        this.listParams = listParams;
        if (container!=null)
            headline = container.getClass().getSimpleName();
    }

    public static <C> void run(C container, List<Test<C>> tests){
        new Tester<C>(container, tests).timedTest();
    }
    public static <C> void run(C container, List<Test<C>> tests, TestParam[] listParams){
        new Tester<C>(container, tests, listParams).timedTest();
    }
    // 打印
    private static String stringField(){ return "%" + fieldWidth + "s"; }
    private static String numberField(){ return "%" + fieldWidth + "d"; }
    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    public void setHeadline(String headline){ this.headline = headline; }
    private void displayHeader(){
        int width = fieldWidth * testList.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<dashLength/2; i++){
            sb.append('-');
        }
        sb.append(' ');
        sb.append(headline);
        sb.append(' ');
        for(int i=0; i<dashLength/2; i++)
            sb.append('-');
        System.out.println(sb);
        System.out.format(sizeField, "size");
        for(Test test: testList)
            System.out.format(stringField(), test.name);
        System.out.println();
    }

    public void timedTest(){
        displayHeader();
        for(TestParam tp: listParams){
            System.out.format(sizeField, tp.size);
            for(Test<C> test: testList){
                C kontainer = initialize(tp.size);    // 这个也可以重写，重新初始化
                long start = System.nanoTime();
                int reps = test.test(kontainer, tp);  // 匿名内部类重写test方法
                long allTime = System.nanoTime() - start;
                long timePreRep = allTime/reps;
                System.out.format(numberField(), timePreRep);
            }
            System.out.println();
        }
    }

}
