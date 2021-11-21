import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TrasactionManaganment {

	public static void main(String[] args) throws Exception {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/account";
		String user = "root";
		String password = "Vikas@7720";
		
		String sql1 = "UPDATE account SET  balance = balance-2000 WHERE accno = 22";
		String sql2 = "UPDATE account SET balance = balance+2000 WHERE accno = 11";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		con.setAutoCommit(false);
		
		Statement stmt = con.createStatement();
		stmt.addBatch(sql1);
		stmt.addBatch(sql2);
		
		int[] x = stmt.executeBatch();
		
		System.out.println(x[0] + " "+x[1]);
		if(x[0] == 1 && x[1] == 1) {
			con.commit();
			System.out.println("Trasaction successful");
		}else {
			con.rollback();
			System.out.println("Trasaction failed!");
		}
		con.close();
 
	}

}
