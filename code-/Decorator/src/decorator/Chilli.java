package decorator;

public class Chilli extends Condiment {
	
	Humburger humburger;
	
	public Chilli(Humburger humburger){
		this.humburger = humburger;
		
	}

	@Override
	public String getName() {
		return humburger.getName()+" ������";
	}

	@Override
	public double getPrice() {
		return humburger.getPrice();  //��������ѵ�Ŷ
	}

}
