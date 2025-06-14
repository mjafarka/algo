package june;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//Maximum Candies You Can Get from Boxes


// does have dfs and bfs solutions.
public class MaximumCandiesCanGetFromBox {

    //bfs solution,

    // tc = O(n)
    // sc = O(n)
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        // from the initial box. add all the boxes which are opened. to the bfsq
            // boxes added to the bfs, add to the visited.
            // if it is not opened add it to the owned.


        // do bfs on the bfsQ.


            // add the candies into the res

            // interate the contained boxes.
                // if the box is opened and not visited add it to the bfsq

                // not visited and if it is not opened add to the owned.



            // iterate over the key
                // change the status of the box to opened.
                // if the key is in owned and not visited add to the bfs q

        // finally return the result;

        Queue<Integer> bfsQ = new ArrayDeque<>();

        Set<Integer> visited = new HashSet<>();

        Set<Integer> owned = new HashSet<>();

        int res = 0;

        for (int in : initialBoxes) {
            if (status[in] == 1) {
                bfsQ.add(in);
                visited.add(in);
            } else {
                owned.add(in);
            }
        }

        while (bfsQ.size() > 0) {

            int cur = bfsQ.poll();

            res += candies[cur];

            for (int box : containedBoxes[cur]) {
                if (!visited.contains(box) ) {
                    if (status[box] == 1){
                        bfsQ.add(box);
                        visited.add(box);
                    } else {
                        owned.add(box);
                    }
                    
                } 
            }

            for (int k : keys[cur]) {
                status[k] = 1;
                if (visited.contains(k) == false && owned.contains(k)) {
                    owned.remove(k);
                    visited.add(k);
                    bfsQ.add(k);
                }
            }

        }

        return res;

    }

    //dfs solution

    Set<Integer> visited;

    Set<Integer> closed;

    int ttlCandies = 0;
    
    public int maxCandiesDfs(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        visited = new HashSet<>();

        closed = new HashSet<>();

        for (int i : initialBoxes) {
            if (status[i] == 1)
            dfs(i,status,candies,keys,containedBoxes);
            else {
                closed.add(i);
            }
        }

        return ttlCandies;
    }

    private void dfs(int cur, int[] status, int[] candies, int[][] keys, int[][] contBoxes ) {
        if (visited.contains(cur)) {
            return;
        }

        ttlCandies += candies[cur];

        visited.add(cur);

        for (int nxt : contBoxes[cur]) {
            if (status[nxt] == 0) {
                closed.add(nxt);
            }

            if (status[nxt] == 1)
                dfs(nxt,status,candies,keys,contBoxes);
        }

        for (int k : keys[cur]) {
                status[k] = 1;
                if (closed.contains(k)) {
                    dfs(k,status,candies,keys,contBoxes);
                    closed.remove(k);
                }
            }
    }
}
