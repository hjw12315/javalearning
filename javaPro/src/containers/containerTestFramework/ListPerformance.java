package containers.containerTestFramework;

import generator.CountingGenerator;
import generator.GeneratedArrays;

import java.util.*;

public class ListPerformance {
    static Random random = new Random(47);
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
    static LinkedList<Test<LinkedList<Integer>>> qTests = new LinkedList<Test<LinkedList<Integer>>>();

    static{
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for(int i=0; i<loops; i++){
                    container.clear();
                    for(int j=0; j<listSize; j++){
                        container.add(j);
                    }
                }
                return loops * listSize;
            }
        });

        tests.add(new Test<List<Integer>>("get"){
            @Override
            int test(List<Integer> container, TestParam tp){
                int loops = tp.loops * reps;
                int listSize = container.size();
                for(int i=0; i<loops; i++){
                    container.get(random.nextInt(listSize));
                }
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = container.size();
                for(int i=0; i<loops; i++){
                    container.set(random.nextInt(listSize), 47);
                }
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("iteradd") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                final int LOOPS = 1000000;
                int half = container.size() / 2;
                ListIterator<Integer> it = container.listIterator(half);
                for(int i=0; i<LOOPS; i++)
                    it.add(47);
                return LOOPS;
            }
        });

        tests.add(new Test<List<Integer>>("insert") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops;
                for(int i=0; i<loops; i++){
                    container.add(5, 47);
                }
                return loops;
            }
        });
    }

//    static class listTester extends Tester<List<Integer>>{
//        public listTester(List<Integer> container, List<Test<List<Integer>>> tests){
//            super(container, tests);
//        }
//        @Override
//        protected List<Integer> initialize(int size){
//            container.clear();
//            container.addAll(new CountingGeneratorList(size));
//            return container;
//        }
//        public static void run(List<Integer> list, List<Test<List<Integer>>> tests){
//            new listTester(list, tests).timedTest();
//        }
//    }

    public static void main(String[] args){
        Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, tests.subList(1,3)){
            @Override protected  // 匿名内部类重写一个protected方法为什么要加protected？？？
            List<Integer> initialize(int size){   // 用于初始化一个container
                Integer[] ia = GeneratedArrays.array(Integer.class,
                        new CountingGenerator.Integer(), size);  // 随机生成数组
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
//        Tester.defaultParam = TestParam.array(10,5000,100,5000,1000,1000,10000,200);
    }
}
