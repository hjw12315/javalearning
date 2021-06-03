package enumerated;

enum Search { HITHER, YON }

public class UpcastEnum {
    public static void main(String[] args){
        Search[] vals = Search.values();
        Enum e = Search.HITHER;  // 向上转型之后不能调用values()获取元素,但是可以通过下面的反射获取里面的元素
        for(Enum en: e.getClass().getEnumConstants()){
            System.out.println(en);
        }
    }
}
