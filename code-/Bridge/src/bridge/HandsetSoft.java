package bridge;
//手机软件
public  abstract class HandsetSoft
{

    public abstract void Run();
}

//手机游戏
class HandsetGame extends HandsetSoft
{
    public  void Run()
    {
        System.out.println("运行手机游戏");
    }
}

//手机通讯录
class HandsetAddressList extends HandsetSoft
{
    public  void Run()
    {
    	System.out.println("运行手机通讯录");
    }
}

//手机MP3播放
class HandsetMP3 extends HandsetSoft
{
    public  void Run()
    {
    	System.out.println("运行手机MP3播放");
    }
}



