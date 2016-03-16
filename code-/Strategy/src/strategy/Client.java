package strategy;

interface IStrategy {
	public void doSomething();
}

class ConcreteStrategy1 implements IStrategy {
	public void doSomething() {
		System.out.println("�������1");
	}
}

class ConcreteStrategy2 implements IStrategy {
	public void doSomething() {
		System.out.println("�������2");
	}
}

class Context {
	private IStrategy strategy;
	
	public Context(IStrategy strategy){
		this.strategy = strategy;
	}
	
	public void execute(){
		strategy.doSomething();
	}
}

public class Client {
	public static void main(String[] args){
		Context context;
		System.out.println("-----ִ�в���1-----");
		context = new Context(new ConcreteStrategy1());
		context.execute();

		System.out.println("-----ִ�в���2-----");
		context = new Context(new ConcreteStrategy2());
		context.execute();
	}
}
