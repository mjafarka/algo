package may;

import java.util.Arrays;


/**
 * two approaches. from editorial
 * 
 * Push Dominoes
 */
public class PushDominoes {
	
	
	
	public String pushDominoesTwoPointers(String dominoes) {
		// ------------------------------- done by using hashmap --------------------------
        // List<int[]> map = new ArrayList<>();// 1 -> L, 2 -> R

        // for (int i = 0 ; i < dominoes.length() ; i++ ) {
        //     if (dominoes.charAt(i) == 'L') {
        //         map.add(new int[]{1,i});
        //     } else if (dominoes.charAt(i) == 'R') {
        //         map.add(new int[]{2,i});
        //     }
        // }       

        // if (map.size() == 0) {
        //     return dominoes;
        // }

        // StringBuilder sb = new StringBuilder();

        // int[] firstFalling = map.get(0);

        // int[] tempInitial = new int[]{1,-1};
        // sb.append(createSegOutput(tempInitial,firstFalling).substring(1));

        // for (int i = 0 ; i < map.size() - 1 ; i ++ ) {
        //     sb.append(createSegOutput(map.get(i),map.get(i+1)));
        // }

        // int[] tempFinal = new int[]{2,dominoes.length()};
        // sb.append(createSegOutput(map.get(map.size()-1), tempFinal));

        // return sb.toString();

        int prevIdx = -1;
        char prevChar = 'L';

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < dominoes.length() ; i ++ ) {
            char currChar = dominoes.charAt(i);

            if (currChar != '.') {
                int[] prev = new int[]{prevChar == 'L' ? 1 : 2 , prevIdx};
                int[] nxt = new int[]{currChar == 'L' ? 1 : 2, i};

                sb.append(createSegOutput(prev,nxt));

                prevIdx = i;
                prevChar = currChar;
            }
        }

        int[] prev = new int[] {prevChar == 'L' ? 1 : 0, prevIdx};
        int[] last = new int[] {2,dominoes.length()};

        sb.append(createSegOutput(prev,last));

        sb.deleteCharAt(0);

        return sb.toString();
    }

    private String createSegOutput(int[] initial, int[] finall) {
        int len = finall[1] - initial[1] - 1;

        StringBuilder res = new StringBuilder();

        res.append(initial[0] == 1 ? 'L' : 'R');

        char initDir = initial[0] == 1 ? 'L' : 'R';

        char finDir = finall[0] == 2 ? 'R' : 'L';

        if (initDir == 'R' && finDir == 'L') {

            for (int i = 0 ; i < len / 2 ; i++ ) {
                res.append('R');
            }

            if (len % 2 == 1) {
                res.append('.');
            }

            for (int i = 0 ; i < len / 2 ; i++ ) {
                res.append('L');
            }
        } else if (initDir == 'R' && finDir == 'R') {
            for (int i = 0 ; i < len ; i++) {
                res.append('R');
            }
        } else if (initDir == 'L' && finDir == 'R') {
             for (int i = 0 ; i < len ; i++) {
                res.append('.');
            }
        } else { // both are left 
            for (int i = 0 ; i < len ; i++) {
                res.append('L');
            }
        }

        return res.toString();
    }
	
	/**
	 * done with force calculation
	 * @param S
	 * @return
	 */
	public String pushDominoesWithForce(String S) {
		char[] A = S.toCharArray();
		int N = A.length;
		int[] forces = new int[N];

		int[] forward = new int[N];
		// Populate forces going from left to right
		int force = 0;
		for (int i = 0; i < N; ++i) {
			if (A[i] == 'R')
				force = N;
			else if (A[i] == 'L') 
				force = 0;
			else
				force = Math.max(force - 1, 0);
			forward[i] += force;
			forces[i] += force;
		}

		int[] backward = new int[N];
		// Populate forces going from right to left
		force = 0;
		for (int i = N - 1; i >= 0; --i) {
			if (A[i] == 'L')
				force = N;
			else if (A[i] == 'R')
				force = 0;
			else
				force = Math.max(force - 1, 0);
			backward[i] -= force;
			forces[i] -= force;

		}
		
		System.out.println("forward="+Arrays.toString(forward));
		
		System.out.println("backward="+Arrays.toString(backward));

		StringBuilder ans = new StringBuilder();
		for (int f : forces)
			ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
		return ans.toString();
	}
	
	
	
	
	public static void main(String[] args) {
		PushDominoes p = new PushDominoes();
		
		System.out.println(p.pushDominoesTwoPointers("L.RR...L"));
	}
}
