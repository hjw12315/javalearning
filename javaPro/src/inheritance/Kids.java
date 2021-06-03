package inheritance;

public class Kids extends Mankind{
    int yearsOld;  // 属性会自动赋默认初值

//    public Kids(){
//
//    }
//    public Kids(int qa){
//        this.qna = qa;
//    }

    public void printAge(){
        System.out.println(yearsOld);
    }

    public void eat(){
        System.out.println("...");
        super.eat();
    }

}
