package inheritance;

public class Mankind {
    private int sex;
    int salary;

//    public Mankind(int sa){
//        this.sa = sa;
//    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void manOrwoman(){
        if(sex==1)
            System.out.println("man");
        else if(sex==0)
            System.out.println("woman");
    }

    public void employeed(){
//        if(salary==0)
//            System.out.println("no job");
//        else
//            System.out.println("job");
        String ret = salary==0? "no job": "job";
        System.out.println(ret);
    }

    public void eat(){
        System.out.println("abc");
    }
}
