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
	BufferedWriter flog = new BufferedWriter(new FileWriter(log,false));//output stream  (for log.txt )

	myCollection bookcollection =new myCollection();

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

				String bookname="";
				String author="";
				String newbookname="";

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
					System.out.println("===============");
					System.out.println("command : "+command);

					if(command.equals("ADD")){/*If the command is "ADD"*/
						System.out.println("===============");
						////start: Get 'data' argument of command 'ADD'////
						countTokens = st.countTokens();//the number of tokencount after command
						System.out.println(countTokens);

						if(countTokens>0) {//인자가 있는지 확인
							String temp_add[] = new String[countTokens];
							data="";//reinitialize
							for(i=0;i<countTokens;i++) {
								temp_add[i]=st.nextToken();
								System.out.println(temp_add[i]);
							}

							for(i=0;i<countTokens-1;i++) {
								data = data+temp_add[i]+" ";
							}
							data=data+temp_add[i];
							////end: Get 'data' argument of command 'ADD'////
							System.out.println("data : "+data);
							System.out.println(s);

							if(data.contains("/")){
								datatoken = new StringTokenizer(data, "/");							
								bookname=datatoken.nextToken();
								author=datatoken.nextToken();
								System.out.println("책이름 :"+bookname);
								System.out.println("저자 :"+author);

								if(ADD(bookname, author)) {
									flog.newLine();							
									flog.write("========= ADD =========");
									flog.newLine();
									flog.write("+ "+data);
									flog.newLine();
									flog.write("=======================");
									flog.newLine();										
								}
								else {
									LOGPRINTERROR("100");
								}
							}
							else {
								LOGPRINTERROR("100");
							}
						}
						else {//Error case in 'ADD' : lack of argument 
							System.out.println("ERROR : 100");//-> log.txt로
							LOGPRINTERROR("100");
						}
					}
					else if(command.equals("PRINT")){/*If the command is "PRINT"*/
						System.out.println("===============");
						countTokens = st.countTokens();
						System.out.println(countTokens);

						if(countTokens==1) {//check the collection is existed
							collection = st.nextToken();//i==1 (get the kind of collection)
							System.out.println("collection : "+collection);
							if(collection.equals("AL")){//ArrayList
								if(PRINT("AL")){
								}
								else {
									LOGPRINTERROR("200");
								}
							}
							else if(collection.equals("LL")){//LinkedList
								if(PRINT("LL")){
								}
								else {
									LOGPRINTERROR("200");
								}
							}
							else if(collection.equals("HS")){//HashSet
								if(PRINT("HS")){
								}
								else {
									LOGPRINTERROR("200");
								}
							}
							else if(collection.equals("TS")){//TreeSet
								if(PRINT("TS")){
								}
								else {
									LOGPRINTERROR("200");
								}
							}
							else if(collection.equals("HM")){//HashMap
								if(PRINT("HM")){
								}
								else {
									LOGPRINTERROR("200");
								}
							}
							else if(collection.equals("TM")){//TreeMap
								if(PRINT("TM")){
								}
								else {
									LOGPRINTERROR("200");
								}
							}
							else {//incorrect collection
								System.out.println("ERROR : 200");
								LOGPRINTERROR("200");
							}
						}
						else {
							System.out.println("ERROR : 200");
							LOGPRINTERROR("200");
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
						System.out.println("===============");

						collection = st.nextToken();//i==1 (get the kind of collection)
						System.out.println("collection : "+collection);

						////start: Get 'data' argument of command 'SEARCH'////
						countTokens = st.countTokens();//the number of tokencount after command
						System.out.println(countTokens);

						if(countTokens>0) {//인자가 있는지 확인
							String temp_search[] = new String[countTokens];
							data="";
							for(i=0;i<countTokens;i++) {
								temp_search[i]=st.nextToken();
								System.out.println(temp_search[i]);
							}

							for(i=0;i<countTokens-1;i++) {
								data = data+temp_search[i]+" ";
							}
							data=data+temp_search[i];
							////end: Get 'data' argument of command 'SEARCH'////
							System.out.println("data : "+data);

							if(collection.equals("AL")){//ArrayList
								if(SEARCH("AL")){
								}
								else {
								}
							}
							else if(collection.equals("LL")){//LinkedList
								if(SEARCH("LL")){
								}
								else {
								}
							}
							else if(collection.equals("HS")){//HashSet
								if(SEARCH("HS")){
								}
								else {
								}
							}
							else if(collection.equals("TS")){//TreeSet
								if(SEARCH("TS")){
								}
								else {
								}
							}
							else if(collection.equals("HM")){//HashMap
								if(SEARCH("HM")){
								}
								else {
								}
							}
							else if(collection.equals("TM")){//TreeMap
								if(SEARCH("TM")){
								}
								else {
								}
							}
							else {//ERROR : incorrect collection
								System.out.println("ERROR : 300");
								LOGPRINTERROR("300");
							}

							flog.newLine();
							flog.write("========= SEARCH =========");
							flog.newLine();
							//flog.write("+ "+data);
							flog.newLine();
							flog.write("==========================");
							flog.newLine();							
						}
						else {
							LOGPRINTERROR("300");
						}
					}
					else if(command.equals("UPDATE")) {/*If the command is "UPDATE"*/
						System.out.println("===============");

						////start: Get 'data' argument of command 'UPDATE'////
						countTokens = st.countTokens();//the number of tokencount after command
						System.out.println(countTokens);

						if(countTokens>0) {//인자가 있는지 확인
							String temp_update[] = new String[countTokens];
							data="";
							for(i=0;i<countTokens;i++) {
								temp_update[i]=st.nextToken();
								System.out.println(temp_update[i]);
							}

							for(i=0;i<countTokens-1;i++) {
								data = data+temp_update[i]+" ";
							}
							data=data+temp_update[i];

							if(data.contains("/")){
								datatoken = new StringTokenizer(data, "/");							
								bookname=datatoken.nextToken();
								newbookname=datatoken.nextToken();
								System.out.println("책이름 :"+bookname);
								System.out.println("업데이트 :"+newbookname);

							}
							else {//ERROR : no argument about update bookname
								LOGPRINTERROR("400");
							}
							////end: Get 'data' argument of command 'UPDATE'////

							System.out.println("data : "+data);
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
							LOGPRINTERROR("400");
						}
					}
					else if(command.equals("EXIT")){/*If the command is "EXIT"*/
						flog.newLine();
						flog.write("========== EXIT ==========");
						flog.newLine();
						flog.write("Success");
						flog.newLine();
						flog.write("==========================");
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

	public boolean ADD(String title,String author) throws IOException{
		try {
			BookNode book = new BookNode();
			book.setTitle(title);
			book.setAuthor(author);

			bookcollection.addNode(book);

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean PRINT(String collection) throws IOException{
		try {
			if(collection.equals("AL")) {
				bookcollection.printNode("AL");
			}
			else if(collection.equals("LL")) {
				bookcollection.printNode("LL");
			}
			else if(collection.equals("HS")) {
				bookcollection.printNode("HS");
			}
			else if(collection.equals("TS")) {
				bookcollection.printNode("TS");
			}
			else if(collection.equals("HM")) {
				bookcollection.printNode("HM");
			}
			else if(collection.equals("TM")) {
				bookcollection.printNode("TM");
			}
			else {
				return false;
			}
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean SEARCH(String collection) throws IOException{
		try {
			if(collection.equals("AL")) {
			}
			else if(collection.equals("LL")) {
			}
			else if(collection.equals("HS")) {
			}
			else if(collection.equals("TS")) {
			}
			else if(collection.equals("HM")) {
			}
			else if(collection.equals("TM")) {
			}
			else {
				return false;
			}
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean UPDATE(String beforename, String aftername) throws IOException{
		try {
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public void LOGPRINTERROR(String errorcode) throws IOException{
		flog.newLine();
		flog.write("========= ERROR =========");
		flog.newLine();
		flog.write(errorcode);
		flog.newLine();
		flog.write("=========================");
		flog.newLine();
	}
}
