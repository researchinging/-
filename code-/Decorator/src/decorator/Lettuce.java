package decorator;

public class Lettuce extends Condiment {
	
	Humburger humburger;
	
	public Lettuce(Humburger humburger){
		this.humburger = humburger;
	}

	@Override
	public String getName() {
		return humburger.getName()+" ������";
	}

	@Override
	public double getPrice() {
		return humburger.getPrice()+1.5;
	}

}
