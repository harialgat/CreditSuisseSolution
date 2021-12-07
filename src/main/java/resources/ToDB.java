package resources;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ToDB {
	// make the connection with the database
	static Connection con;
	static String connectionString = "jdbc:hsqldb:file:db-data/mydatabase";
	static PreparedStatement stmt;

	// this method will calculate the time between two similar event ids and status
	// started and finished, also will insert into db
	public static void toDB(ArrayList<Event> l) throws SQLException {
		try {
			String createEvents = readToString("C:\\Users\\Sanket\\Desktop\\CreditSuisseTest\\src\\sql\\Events.sql");
			System.out.println("Attempting to create contacts DB ... ");

			Class.forName("org.hsqldb.jdbc.JDBCDriver");

			con = DriverManager.getConnection(connectionString, "SA", "");

			// create table
			con.createStatement().executeUpdate(createEvents);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < l.size(); j++) {
				if (i == j) {
					continue;
				} else if (l.get(i).getId().equals(l.get(j).getId()) && l.get(i).getState().equals("STARTED")) {
					long t1 = Long.parseLong(l.get(i).getTimestamp());
					long t2 = Long.parseLong(l.get(j).getTimestamp());
					boolean flag = false;
					if (t2 - t1 > 4) {
						flag = true;
					}
					// create statement and insert into db
					String sql = "INSERT INTO Events VALUES (?,?,?,?,?)";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, l.get(i).getId());
					stmt.setInt(2, (int) (t2 - t1));
					stmt.setString(3, l.get(i).getType());
					stmt.setString(4, l.get(i).getHost());
					stmt.setBoolean(5, flag);
					System.out.println("Inserted into db");
				}
			}
		}
	}

	public static String readToString(String fname) throws Exception {
		File file = new File(fname);
		String string = FileUtils.readFileToString(file, "utf-8");
		return string;
	}
}
