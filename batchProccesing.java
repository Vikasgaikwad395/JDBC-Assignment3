import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class batchProccesing {

	public static void main(String[] args) throws Exception {
		
			
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/vgdb";
			String user = "root";
			String password = "Vikas@7720";
			
			String queries[] = {
					"INSERT INTO employee VALUES (1001,'Ram',50000)",
					"INSERT INTO employee VALUES (1002,'Sham',60000)",
					"INSERT INTO employee VALUES (1003,'Gopal',65000)",
					"INSERT INTO employee VALUES (1004,'Chatur',90000)",
					"INSERT INTO employee VALUES (1005,'Kranti',85000)",
					"INSERT INTO employee VALUES (1006,'Dipti',55000)",
					"INSERT INTO employee VALUES (1007,'Sunita',35000)",
					"INSERT INTO employee VALUES (1008,'Raj',55000)",
					"INSERT INTO employee VALUES (1009,'Ninad',35000)",
					"INSERT INTO employee VALUES (1010,'Parth',58000)",					
					
			};
			
						
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement st = con.createStatement();
			
			for(String query : queries) {
				st.addBatch(query);
			}
			int [] result = st.executeBatch();
			System.out.println("Batch is executed:  "+result.length);
					
			st.close();
			con.close();
			
	}

}
