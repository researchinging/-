package factory;

class Engine {
	public void getStyle(){
		System.out.println("这是汽车的发动机");
	}
}
class Underpan {
	public void getStyle(){
		System.out.println("这是汽车的底盘");
	}
}
class Wheel {
	public void getStyle(){
		System.out.println("这是汽车的轮胎");
	}
}

class ICar{
	private Engine e;
	private Underpan u;
	private Wheel w;
	public ICar(Engine e, Underpan u, Wheel w) {
		super();
		this.e = e;
		this.u = u;
		this.w = w;
	}
	public void show() {
		// TODO Auto-generated method stub
		e.getStyle();
		u.getStyle();
		w.getStyle();
	}
	
}
interface IFactory {
	public ICar createCar();
}
class Factory implements IFactory {
	public ICar createCar() {
		Engine engine = new Engine();
		Underpan underpan = new Underpan();
		Wheel wheel = new Wheel();
		ICar car = new ICar(engine,underpan, wheel );
		return car;
	}
}
public class Client {
	public static void main(String[] args) {
		IFactory factory = new Factory();
		ICar car = factory.createCar();
		car.show();
	}
}
