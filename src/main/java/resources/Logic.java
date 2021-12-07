package resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {
	// this method will read the txt file and will convert json objects to java
	// objects
	public static ArrayList<Event> startExecution() {
		ArrayList<Event> list = new ArrayList<Event>();
		try {
			File file = new File("logfile.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String str = sc.nextLine();
				Event e = new Event(getValue(str, "id"), getValue(str, "state"), getValue(str, "type"),
						getValue(str, "host"), getValue(str, "timestamp"));

				list.add(e);

			}

		} catch (Exception r) {
			System.out.println(r.getMessage());
		}

		return list;
	}

	public static String getValue(String str, String temp) {
		if (str.contains(temp) && !(temp.equals("timestamp"))) {
			int i = str.indexOf(temp);
			String out = "";
			for (int j = i + temp.length() + 3; j < str.length(); j++) {
				if (str.charAt(j) == '"') {
					break;
				}
				out += str.charAt(j);
			}
			return out;
		} else if (str.contains(temp) && temp.equals("timestamp")) {
			int i = str.indexOf(temp);
			String out = "";
			for (int j = i + temp.length() + 2; j < str.length() - 1; j++) {

				out += str.charAt(j);
			}
			return out;
		} else {
			return "";
		}
	}
}
