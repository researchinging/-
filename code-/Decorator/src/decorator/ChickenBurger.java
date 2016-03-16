//±»×°ÊÎÕß

package decorator;

public class ChickenBurger extends Humburger {
	
	public ChickenBurger(){
		name = "¼¦ÍÈ±¤";
	}

	@Override
	public double getPrice() {
		return 10;
	}

}
