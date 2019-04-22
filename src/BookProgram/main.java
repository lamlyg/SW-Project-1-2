package BookProgram;

/*
	@class main - 메인클래스
	@date 2019/04/17~04/27
	@author 이윤지(컴퓨터정보공학부 2017202085)
	@brief 소프트웨어프로젝트 1-2 
 */

/*
 (프로젝트1-2 - readme)
 책 정보를 총 6개의 컬렉션에 저장하여 관리하는 프로그램
 [컬렉션의 종류] - ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap
 [프로그램에 사용되는 입력 파일] - BookList.txt, command.txt
 [프로그램에 사용되는 출력 파일] - Log.txt
 [프로그램 수행 내용]
 책 정보를 담고 있는 텍스트 파일로 책 이름과 책 저자가 '/'로 구분되어 입력되어 있다.
 프로그램 시작과 동시에 BookList.txt에 존재하는 책 정보가 모든 컬렉션에 입력되어 있다.
 이후에 command.txt에 입력된 프로그램 명령어들을 읽으면서 원하는 명령을 수행한다.
 모든 명령어의 동작이 끝났을 경우 프로그램이 종료되면서 Log.txt 파일을 출력한다.
 이 파일에는 command.txt에서 읽었던 명령어들이 수행되면서 나온 결과를 요구되는 포맷에 맞게 모두 저장되어있다.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//main class
public class main {
	public static void main(String [] args) throws IOException{

		Manager manager = new Manager();
		manager.run("command.txt");
	}
}
