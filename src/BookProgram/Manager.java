package BookProgram;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Manager {

	BufferedReader fin;	//input stream ( for BookList.txt, command.txt )
	BufferedWriter flog; //output stream  (for log.txt )
	
	public Manager() throws IOException {
 
	}

	public void run(String cmd) throws IOException{
					
		while(/*Until the command call EXIT*/) {
						
			/*Decode command*/
			if(/*If the command is "ADD"*/) {
				
			}
			else if(/*If the command is "PRINT"*/) {
			
			}
			else if(/*If the command is "SEARCH"*/) {
			
			}
			else if(/*If the command is "UPDATE"*/) {
				
			}
			else if(/*If the command is "EXIT"*/) {
			
			}else {
				/*If the command is unknown*/
			}
		}
		fin.close();
		flog.close();
	}
	
	public boolean ADD() throws IOException{

	}
	public boolean PRINT() throws IOException{
		
	}
	public boolean SEARCH() throws IOException{
		
	}
	public boolean UPDATE() throws IOException{
		
	}
}
