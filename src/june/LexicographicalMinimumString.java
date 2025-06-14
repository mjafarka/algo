package june;

import java.util.ArrayList;
import java.util.List;


//Lexicographically Minimum String After Removing Stars

public class LexicographicalMinimumString {
    public String clearStars(String s) {

        /*
        process

        1. create ds
            prev
            list(list)

        arr = chararray(s)

        loop over s -> c,i

            if c == '*':

                for (int j = 0 ; j < 26 ; i++) {
                    if (prev[j] > 0) {
                        idx = prev[j] last

                        arr[idx] = '-'

                        prev[j] removelast
                        break;
                    }
                }

            else:
                prev[c-'a'].add(i)

        
        res = ''
        finall loop over the arr -> d
            if not (d == '-' || '*'):
                res += d

        return res;
        */

        List<List<Integer>> prevIdxs = new ArrayList<>();

        for (int i = 0 ; i < 26 ; i ++) {
            prevIdxs.add(new ArrayList<>());
        }

        char[] arr = s.toCharArray();

        for (int i = 0 ; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '*') {
                for (int j = 0 ;  j < 26 ;j ++) {
                    if (prevIdxs.get(j).size() > 0) {
                        List<Integer> idx = prevIdxs.get(j);

                        int remIdx = idx.get(idx.size()-1);

                        idx.remove(idx.size()-1);

                        arr[remIdx] = '-';
                        break;
                    }
                }
            } else {
                prevIdxs.get(c-'a').add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '*' && c != '-') {
                sb.append(c);
            }
        }


        return sb.toString();
    }
}
