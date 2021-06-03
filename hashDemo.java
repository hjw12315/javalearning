public class hashDemo {
    public static void main(String[] args){

        var s1 = new StudentCollection("林青霞", 23);
        System.out.println(s1.hashCode());

        var s2 = new StudentCollection("林青霞", 23);
        System.out.println(s2.hashCode());

        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());
    }
    
}
