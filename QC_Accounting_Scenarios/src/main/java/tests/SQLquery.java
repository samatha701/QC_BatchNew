package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;

public class SQLquery extends QCStore{

	public static void proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//System.out.println("before conn");
		// Open a connection
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", Sprop.getProperty("db_username"),
					Sprop.getProperty("db_password"));
			test.log(LogStatus.PASS, "Connecting to DB ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_nbr="10507593";
		try {
		
			resultSet = stmt.executeQuery("SELECT LOAN_TRAN_CODE,TRAN_ID FROM st_lo_trans where loan_code="+loan_nbr);
			test.log(LogStatus.PASS, "Executing the query with loan number"+loan_nbr);
			
			
			while (resultSet .next())
			{
				 rowValues.add(resultSet.getString(2)); 
				 test.log(LogStatus.PASS, "Getting values from the tables TRAN_ID and LOAN_TRAN_Code with the loan number"+loan_nbr);
				 System.out.println(
						resultSet .getString(1) + "  " +
									  resultSet.getString(2)/* + "  " +
									  resultSet.getString(3) + "  " +
									  resultSet.getString(4) + "  " +
									  resultSet.getString(5)
									 */);
			}
			 
			 
			System.out.println("after query");
			
			for(String value: rowValues)
			{
				System.out.println("verifying values"+ value);
				test.log(LogStatus.PASS, "Verifying values in TRAS_ID table "+value);
				if(value.equalsIgnoreCase("DP"))
				{
					System.out.println("Value DP is present");
					test.log(LogStatus.PASS, "Value DP present in TRAS_ID table ");
					
				}
				else if(value.equalsIgnoreCase("PPay"))
				{
					System.out.println("Value PPay is present");
					test.log(LogStatus.FAIL, "Value PPay present in TRAS_ID table ");
					
				}
			}

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
		} 
		catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

}
