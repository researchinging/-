package iterator;

import java.util.ArrayList;
import java.util.List;

interface Iterator {
	public Object next();
	public boolean hasNext();
}
class ConcreteIterator implements Iterator{
	private List list = new ArrayList();
	private int cursor =0;
	public ConcreteIterator(List list){
		this.list = list;
	}
	public boolean hasNext() {
		if(cursor==list.size()){
			return false;
		}
		return true;
	}
	public Object next() {
		Object obj = null;
		if(this.hasNext()){
			obj = this.list.get(cursor++);
		}
		return obj;
	}
}
interface Aggregate {
	public void add(Object obj);
	public void remove(Object obj);
	public Iterator iterator();
}
class ConcreteAggregate implements Aggregate {
	private List list = new ArrayList();
	public void add(Object obj) {
		list.add(obj);
	}

	public Iterator iterator() {
		return new ConcreteIterator(list);
	}

	public void remove(Object obj) {
		list.remove(obj);
	}
}
public class Client {
	public static void main(String[] args){
		Aggregate ag = new ConcreteAggregate();
		ag.add("С��");
		ag.add("С��");
		ag.add("С��");
		Iterator it = ag.iterator();
		while(it.hasNext()){
			String str = (String)it.next();
			System.out.println(str);
		}
	}
}

