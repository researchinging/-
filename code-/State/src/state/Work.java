package state;

public class Work {
	public int hour;
	public boolean finished;
	private State current;
	
	public State getCurrent() {
		return current;
	}
	public void setCurrent(State current) {
		this.current = current;
	}
	public void SetState(State s) {
		current=s;
	}
	public void WriteProgram() {
		current.WriteProgram(this);
	}

}
