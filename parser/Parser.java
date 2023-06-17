
package parser; //  

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;
import java.lang.Integer.*;
import java.util.Arrays;
import java.util.Vector;
import simulator.*;
import aircraft.*;

public class Parser {
	String filename;
	String[] lines;
	final String[] valid_crafts = { "Baloon", "JetPlane", "Helicopter" };
	int timeline;

	public Parser() {
	}

	public Parser(String filename) {
		this.filename = filename;
		init();
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public String[] getLines() {
		return lines;
	}

	public int getTimeline() {
		return timeline;
	}

	private void setLines(String[] lines) {
		this.lines = lines;
	}

	private void readerlines(File input) {
		try {
			Scanner find_len = new Scanner(input);
			Scanner writer = new Scanner(input);
			int i = 0;
			while (find_len.hasNextLine()) {
				String data = find_len.nextLine();
				i++;
			}
			lines = new String[i];
			i = 0;
			while (writer.hasNextLine()) {
				String data = writer.nextLine();
				lines[i] = data.trim();
				i++;
			}
			writer.close();
			find_len.close();
		} catch (FileNotFoundException e) {
			System.out.println("could not read file");
			e.printStackTrace();
		}
	}

	public void printlines() {
		for (int i = 0; i < lines.length; i++) {
			if (lines[i] == null) {
				break;
			}
			System.out.println(lines[i]);
		}
	}

	private int simulationTimeline() {
		if (lines[0].matches("[0-9]+") == false) {
			System.out.println("first line must be an integer");
			System.exit(1);

		}
		timeline = Integer.parseInt(lines[0]);
		return timeline;
	}

	private String[] line_to_craft(int index) {
		String[] elements = lines[index].split(" ");

		if (elements.length != 5) {
			System.out.println("number of args  at line " + index + " is incorrect");
			System.out.println(index);

			System.exit(1);
		}
		if (validate_craft(elements) == false) {
			System.exit(1);
		}
		return elements;
	}

	private boolean validate_craft(String[] elements) {
		// convert array to list and check if it contains the string
		if (Arrays.asList(valid_crafts).contains(elements[0]) == false) {
			System.out.println("invalid craft Name");
			return false;
		}
		if (elements[1].matches("^[A-Za-z][0-9]$") == false) {
			System.out.println("invalid craft id");
			return false;
		}
		for (int i = 2; i < 5; i++) {
			if (elements[i].matches("[0-9]+") == false) {
				System.out.println("invalid craft coordinates");
				return false;
			}
		}
		return true;
	}

	private Coordinates get_coordinates(String[] elements) {
		return new Coordinates(Integer.parseInt(elements[2]),
				Integer.parseInt(elements[3]), Integer.parseInt(elements[4]));
	}

	// return <flyable> object list
	private flyable crafters(String[] elements, aircraftfactory aircraftfactory) {

		if (elements[0].equals("Baloon")) {
			return aircraftfactory.newBalloon(elements[1], get_coordinates(elements));
		} else if (elements[0].equals("JetPlane")) {
			return aircraftfactory.newJetplane(elements[1], get_coordinates(elements));
		} else if (elements[0].equals("Helicopter")) {
			return aircraftfactory.newHelicopter(elements[1], get_coordinates(elements));
		}
		return null;
	}

	// return <flyable> object list
	public  Vector<flyable> init() {
		Vector<flyable> aircrafts = new Vector<flyable>();
		aircraftfactory aircraftfactory = new aircraftfactory();
		readerlines(new File(filename));
		simulationTimeline();
		for (int i = 1; i < lines.length; i++) {
			if (lines[i] == null) {
				break;
			}

			flyable craft = crafters(line_to_craft(i), aircraftfactory);
			if (craft != null) {
				aircrafts.add(craft);
			} else {
				// #TODO: handle this error
				System.out.println("craft is null");

			}
		}
		
		return aircrafts;
	}
}
