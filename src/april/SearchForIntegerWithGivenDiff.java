package april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

class Node implements Comparable<Node> {
	int val;
	int idx;
	
	public Node(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}

	@Override
	public int compareTo(Node o) {
		if (val != o.val) {
			return Integer.compare(val, o.val);
		} else {
			return Integer.compare(idx, o.idx);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(idx, val);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return idx == other.idx && val == other.val;
	}
	
	@Override
	public String toString() {
		return "val="+val+", idx ="+idx +"--- ";
	}
	
}

//Search For Integers With Given Difference And At Given Distance
public class SearchForIntegerWithGivenDiff {
	
	
	public static ArrayList<Integer> indicesAtGivenDistanceSHORT(ArrayList<Integer> nums , int n , int k , int m)
    {
        TreeSet<Integer> window = new TreeSet<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            Integer floor = window.floor(nums.get(i) + m);
            Integer ceil = window.ceiling(nums.get(i) - m);

            //System.out.println("window="+Arrays.toString(window.toArray()) + "\n floor = "+floor+", ceil = "+ceil+", i= "+i+", current="+nums.get(i));
            
            if (floor != null && Math.abs(floor - nums.get(i)) <= m) {
                //System.out.println("from first");
                return new ArrayList<>(Arrays.asList(i,indexMap.get(floor)));
            } else if (ceil != null && Math.abs(ceil - nums.get(i)) <= m) {
                //System.out.println("from second");
                return new ArrayList<>(Arrays.asList(i,indexMap.get(ceil)));
            }
            
            window.add(nums.get(i));
            indexMap.put(nums.get(i), i);
            
            if (i >= k) {
                window.remove(nums.get(i - k));
                indexMap.remove(nums.get(i - k));
            }
        }
        return new ArrayList<>();
     }
	
	public static ArrayList<Integer> indicesAtGivenDistance(ArrayList<Integer> nums, int n, int k, int m) {
		
		TreeSet<Node> rangeOfVals = new TreeSet<>();
		
		int l = 0;
		int i = k;
		int r = k + k;
		
		for (int c = l ; c <= r && c < nums.size() ; c++ ) {
			rangeOfVals.add(new Node(nums.get(c),c));
		}
		
		//System.out.println("initial range of vals="+Arrays.toString(rangeOfVals.toArray()));
		
		while (i + k < nums.size() - 1) {
			
			//System.out.println("at i ="+i+", l="+l+",r ="+r+", rangeOfVal="+Arrays.toString(rangeOfVals.toArray()));
			
			ArrayList<Integer> pair = isThereAPair(rangeOfVals,nums,i,m);
			if (pair.size() > 0) {
				return pair;
			}
			
			Node add = new Node(nums.get(i+k+1),i+k+1);
			
			Node remove = new Node(nums.get(l),l);
			
			rangeOfVals.add(add);
			rangeOfVals.remove(remove);
			
			l ++;
			r ++;
			i ++;
		}
		
		
		ArrayList<Integer> pair = isThereAPair(rangeOfVals,nums,i,m);
		
		//System.out.println("comes ar the end and the pair="+pair.toString());
		if (pair.size() > 0) {
			return pair;
		}
		
		
		return new ArrayList<>(List.of(-1,-1));
	}
	
	
	private static ArrayList<Integer> isThereAPair(TreeSet<Node> rangeOfVals,ArrayList<Integer> nums, int i, int m) {
		
		//System.out.println("isthere a pair starts");
		Node curr = new Node(nums.get(i),i);
		
		//System.out.println("curr= "+(curr == null ? "null" :curr.toString()));

		
		Node small = rangeOfVals.lower(curr);
		
		//System.out.println("small= "+(small == null ? "null" :small.toString()));
		
		if (small != null && small.idx != i && Math.abs(small.val-curr.val) <= m ) {
			return new ArrayList<>(List.of(small.idx,i));
		}
		
		
		Node large = rangeOfVals.higher(curr);
		
		//System.out.println("large= "+(large == null ? "null" :large.toString()));

		if (large != null && large.idx != i && Math.abs(large.val-large.val) <= m) {
			return new ArrayList<>(List.of(i,large.idx));
		}
		
		return new ArrayList<>();
	}
	
	public static void main(String[] args) {
		TreeSet<Integer> st = new TreeSet<>();
		
		st.add(1);
		st.add(2);
		st.add(3);
		st.add(4);
		st.add(5);
		
		
		//System.out.println(st.lower(3)); // out 2
		//System.out.println(st.ceiling(3)); // out 1
		//System.out.println(st.floor(3)); // out 2
		//System.out.println(st.higher(3)); // out 4
	}
}
