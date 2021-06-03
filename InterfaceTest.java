public class InterfaceTest{
	public static void main(String[] args){
		Object[] objects = {new Tiger(), new Chicken(), new Apple()}; //
		for(int i=0; i<objects.length; i++){
			if(objects[i] instanceof Edible)
				// 注意这里的对象转换
				System.out.println(((Edible)objects[i]).howToEat());
		}
	}
}

// 定义一个接口
interface Edible{
	public final static int K = 0;
	public abstract String howToEat();
}

class Animal{
}

class Chicken extends Animal implements Edible{
	public String howToEat(){
		return "Chicken: Fry it";
	}
}

class Tiger extends Animal{
}

abstract class Fruit implements Edible{
	// 继承了接口，但是没重写内部方法，则必须定义为抽象类
}

class Apple extends Fruit{
	public String howToEat(){  // 子类必须实现方法
		return "Apple: Make apple cider";
	}
}