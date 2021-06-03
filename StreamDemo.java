import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Map;

public class StreamDemo {
    public static void main(String[] args){
        ArrayList<String> array = new ArrayList<>();
        array.add("zhangmanyu");
        array.add("liudehua");
        array.add("guofucheng");
        array.add("zhangmin");
        array.add("liuaihua");

        // 找出首字为z，长度为8的string
        array.stream().filter(s->s.startsWith("z")).filter(s->s.length()==8).forEach(System.out::println);
        System.out.println("-------");
        // limit
        Stream<String> s1 = array.stream().limit(3);
        // skip
        Stream<String> s2 = array.stream().skip(2);
        // concat、distinct
        Stream.concat(s1, s2).distinct().forEach(System.out::println);
        System.out.println("默认方式排序: ");
        array.stream().sorted().forEach(System.out::println);
        System.out.println("实现Comparator接口: ");
        array.stream().sorted((str1, str2)->{
            int num = str1.length() - str2.length();
            int num2 = num==0?str1.compareTo(str2):num;
            return num2;
        }).forEach(System.out::println);


        System.out.println("-------");
        Stream<String> stream = array.stream().filter(s->s.startsWith("z"));
        // 将流中操作完的数据回收到List中 toList()、toSet()
        List<String> list = stream.collect(Collectors.toList());
        for(String str: list)
            System.out.println(str);
        System.out.println("-------");

        // 回收到Map中，toMap(Function KeyMapper, Function ValueMapper)
        String[] string = {"林青霞,23", "张曼玉,25","王祖贤,29","柳岩,31"};
        Stream<String> strStream = Stream.of(string).filter(s->Integer.parseInt(s.split(",")[1])<30);
        Map<String, Integer> map = strStream.collect(Collectors.toMap(s->s.split(",")[0], s->Integer.parseInt(s.split(",")[1])));
        for(String s: map.keySet())
            System.out.println(s+" "+map.get(s));
    } 
}

