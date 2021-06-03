import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args){
        boolean b = getPredicate("hello", s->s.length()>6);
        System.out.println(b);

        // 进行“与”操作
        boolean b2 = getPredicateLogical("hello", s->s.length()>6, s->s.length()>3);
        System.out.println(b2);
    }

    public static boolean getPredicate(String s, Predicate<String> p){
        return p.test(s);
        // return p.negate().test(s);  // "非"运算
    }

    public static boolean getPredicateLogical(String s, Predicate<String> p1, Predicate<String> p2){
        return p1.and(p2).test(s);
    }
}
