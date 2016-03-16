package composite;

import java.util.ArrayList;
import java.util.List;

public  abstract class Component
{
    protected String name;

    public Component(String name)
    {
        this.name = name;
    }

    public abstract void Add(Component c);
    public abstract void Remove(Component c);
    public abstract void Display(int depth);
}

class Composite extends Component
{
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name)
    { super(name);}

    public  void Add(Component c)
    {
        children.add(c);
    }

    public  void Remove(Component c)
    {
        children.remove(c);
    }

    public  void Display(int depth)
    {
    	for(int j=0;j<depth;j++) System.out.print('-');
        System.out.println(name);

        for(int i=0;i<children.size();i++){
        	Component p=(Component)children.get(i);
            p.Display(depth + 2);
        }
    }
}

class Leaf extends Component
{
    public Leaf(String name)
    { super(name);}

    public  void Add(Component c)
    {
    	System.out.println("Cannot add to a leaf");
    }

    public  void Remove(Component c)
    {
    	System.out.println("Cannot remove from a leaf");
    }

    public  void Display(int depth)
    {
    	for(int j=0;j<depth;j++) System.out.print('-');
        System.out.println(name);
    }
}


