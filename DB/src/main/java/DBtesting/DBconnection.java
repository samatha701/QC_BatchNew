package DBtesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.relevantcodes.extentreports.LogStatus;

public class DBconnection extends QCStore{

	public static void connection(String SSN,String Appurl) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QCHPROD_QTP_03122019",
					"QCHPROD_QTP_03122019");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {
		
			resultSet = stmt.executeQuery("select SSN,FIRST_NAME,LAST_NAME,DRIVERS_LIC_NUM from bo_master where SSN='"+SSN+"'");
			

			 while (resultSet .next())
			{
				 SSN_DB=resultSet .getString(1);
				 first_name_db=resultSet .getString(2);
				 last_name_db=resultSet .getString(3);
				 drivers_lin_db=resultSet .getString(4);
				 test.log(LogStatus.PASS, "SSN retrieved from the DB is "+resultSet .getString(1));
				 test.log(LogStatus.PASS, "first_name_db retrieved from the DB is "+resultSet .getString(2));
				 test.log(LogStatus.PASS, "last_name_db retrieved from the DB is "+resultSet .getString(3));
				 test.log(LogStatus.PASS, "drivers_lin_db retrieved from the DB is "+resultSet .getString(4));
				 
				 
				 
				System.out.println(
						resultSet .getString(1) + "  " +
									  resultSet.getString(2) + "  " +
									 resultSet.getString(3) + "  " +
									  resultSet.getString(4) + "  " /* +
									* resultSet.getString(5)
									 */);
			}
			 
			 
			// 
			 
	        	

	        	
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			System.out.println("after query");

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

}
