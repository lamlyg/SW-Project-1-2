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

	///////////Field//////////
	//Collectiion
	private ArrayList<BookNode> al; 
	private LinkedList<BookNode> ll;
	private HashSet<BookNode> hs;
	private TreeSet<BookNode> ts;
	private HashMap<String, String> hm;	//Key : title, value : author
	private TreeMap<String, String> tm; //Key : title, value : author

	/////////constructor////////////
	public myCollection(){
		al = new ArrayList<BookNode>();
		ll = new LinkedList<BookNode>();
		hs = new HashSet<BookNode>();
		ts = new TreeSet<BookNode>(new TreesetComparator());

		hm = new HashMap<String, String>();
		tm = new TreeMap<String, String>();
	}

	
	/////////////Method////////////
	
	/*Push method*/
	public void addNode(BookNode book){
		al.add(book);
		ll.add(book);
		hs.add(book);
		
		ts.add(book);
		hm.put(book.getTitle(), book.getAuthor());
		tm.put(book.getTitle(), book.getAuthor());
	}
	/*Print method*/
	public void printNode(String collection, BufferedWriter flog){
		String node;
		try {
			if(collection.equals("AL")) {//PRINT - ArrayList
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
					
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("LL")) {//PRINT - LinkedList

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
					
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("HS")) {//PRINT(no sort) - HashSet
				Iterator<BookNode> iterator = hs.iterator();

				flog.newLine();
				flog.write("========= PRINT =========");
				flog.newLine();
				while(iterator.hasNext()) {
					BookNode book = (BookNode) iterator.next();
					node = book.getTitle()+"/"+book.getAuthor();
					
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("TS")) {//PRINT - TreeSet
				Iterator<BookNode> iterator = ts.iterator();

				flog.newLine();
				flog.write("========= PRINT =========");
				flog.newLine();
				while(iterator.hasNext()) {
					BookNode book = (BookNode) iterator.next();
					node = book.getTitle()+"/"+book.getAuthor();
					
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("HM")) {//PRINT(no sort) - HashMap
				//get
				Set<String> keyset = hm.keySet();
				Iterator<String> iterator = keyset.iterator();

				String k;
				String v;

				flog.newLine();
				flog.write("========= PRINT =========");
				flog.newLine();
				while(iterator.hasNext()) {
					k=(String)iterator.next();
					v=(String)hm.get(k);
					node = k+"/"+v;
					
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("TM")) {//PRINT - TreeMap
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
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}

		}
		catch(Exception e){//Exception
			System.out.println("ERROR : PRINT");
		}
	}
	/*Search method*/
	public String searchNode(String collection, String searchnode) {
		String val = null;

		if(collection.equals("AL")) {//SEARCH - ArrayList
			for(int i=0; i<al.size();i++) {
				if((al.get(i).getTitle()).equals(searchnode)) {
					val=al.get(i).getTitle()+"/"+al.get(i).getAuthor();
				}
			}
		}
		else if(collection.equals("LL")) {//SEARCH - LinkedList
			for(int i=0; i<ll.size();i++) {
				if((ll.get(i).getTitle()).equals(searchnode)) {
					val=ll.get(i).getTitle()+"/"+ll.get(i).getAuthor();
				}
			}
		}
		else if(collection.equals("HS")) {//SEARCH - HashSet
			Iterator<BookNode> iterator = hs.iterator();
			while(iterator.hasNext()) {
				BookNode book = (BookNode) iterator.next();
				if(book.getTitle().equals(searchnode)) {
					val = book.getTitle()+"/"+book.getAuthor();
				}
			}

		}
		else if(collection.equals("TS")) {//SEARCH - TreeSet
			Iterator<BookNode> iterator = ts.iterator();

			while(iterator.hasNext()) {
				BookNode book = (BookNode) iterator.next();
				if(book.getTitle().equals(searchnode)) {
					val = book.getTitle()+"/"+book.getAuthor();
				}
			}
		}
		else if(collection.equals("HM")) {//SEARCH - HashMap
			//get
			Set<String> keyset = hm.keySet();
			Iterator<String> iterator = keyset.iterator();

			String k;
			String v;

			while(iterator.hasNext()) {
				k=(String)iterator.next();
				if(k.equals(searchnode)) {
					v=(String)tm.get(k);
					val = k+"/"+v;
				}
			}

		}
		else if(collection.equals("TM")) {//SEARCH - TreeMap
			//get
			Set<String> keyset = tm.keySet();
			Iterator<String> iterator = keyset.iterator();

			String k;
			String v;

			while(iterator.hasNext()) {
				k=(String)iterator.next();
				if(k.equals(searchnode)) {
					v=(String)tm.get(k);
					val = k+"/"+v;
				}
			}

		}
		else {
			val = null;
		}
		return val;
	}
	/*Update method*/
	public boolean updateNode(String beforename, String aftername) {
		boolean flag=false;
		boolean findflag=false;
		String author;
		//String ts_author;

		for(int i=0; i<al.size();i++) {
			if((al.get(i).getTitle()).equals(beforename)) {
				findflag=true;
			}
		}

		if(findflag==true) {
			
			for(int i=0; i<al.size();i++) {
				BookNode book = al.get(i);
				if(book.getTitle().equals(beforename)) {
					book.setTitle(aftername);
					break;
				}
			}
			
			author = hm.get(beforename);//search the key->find value(author)
			
			hm.remove(beforename);
			hm.put(aftername, author);//update hash map

			tm.remove(beforename);
			tm.put(aftername, author);//update tree map
			

			flag=true;
			return true;
		}
		else {
			flag = false;
		}

		return flag;
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
