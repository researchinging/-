//��װ����

package decorator;

public class ChickenBurger extends Humburger {
	
	public ChickenBurger(){
		name = "���ȱ�";
	}

	@Override
	public double getPrice() {
		return 10;
	}

}
