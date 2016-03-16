package prototype;

import java.util.ArrayList;

//ǳ����
class Prototype implements Cloneable {
	public ArrayList list;

	public Prototype clone(){
		Prototype prototype = null;
		try{
			prototype = (Prototype)super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return prototype; 
	}
}

//���
class Prototype2 implements Cloneable {
	private ArrayList list = new ArrayList();
	public Prototype clone(){
		Prototype prototype = null;
		try{
			prototype = (Prototype)super.clone();
			prototype.list = (ArrayList) this.list.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return prototype; 
	}
}
class ConcretePrototype extends Prototype{
	public void show(){
		System.out.println("ԭ��ģʽʵ����");
	}
}

public class Client {
	public static void main(String[] args){
		ConcretePrototype cp = new ConcretePrototype();
		for(int i=0; i< 10; i++){
			ConcretePrototype clonecp = (ConcretePrototype)cp.clone();
			clonecp.show();
		}
	}
}
