import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.CallableStatement;

public class getProductById {

	public static void main(String[] args)  throws Exception{
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String user = "root";
		String password = "Vikas@7720";
		String query = "{call getProductById(?) }";
		
		int Id = 102;
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		CallableStatement stmt = (CallableStatement) con.prepareCall(query);
		stmt.setInt(1, Id);
		
		System.out.println("Id"+"\t"+"Name"+"\t"+"Price");
		System.out.println("----"+"\t"+"----"+"\t"+"----");
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		}
		con.close();
		
			

	}

}
