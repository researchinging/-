package proxy;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Schoolgirl jiaojiao=new Schoolgirl();
		jiaojiao.setName("¿ÓΩøΩø");
		
		Proxy daili=new Proxy(jiaojiao);
		daili.GiveDolls();
		daili.GiveFlowers();
		daili.GiveChocolates();
	}

}
