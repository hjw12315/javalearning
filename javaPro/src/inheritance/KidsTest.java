package inheritance;

public class KidsTest {
    public static void main(String[] args){
        Kids someKid = new Kids();  // 这里不用导入Kids类，直接就能用了？
        someKid.printAge();
        someKid.setSex(1);    // 虽然sex是private，但是 Kids 也继承了sex,但是不能直接访问
        someKid.salary = 10;
        someKid.employeed();
        someKid.manOrwoman();
        someKid.eat();
    }
}
