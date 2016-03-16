package command;

class Invoker {
	private Command command;
	public void setCommand(Command command) {
		this.command = command;
	}
	public void action(){
		this.command.execute();
	}
}

abstract class Command {
	public abstract void execute();
}

class ConcreteCommand extends Command {
	private Receiver receiver;
	public ConcreteCommand(Receiver receiver){
		this.receiver = receiver;
	}
	public void execute() {
		this.receiver.doSomething();
	}
}

class Receiver {
	public void doSomething(){
		System.out.println("接受者-业务逻辑处理");
	}
}

public class Client {
	public static void main(String[] args){
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		//客户端直接执行具体命令方式（此方式与类图相符）
		command.execute();

		//客户端通过调用者来执行命令
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();
	}
}


//Invoker	相当于服务员，接收命令，并通知Receiver执行
//Receiver	相当于厨师，执行具体的命令
//Command	相当于订单，需要指定厨师Receiver
