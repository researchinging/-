//装饰者与被装饰者的共同父类

package decorator;

public abstract class Humburger {
	
	protected  String name ;
	
	public String getName(){
		return name;
	}
	
	public abstract double getPrice();

}
