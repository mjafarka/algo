package april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NetworkDelayTime {


    /*
     * not that efficient, we can use distra's algorithm instead of this one.
     */
    int[] finishTime;
    public int networkDelayTime(int[][] times, int n, int k) {
        finishTime = new int[n+1];


        Map<Integer,List<int[]>> graph = new HashMap<>();

        Set<Integer> visited = new HashSet<>();

        // creation of graph
        for (int[] time : times) {
            graph.putIfAbsent(time[0],new ArrayList<>());

            graph.get(time[0]).add(new int[] {time[1],time[2]});
        }


        dfs(0,graph,k,visited);



        int minTime = 0;

        for (int i = 1 ; i <= n ; i++) {
            if (finishTime[i] == Integer.MAX_VALUE) {
                return -1;
            }


            minTime = Math.max(minTime,finishTime[i]);

        }

        return minTime;
    }

    private void dfs(int st, Map<Integer,List<int[]>> graph, int k, Set<Integer> visited) {
        if (visited.contains(k) && finishTime[k] <= st) {
            return;
        }


        List<int[]> child = graph.getOrDefault(k,new ArrayList<>());

        visited.add(k);

        finishTime[k] = st;
        for (int[] ch : child) {
            dfs(st+ch[1],graph,ch[0],visited);
        }
    }
    
}
