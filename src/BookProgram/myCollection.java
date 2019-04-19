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
					
					flog.write(node);					
					flog.newLine();
				}
				flog.write("=========================");
				flog.newLine();
			}
			else if(collection.equals("HM")) {//no sort
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
	public String searchNode(String collection, String searchnode) {
		String val = null;

		if(collection.equals("AL")) {
			for(int i=0; i<al.size();i++) {
				if((al.get(i).getTitle()).equals(searchnode)) {
					val=al.get(i).getTitle()+"/"+al.get(i).getAuthor();
				}
			}
		}
		else if(collection.equals("LL")) {
			for(int i=0; i<ll.size();i++) {
				if((ll.get(i).getTitle()).equals(searchnode)) {
					val=ll.get(i).getTitle()+"/"+ll.get(i).getAuthor();
				}
			}
		}
		else if(collection.equals("HS")) {
			Iterator<BookNode> iterator = hs.iterator();
			while(iterator.hasNext()) {
				BookNode book = (BookNode) iterator.next();
				if(book.getTitle().equals(searchnode)) {
					val = book.getTitle()+"/"+book.getAuthor();
				}
			}

		}
		else if(collection.equals("TS")) {
			Iterator<BookNode> iterator = ts.iterator();

			while(iterator.hasNext()) {
				BookNode book = (BookNode) iterator.next();
				if(book.getTitle().equals(searchnode)) {
					val = book.getTitle()+"/"+book.getAuthor();
				}
			}
		}
		else if(collection.equals("HM")) {
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
		else if(collection.equals("TM")) {
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
	public Boolean updateNode(String beforename, String aftername) {
		Boolean flag=false;
		Boolean findflag=false;
		String hs_author;
		String ts_author;

		for(int i=0; i<al.size();i++) {
			if((al.get(i).getTitle()).equals(beforename)) {
				findflag=true;
			}
		}

		if(findflag==true) {
			for(int i=0; i<al.size();i++) {
				if((al.get(i).getTitle()).equals(beforename)) {
					al.set(i, new BookNode(aftername,al.get(i).getAuthor()));
				}
			}


			for(int i=0; i<ll.size();i++) {
				if((ll.get(i).getTitle()).equals(beforename)) {
					ll.set(i, new BookNode(aftername,ll.get(i).getAuthor()));
				}
			}


//			Iterator<BookNode> hs_iterator = hs.iterator();
//			while(hs_iterator.hasNext()) {
//				BookNode hs_book = (BookNode) hs_iterator.next();
//				if(hs_book.getTitle().equals(beforename)) {
//					hs_author=hs_book.getAuthor();
//					hs_iterator.remove();
//					hs.add(new BookNode(aftername,hs_author));
//				}
//			}
//
//
//			Iterator<BookNode> ts_iterator = ts.iterator();
//
//			while(ts_iterator.hasNext()) {
//				BookNode ts_book = ts_iterator.next();
//				if(ts_book.getTitle().equals(beforename)) {
//					ts_author=ts_book.getAuthor();
//					ts_iterator.remove();
//					ts.add(new BookNode(aftername,ts_author));
//				}
//			}
//
//
//			//get
//			Set<String> hm_keyset = hm.keySet();
//			Iterator<String> hm_iterator = hm_keyset.iterator();
//
//			String hm_k;
//			String hm_v;
//
//			while(hm_iterator.hasNext()) {
//				hm_k=(String)hm_iterator.next();
//				if(hm_k.equals(beforename)) {
//
//					hm_v=(String)hm.get(hm_k);
//					hm.remove(hm_k);
//					hm.put(aftername, hm_v);
//				}
//			}
//
//
//
//			Set<String> tm_keyset = tm.keySet();
//			Iterator<String> tm_iterator = tm_keyset.iterator();
//
//			String tm_k;
//			String tm_v;
//
//			while(tm_iterator.hasNext()) {
//				tm_k=(String)tm_iterator.next();
//				if(tm_k.equals(beforename)) {
//
//					tm_v=(String)tm.get(tm_k);
//					tm.remove(tm_k);
//					tm.put(aftername, tm_v);
//				}
//			}

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
