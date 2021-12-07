package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import resources.Event;
import resources.Logic;
import resources.ToDB;

public class Test {
	public static void main(String str[]) {
		ArrayList<Event> l = Logic.startExecution();
		try {
			ToDB.toDB(l);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
