package april;

//Regular Expression Matching

public class RegularExpressionMatching {

	// wrong solution
    public boolean isMatch(String s, String p) {
        if (p.charAt(0) == '*') return false;

        
        int i = 0;
        int j = 0;

        while (i < s.length() && j < p.length()) {

            if (p.charAt(j) == '.' && j < p.length() -1 && p.charAt(j + 1) == '*') return true; // edge case

            if (s.charAt(i) == p.charAt(j)) {
                i ++;
                j++;
                continue;
            } 


            if (p.charAt(j) == '*') {

                char prev = p.charAt(j-1);

                while (i < s.length() && s.charAt(i) == prev) {
                    i++;
                }

                while (j < p.length() && p.charAt(j) == '*') {
                    j ++;
                }
            }

            if (i < s.length() && j < p.length() - 1  && p.charAt(j+1) == '*') {
                j++ ;
                continue;
            } else if (i == s.length() && j == p.length()) {
                return true;
            } else if (i < s.length() && j < p.length() && s.charAt(i) != p.charAt(j)) {
            	return false;
            }
        }

         if (i == s.length() && j == p.length()) {
            return true;
         } else {
            return false;
         }
     }
    public static void main(String[] args) {
		String s = "aab";
		
		String p = "c*a*b";
		
		RegularExpressionMatching a = new RegularExpressionMatching();
		
		System.out.println(a.isMatch(s, p));
	}
}
