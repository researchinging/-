package mySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	public static void main(String args[]){
		String url="jdbc:mysql://localhost:3306/eleventh";
		String user="root";
		String passwd="1";
		String sql1="select * from food";
		String sql2="insert into food values(NULL,'DD','XUSHI',4.0,2008,3,'somewhere')";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,passwd);
			System.out.println("���ӷ������ɹ�");
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql1);
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String company=rs.getString("company");
				
				System.out.println(id+"  "+name+"  "+company);
			}
			int i=stat.executeUpdate(sql2);
			if(0!=i){
				System.out.println("����ɹ�");
			}
			
			if(null!=rs){
				rs.close();
				rs=null;
			}
			if(null!=stat){
				stat.close();
				stat=null;
			}
			if(null!=con){
				con.close();
				con=null;
			}
		}
		catch(ClassNotFoundException e){
			System.out.print("û���ҵ�����");
		}
		catch(SQLException e){
			System.out.print("û���ҵ�������");
		}
		
		
	}

}
