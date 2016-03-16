package calculater;

public abstract class Operation {

	public double NumA;
	public double NumB;

	public double getNumA() {
		return NumA;
	}

	public void setNumA(double numA) {
		NumA = numA;
	}

	public double getNumB() {
		return NumB;
	}

	public void setNumB(double numB) {
		NumB = numB;
	}

	public abstract double getresult() throws Exception;
	
}

class OperationAdd extends Operation{

	@Override
	public double getresult() {
		return NumA+NumB;
	}
	
}

class OperationSub extends Operation{
	
	@Override
	public double getresult() {
		return NumA-NumB;
	}
	
}
class OperationMul extends Operation{
	
	@Override
	public double getresult() {
		return NumA*NumB;
	}
	
}

class OperationDiv extends Operation{
	
	@Override
	public double getresult() throws Exception {
		if(NumB==0)
			throw new Exception("除数不能为0");
		return NumA/NumB;
	}
	
}