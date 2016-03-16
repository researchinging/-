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
		System.out.println("������-ҵ���߼�����");
	}
}

public class Client {
	public static void main(String[] args){
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		//�ͻ���ֱ��ִ�о������ʽ���˷�ʽ����ͼ�����
		command.execute();

		//�ͻ���ͨ����������ִ������
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();
	}
}


//Invoker	�൱�ڷ���Ա�����������֪ͨReceiverִ��
//Receiver	�൱�ڳ�ʦ��ִ�о��������
//Command	�൱�ڶ�������Ҫָ����ʦReceiver
