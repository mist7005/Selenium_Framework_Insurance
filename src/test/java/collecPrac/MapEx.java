package collecPrac;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapEx {

	public static void main(String[] args) {
		Hashtable< Integer,String> ht=new Hashtable<>();
		ht.put(12, "hello");
		ht.put(2, "hi");
		ht.put(3, "bye");
		ht.put(1, "bye bye");
		//ht.put(15,null); null not allowed
		
		System.out.println(ht);
		ht.remove(1);
		System.out.println(ht);
		System.out.println(ht.contains("bye"));
		System.out.println(ht.containsKey(12));
		
		
		Set<Entry<Integer, String>> s = ht.entrySet();
		
		for (Entry<Integer, String> entry : s) {
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
		
		System.out.println("---------------------");
		System.out.println("HASH MAP");
		
		HashMap< Integer,String> hm=new HashMap<>();
		hm.put(12, "hello");
		hm.put(2, "hi");
		hm.put(3, "bye");
		hm.put(1, "bye bye");
		hm.put(15,null); 
		//hm.put(null,"gg"); key null not allowed
		hm.put(null,null); 
		
		System.out.println(hm);
		hm.remove(1);
		System.out.println(hm);
		System.out.println(hm.containsValue("bye"));
		System.out.println(hm.containsKey(12));
		
		
		Set<Entry<Integer, String>> s1 = hm.entrySet();
		
		for (Entry<Integer, String> entry : s1) {
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
		
		
		System.out.println("---------------------");
		System.out.println("LINKED HASH MAP");
		
		LinkedHashMap< Integer,String> lhm=new LinkedHashMap<>();
		
		lhm.put(2, "hi");
		lhm.put(3, "bye");
		lhm.put(12, "hello");
		lhm.put(1, "bye bye");
		lhm.put(15,null); 
		//lhm.put(null,"gg"); null key not allowed
		lhm.put(null,null); 
		
		System.out.println(lhm);
		System.out.println(lhm);
		System.out.println(lhm.containsValue("bye"));
		System.out.println(lhm.containsKey(12));
		
		
		Set<Entry<Integer, String>> s2 = lhm.entrySet();
		
		for (Entry<Integer, String> entry : s2) {
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
		
		
		System.out.println("---------------------");
		System.out.println("TREE MAP");
		
		TreeMap< Integer,String> tm=new TreeMap<>();
		
		tm.put(2, "hi");
		tm.put(3, "bye");
		tm.put(12, "hello");
		tm.put(1, "bye bye");
		tm.put(15,null);
		//lhm.put(null,"gg"); null key not allowed
//		tm.put(null,null); 
		
		System.out.println(tm);
		System.out.println(tm);
		System.out.println(tm.containsValue("bye"));
		System.out.println(tm.containsKey(12));
		
		
		Set<Entry<Integer, String>> s3 = tm.entrySet();
		
		for (Entry<Integer, String> entry : s3) {
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
	}

}
