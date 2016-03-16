package state;

public abstract class State {
	abstract void WriteProgram(Work w);
}

//���繤��״̬
class ForenoonState extends State
{
    public  void WriteProgram(Work w)
    {
        if (w.hour < 12)
        {
           System.out.println("��ǰʱ�䣺"+ w.hour+"�� ���繤��������ٱ�");
        }
        else
        {
            w.SetState(new NoonState());
            w.WriteProgram();
        }
    }
}

//���繤��״̬
class NoonState extends State
{
    public  void WriteProgram(Work w)
    {
        if (w.hour < 13)
        {
        	System.out.println("��ǰʱ�䣺"+ w.hour+"�� ���ˣ��緹�����������ݡ�");
        }
        else
        {
            w.SetState(new AfternoonState());
            w.WriteProgram();
        }
    }
}

//���繤��״̬
class AfternoonState extends State
{
    public  void WriteProgram(Work w)
    {
        if (w.hour < 17)
        {
        	System.out.println("��ǰʱ�䣺"+ w.hour+"�� ����״̬����������Ŭ��");
        }
        else
        {
            w.SetState(new EveningState());
            w.WriteProgram();
        }
    }
}

//��乤��״̬
class EveningState extends State
{
    public  void WriteProgram(Work w)
    {
        if (w.finished)
        {
            w.SetState(new RestState());
            w.WriteProgram();
        }
        else
        {
            if (w.hour < 21)
            {
            	System.out.println("��ǰʱ�䣺"+ w.hour+"�� �Ӱ�Ŷ��ƣ��֮��");
            }
            else
            {
                w.SetState(new SleepingState());
                w.WriteProgram();
            }
        }
    }
}

//˯��״̬
class SleepingState extends State
{
    public  void WriteProgram(Work w)
    {
    	System.out.println("��ǰʱ�䣺"+ w.hour+"�� �����ˣ�˯���ˡ�");
    }
}

//�°���Ϣ״̬
class RestState extends State
{
    public  void WriteProgram(Work w)
    {
    	System.out.println("��ǰʱ�䣺"+ w.hour+"�� �°�ؼ���");
    }
}
