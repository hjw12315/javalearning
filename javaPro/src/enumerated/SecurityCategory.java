package enumerated;


import java.util.Arrays;

enum SecurityCategory {
    STOCk(Security.Stock.class), BOND(Security.Bond.class);
    Security[] values;
    private SecurityCategory(Class<? extends Security> kind){
        values = kind.getEnumConstants();  // 枚举的枚举值
        System.out.println(Arrays.toString(values));
    }

    interface Security{
        enum Stock implements Security{ SHORT, LONG, MARGIN }
        enum Bond implements Security{  MUNICIPAL, JUNK }
    }

    public Security randomSelect(){
        return Enums.random(values);
    }
    public static void main(String[] args){
        for(int i=0; i<10; i++){
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelect());
        }
    }

}
