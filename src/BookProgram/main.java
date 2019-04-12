package BookProgram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main {
	public static void main(String [] args) throws IOException{

		Manager manager = new Manager();
		manager.run("command.txt");
	}
}
