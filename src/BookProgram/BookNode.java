package BookProgram;

/*
@class BookNode
@date 2019/04/17~04/27
@author 이윤지(컴퓨터정보공학부 2017202095)
@brief 소프트웨어프로젝트 1-2 
 */

public class BookNode {
	//Field//
	private String title;	//Book name;
	private String author;	//Book author;

	//Constructor//
	public BookNode() {

	}
	
	//Constructor with Fields//
	public BookNode(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	//Setter & Getter//
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
}
