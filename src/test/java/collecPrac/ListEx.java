package collecPrac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ListEx {

	public static void main(String[] args) {
		
		System.out.println("---------------------");
		System.out.println("ARRAY LIST");
		ArrayList<Object> l=new ArrayList<>();
		l.add(null);
		l.add(true);
		l.add("vbsdc");
		l.forEach(System.out::println);
		
		Iterator<Object> x = l.iterator();
		
		while (x.hasNext()) {
			Object object = (Object) x.next();
			System.out.println(object);
			
		}
		
		ArrayList<Integer> l1=new ArrayList<>();
	
		l1.add(11);
		l1.add(115);
		l1.add(21);
		l1.add(55);
		
		Collections.sort(l1);
		System.out.println(l1);
		l.addAll(l1);
		System.out.println(l);
		
		
		System.out.println("---------------------");
		System.out.println("LINKED LIST");
		LinkedList<Integer> lL=new LinkedList<>();
		lL.add(11);
		lL.add(115);
		lL.add(21);
		lL.add(55);
		System.out.println(lL);
		System.out.println(lL.getFirst());
		System.out.println(lL.getLast());
		
		lL.pop();
		lL.push(120);
		System.out.println(lL);
		
		System.out.println("---------------------");
		System.out.println("PRIORITY QUEUE");
		PriorityQueue<Integer> pQ=new PriorityQueue<>();
		pQ.add(54);
		pQ.add(64);
		pQ.add(13);
		pQ.add(17);
		pQ.add(300);
		System.out.println(pQ);
		System.out.println(pQ.peek());
		System.out.println(pQ);
		System.out.println(pQ.poll());
		System.out.println(pQ);
		
		
		System.out.println("---------------------");
		System.out.println("HASHSET");
		
		HashSet<Object> hs=new HashSet<>();
		hs.add("hi");
		hs.add(21);
		hs.add(true);
		hs.add(null);
		hs.add(null);
		hs.add(100);
		System.out.println(hs);
		System.out.println(hs.isEmpty());
		hs.remove(21);
		System.out.println(hs);
		
		Iterator<Object> hx=hs.iterator();
		while(hx.hasNext())
		{
			Object c=hx.next();
			System.out.println(c);
		}
		
		System.out.println("---------------------");
		System.out.println("TREESET");
		TreeSet<Integer> ts=new TreeSet<>();
		ts.add(151);
		ts.add(115);
		ts.add(200);
		ts.add(204);
		System.out.println(ts);
		
		System.out.println(ts.descendingSet());
		Iterator<Integer> tsI = ts.descendingIterator();
		while (tsI.hasNext()) {
			System.out.println(tsI.next());
			
		}
		
		
	}

}
