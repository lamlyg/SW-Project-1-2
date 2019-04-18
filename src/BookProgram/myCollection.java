package BookProgram;

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
	public String printNode(String collection) {
		String node;

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

			for(int i=0; i<al.size();i++) {			
				node=al.get(i).getTitle()+"/"+al.get(i).getAuthor();
				System.out.println(node);
			}
		}
		return "";
	}
	/*Search method*/
	public String searchNode() {

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
