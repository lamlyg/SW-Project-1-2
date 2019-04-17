package BookProgram;

/*
@class Manager
@date 2019/04/17~04/27
@author 이윤지(컴퓨터정보공학부 2017202085)
@brief 소프트웨어프로젝트 1-2 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Manager {

	FileReader filereader = null;
	FileWriter filewriter = null;

	BufferedReader fin;	//input stream ( for BookList.txt, command.txt )
	BufferedWriter flog; //output stream  (for log.txt )

	public Manager() throws IOException {//constructor

	}

	//Argument - cmd : file name which is opened
	public void run(String cmd) throws IOException{

		try {

			filereader = new FileReader(cmd);
			fin = new BufferedReader(filereader);
			String s = null;
			String command=null;
			String collection;
			String data="";
			String result="";
			String temp1="";
			String temp2="";
			/*Decode command*/
			while(!(s=fin.readLine()).equals("EXIT")) {

				StringTokenizer st = new StringTokenizer(s, " ");

				int countTokens = st.countTokens();

				System.out.println(countTokens);

				command= st.nextToken();//i==0 (get command)

				if(command.equals("ADD")) {/*If the command is "ADD"*/
					System.out.println("command : "+command);
					data=st.nextToken();

					System.out.println("data : "+data);
					System.out.println(s);
				}
				else if(command.equals("PRINT")) {/*If the command is "PRINT"*/
					System.out.println("command : "+command);
					collection = st.nextToken();//i==1 (get the kind of collection)
					System.out.println("collection : "+collection);
					System.out.println(s);

				}
				else if(command.equals("SEARCH")) {/*If the command is "SEARCH"*/
					System.out.println("command : "+command);

					collection = st.nextToken();//i==1 (get the kind of collection)
					System.out.println("collection : "+collection);
					
					////start: Get 'data' argument of command 'SEARCH'////
					temp1=st.nextToken();//i==2
					for(int i=3;i<countTokens;i++) {
						temp2=st.nextToken();
						temp2=" "+temp2;
					}
					data = temp1 + temp2;
					////end: Get 'data' argument of command 'SEARCH'////
					
					
					System.out.println("data : "+data);
					System.out.println(s);


				}
				else if(command.equals("UPDATE")) {/*If the command is "UPDATE"*/
					System.out.println("command : "+command);

					System.out.println(s);

				}
				else if(command.equals("EXIT")) {/*If the command is "EXIT"*/
					System.out.println("command : "+command);			

					System.out.println(s);

				}
				else {/*If the command is unknown*/
					System.out.println("command : "+command);	
				}

			}
			fin.close();
			//flog.close();

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(fin != null) try {fin.close();}catch(IOException e) {}
		}
	}

	public boolean ADD() throws IOException{
		return true;
	}
	public boolean PRINT() throws IOException{

		return true;
	}
	public boolean SEARCH() throws IOException{

		return true;
	}
	public boolean UPDATE() throws IOException{

		return true;
	}
}
