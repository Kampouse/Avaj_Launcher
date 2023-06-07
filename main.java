import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import parser.*;
import simulator.*;

public class main {
  public static void main(String[] args) {

    Parser parser = new Parser();
    if (args.length < 1) {
      System.out.println("Usage: java  program  <input file> ");
      System.exit(1);
    }

    try {
      // if there were more than one file could be a loop
      parser.setFilename(args[0]);
      parser.init();
      Simulator simulator = new Simulator(parser);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
