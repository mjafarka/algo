package april;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//import javax.swing.tree.TreeNode;


class Pair {
	
	String a;
	String b;
	
	Pair(String a, String b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(a);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pair) {
			Pair p = (Pair) obj;
			
			return p.a.equals(a);
		} else {
			return false;
		}
	}
	
}


public class RemoveNamesDup {
	
	public static String[][] removeFirstNameDup(String[][] names) {
		
		/**
		 * this one is having time complexity of O(1) and SPACE COMPLEXITY OF O(n)
		 */
		
//		Set<Pair> unqFirstNames = new HashSet<>();
//		
//		for (String[] name : names) {
//			Pair p = new Pair(name[0],name[1]);
//			unqFirstNames.add(p);
//		}
//		
//		String[][] result = new String[unqFirstNames.size()][2];
//		
//		int i = 0;
//		for (Pair unq : unqFirstNames) {
//			result[i] = new String[] {unq.a,unq.b};
//			i++;
//		}
//		
//		return result;
		
		
		/**
		 * this one have TIME COMPLEXITY OF O(nlogn) whereas space complexity of O(1)
		 */
		
		Arrays.sort(names, (a,b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
		
		
		int i = 0;
		
		for (int j = 1 ; j < names.length ;j ++ ) {
			if (!names[i][0].equals(names[j][0])) {
				names[++i] = names[j];
			}
		}
		
		String[][] result = new String[i+1][2];
		
		for (int k = 0 ; k <= i ; k ++) {
			result[k] = names[k];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[][] names = new String[][] {{"jafar","asna"},{"jafar","shamila"},{"jafar","aadha"},{"mustafa","shamila"},{"mustafa","nadha"},{"stephen","jesla"}};
		
		String[][] unq = removeFirstNameDup(names);
		
		for (String[] u : unq) {
			System.out.println(Arrays.toString(u));
		}
	}
	
}
