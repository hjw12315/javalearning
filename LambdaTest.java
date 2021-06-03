import java.util.Arrays;

public class LambdaTest {
    public static void main(String[] args){
        String[] planets = new String[]{"Mercury","Venus","Earth","Mars",
                "Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        Arrays.sort(planets, (first, second)->first.length()-second.length());
        System.out.println(Arrays.toString(planets));
    }
}
