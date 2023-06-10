
package simulator; //  

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;
import java.lang.Integer.*;
import java.util.Arrays;
import java.util.Vector;
import parser.Parser;
import aircraft.*;

public class Simulator {
	Vector<aircraft> aircrafts;
	int timeline;

	public Simulator(Parser parser) {
		aircrafts = parser.init();
		timeline = parser.getTimeline();
	
		

	}
}
