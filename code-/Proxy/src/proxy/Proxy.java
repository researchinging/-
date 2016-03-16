package proxy;

public class Proxy implements Givegift{

	Pursuit gg;
	public Proxy(Schoolgirl mm){
		gg=new Pursuit(mm);
	}
	@Override
	public void GiveDolls() {
		// TODO Auto-generated method stub
		gg.GiveDolls();
	}

	@Override
	public void GiveFlowers() {
		// TODO Auto-generated method stub
		gg.GiveFlowers();
	}

	@Override
	public void GiveChocolates() {
		// TODO Auto-generated method stub
		gg.GiveChocolates();
	}

}
