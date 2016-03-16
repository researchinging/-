package mySQL;

import java.io.IOException;

public class DB_backup_load {
	private static String str=null;
	public static void backup() {

		str="mysql -uroot -p1 --opt eleventh >c:/eleventh.sql";
		Runtime rt=Runtime.getRuntime();
		try {
			rt.exec("cmd /c"+str);
			System.out.println("备份成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("备份失败");
			
		}
		
	}
	public static void load() {
		
		str="mysql -uroot -p1 eleventh <c:/eleventh.sql";
		Runtime rt=Runtime.getRuntime();
		try {
			rt.exec("cmd /c"+str);
			System.out.println("还原成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("还原失败");
			
		}
		
	}
	


}
