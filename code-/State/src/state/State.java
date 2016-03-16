package state;

public abstract class State {
	abstract void WriteProgram(Work w);
}

//上午工作状态
class ForenoonState extends State
{
    public  void WriteProgram(Work w)
    {
        if (w.hour < 12)
        {
           System.out.println("当前时间："+ w.hour+"点 上午工作，精神百倍");
        }
        else
        {
            w.SetState(new NoonState());
            w.WriteProgram();
        }
    }
}

//中午工作状态
class NoonState extends State
{
    public  void WriteProgram(Work w)
    {
        if (w.hour < 13)
        {
        	System.out.println("当前时间："+ w.hour+"点 饿了，午饭；犯困，午休。");
        }
        else
        {
            w.SetState(new AfternoonState());
            w.WriteProgram();
        }
    }
}

//下午工作状态
class AfternoonState extends State
{
    public  void WriteProgram(Work w)
    {
        if (w.hour < 17)
        {
        	System.out.println("当前时间："+ w.hour+"点 下午状态还不错，继续努力");
        }
        else
        {
            w.SetState(new EveningState());
            w.WriteProgram();
        }
    }
}

//晚间工作状态
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
            	System.out.println("当前时间："+ w.hour+"点 加班哦，疲累之极");
            }
            else
            {
                w.SetState(new SleepingState());
                w.WriteProgram();
            }
        }
    }
}

//睡眠状态
class SleepingState extends State
{
    public  void WriteProgram(Work w)
    {
    	System.out.println("当前时间："+ w.hour+"点 不行了，睡着了。");
    }
}

//下班休息状态
class RestState extends State
{
    public  void WriteProgram(Work w)
    {
    	System.out.println("当前时间："+ w.hour+"点 下班回家了");
    }
}
