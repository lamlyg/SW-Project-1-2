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

	File file;
	File log = new File("log.txt");
	
	BufferedReader fin;	//input stream ( for BookList.txt, command.txt )
	BufferedWriter flog = new BufferedWriter(new FileWriter(log,true));//output stream  (for log.txt )

	public Manager() throws IOException {//constructor
	}

	//Argument - cmd : file name which is opened
	public void run(String cmd) throws IOException{
		
		file = new File(cmd);
		
		if(file.exists()) {
			try {
				fin = new BufferedReader(new FileReader(file));
//
//				FileWriter log = new FileWriter("log.txt",false);
				
				String s;
				String command;//use in getting command
				String collection;//use in getting collection info
				String data="";//use in getting data
				String temp1="";//use in getting data
				String temp2="";//use in getting data

				StringTokenizer st; //used in token
				StringTokenizer datatoken;//use in tokening ADD argument by '/'
				int countTokens=0;
				int i=0;

				/*Decode command*/
				while((s=fin.readLine())!=null) {
					
					//solve the error : can't read command of the first sentence//
					String text = new String(s.getBytes(),"utf-8");				//
					text = text.replace("\uFEFF", "");							//
					//solve the error : can't read command of the first sentence//

					st = new StringTokenizer(text, " ");//token the text in text file
					System.out.println(s);

					command= st.nextToken();//(get command)
					System.out.println("command : "+command);

					if(command.equals("ADD")){/*If the command is "ADD"*/
						////start: Get 'data' argument of command 'ADD'////
						countTokens = st.countTokens();//the number of tokencount after command
						System.out.println(countTokens);

						if(countTokens>0) {//인자가 있는지 확인
							String temp[] = new String[countTokens];

							for(i=0;i<countTokens;i++) {
								temp[i]=st.nextToken();
								System.out.println(temp[i]);
							}

							for(i=0;i<countTokens-1;i++) {
								data = data+temp[i]+" ";
							}
							data=data+temp[i];
							////end: Get 'data' argument of command 'ADD'////
							System.out.println("data : "+data);
							System.out.println(s);
							
							
							flog.newLine();							
							flog.write("========= ADD =========");
							flog.newLine();
							//flog.write("+ "+data);
							flog.newLine();
							flog.write("=======================");
							flog.newLine();	
												
						}
						else {//Error case in 'ADD' : lack of argument 
							System.out.println("ERROR : 100");//-> log.txt로

							flog.newLine();
							flog.write("========= ERROR =========");
							flog.newLine();
							flog.write("100");
							flog.newLine();
							flog.write("=========================");
							flog.newLine();

						}
					}
					else if(command.equals("PRINT")){/*If the command is "PRINT"*/
						countTokens = st.countTokens();
						System.out.println(countTokens);

						if(countTokens==1) {//check the collection is existed
							collection = st.nextToken();//i==1 (get the kind of collection)
							System.out.println("collection : "+collection);
							if(collection.equals("AL")){//ArrayList
							}
							else if(collection.equals("LL")){//LinkedList
							}
							else if(collection.equals("HS")){//HashSet
							}
							else if(collection.equals("TS")){//TreeSet
							}
							else if(collection.equals("HM")){//HashMap
							}
							else if(collection.equals("TM")){//TreeMap
							}
							else {//incorrect collection
								System.out.println("ERROR : 200");
								flog.newLine();
								flog.write("========= ERROR =========");
								flog.newLine();
								flog.write("200");
								flog.newLine();
								flog.write("=========================");
								flog.newLine();
							}
						}
						else {
							System.out.println("ERROR : 200");
							flog.newLine();
							flog.write("========= ERROR =========");
							flog.newLine();
							flog.write("200");
							flog.newLine();
							flog.write("=========================");
							flog.newLine();
						}
						
						flog.newLine();
						flog.write("========= PRINT =========");
						flog.newLine();
						//flog.write("+ "+data);
						flog.newLine();
						flog.write("=========================");
						flog.newLine();
						

					}
					else if(command.equals("SEARCH")) {/*If the command is "SEARCH"*/
						countTokens = st.countTokens();
						System.out.println(countTokens);
						System.out.println(s);


						collection = st.nextToken();//i==1 (get the kind of collection)
						System.out.println("collection : "+collection);

						////start: Get 'data' argument of command 'SEARCH'////
						data="";
						temp1=st.nextToken();//i==2
						for(i=3;i<countTokens;i++) {
							temp2=st.nextToken();
							temp2=" "+temp2;
						}
						data = temp1 + temp2;
						////end: Get 'data' argument of command 'SEARCH'////

						System.out.println("data : "+data);

						if(collection.equals("AL")){//ArrayList
						}
						else if(collection.equals("LL")){//LinkedList
						}
						else if(collection.equals("HS")){//HashSet
						}
						else if(collection.equals("TS")){//TreeSet
						}
						else if(collection.equals("HM")){//HashMap
						}
						else if(collection.equals("TM")){//TreeMap
						}
						else {//ERROR : incorrect collection
							System.out.println("ERROR : 300");
							flog.newLine();
							flog.write("========= ERROR =========");
							flog.newLine();
							flog.write("300");
							flog.newLine();
							flog.write("=========================");
							flog.newLine();
						}
						
						flog.newLine();
						flog.write("========= SEARCH =========");
						flog.newLine();
						//flog.write("+ "+data);
						flog.newLine();
						flog.write("==========================");
						flog.newLine();							
						
					}
					else if(command.equals("UPDATE")) {/*If the command is "UPDATE"*/
						countTokens = st.countTokens();
						System.out.println(countTokens);

						if(countTokens>=1) {
							temp1 = st.nextToken(); //i==1
							System.out.println(temp1);
							flog.newLine();
							flog.write("========= UPDATE =========");
							flog.newLine();
//							flog.write("300");
							flog.newLine();
							flog.write("==========================");
							flog.newLine();
						}
						else {//ERROR : no argument
							System.out.println("ERROR : 400");
							flog.newLine();
							flog.write("========= ERROR =========");
							flog.newLine();
							flog.write("400");
							flog.newLine();
							flog.write("=========================");
							flog.newLine();
						}
					}
					else if(command.equals("EXIT")){/*If the command is "EXIT"*/
						
						flog.newLine();
						flog.write("========= EXIT =========");
						flog.newLine();
						flog.write("Success");
						flog.newLine();
						flog.write("=========================");
						flog.newLine();
						
					}
					else{/*If the command is unknown*/
						System.out.println("Error : Unknown command");
					}

				}

				fin.close();
				flog.close();
			}
			catch(FileNotFoundException e) {
				//TODO
			}
		}
		else {
			System.out.println("Error : The 'command.txt' file is no exist.");
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
