package BookProgram;

import java.io.BufferedWriter;
import java.io.IOException;

/*
@class myCollection
@date 2019/04/17~04/27
@author 이윤지(컴퓨터정보공학부 2017202085)
@brief 소프트웨어프로젝트 1-2 
 */

import java.util.*;


public class myCollection {

	//Collectiion
	private ArrayList<BookNode> al; 
	private LinkedList<BookNode> ll;
	private HashSet<BookNode> hs;
	private TreeSet<BookNode> ts;
	private HashMap<String, String> hm;	//Key : title, value : author
	private TreeMap<String, String> tm; //Key : title, value : author

	public myCollection(){
		al = new ArrayList<BookNode>();
		ll = new LinkedList<BookNode>();
		hs = new HashSet<BookNode>();
		ts = new TreeSet<BookNode>(new TreesetComparator());

		hm = new HashMap<String, String>();
		tm = new TreeMap<String, String>();
	}

	/*Push method*/
	public void addNode(BookNode book){
		al.add(book);
		ll.add(book);
		hs.add(book);
		//		if(ts.isEmpty()) {
		//			ts.headSet(book);
		//		}
		//		else {
		//			ts.add(book);
		//		}
		ts.add(book);
		hm.put(book.getTitle(), book.getAuthor());
		tm.put(book.getTitle(), book.getAuthor());
	}
	/*Print method*/
	public void printNode(String collection, BufferedWriter flog){
		String node;
		try {
			if(collection.equals("AL")) {
				Collections.sort(al, new Comparator<BookNode>() {

					@Override
					public int compare(BookNode node1, BookNode node2) {
						// TODO Auto-generated method stub
						String title1 = node1.getTitle();
						String title2 = node2.getTitle();

						return title1.compareTo(title2);
					}
				});
				
				flog.newLine();
				flog.write("========= PRINT =========");
				flog.newLine();
				for(int i=0; i<al.size();i++) {			
					node=al.get(i).getTitle()+"/"+al.get(i).getAuthor();
					System.out.println(node);
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("LL")) {
				
				Collections.sort(ll, new Comparator<BookNode>() {

					@Override
					public int compare(BookNode node1, BookNode node2) {
						// TODO Auto-generated method stub
						String title1 = node1.getTitle();
						String title2 = node2.getTitle();

						return title1.compareTo(title2);
					}
				});
				
				flog.newLine();
				flog.write("========= PRINT =========");
				flog.newLine();
				for(int i=0; i<ll.size();i++) {			
					node=ll.get(i).getTitle()+"/"+ll.get(i).getAuthor();
					System.out.println(node);
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("HS")) {//no sort
				Iterator<BookNode> iterator = hs.iterator();
				
				flog.newLine();
				flog.write("========= PRINT =========");
				flog.newLine();
				while(iterator.hasNext()) {
					BookNode book = (BookNode) iterator.next();
					node = book.getTitle()+"/"+book.getAuthor();
					System.out.println(node);
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("TS")) {
				Iterator<BookNode> iterator = ts.iterator();
				
				flog.newLine();
				flog.write("========= PRINT =========");
				flog.newLine();
				while(iterator.hasNext()) {
					BookNode book = (BookNode) iterator.next();
					node = book.getTitle()+"/"+book.getAuthor();
					System.out.println(node);
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("HM")) {//no sort
				//get
				Set<String> keyset = tm.keySet();
				Iterator<String> iterator = keyset.iterator();
				
				String k;
				String v;
				
				flog.newLine();
				flog.write("========= PRINT =========");
				flog.newLine();
				while(iterator.hasNext()) {
					k=(String)iterator.next();
					v=(String)tm.get(k);
					node = k+"/"+v;
					System.out.println(node);
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("TM")) {
				Set<String> keyset = tm.keySet();
				Iterator<String> iterator = keyset.iterator();
				
				String k;
				String v;
				
				flog.newLine();
				flog.write("========= PRINT =========");
				flog.newLine();
				while(iterator.hasNext()) {
					k=(String)iterator.next();
					v=(String)tm.get(k);
					node = k+"/"+v;
					System.out.println(node);
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			
		}
		catch(Exception e){
			System.out.println("ERROR : PRINT");
		}
	}
	/*Search method*/
	public String searchNode(String searchnode) {
		
		
		return "";
	}
	/*Update method*/
	public String updateNode() {

		return "";
	}

}


//TreeSet-Comparator to ADD BookNode  
class TreesetComparator implements Comparator<BookNode>{

	@Override
	public int compare(BookNode node1, BookNode node2) {
		// TODO Auto-generated method stub
		String title1 = node1.getTitle();
		String title2 = node2.getTitle();

		return title1.compareTo(title2);
	}

}
