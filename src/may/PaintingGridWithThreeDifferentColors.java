package may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* Painting a Grid With Three Different Colors */

/* notes in onenote */

/* two type of solution is there
 * 1. bit masking
 * 2. using string as previous state
 */
public class PaintingGridWithThreeDifferentColors {

	private List<String> columnStates = new ArrayList<>();
	private int[][] t;
	private final int MOD = 1_000_000_007;

	// Recursively generate all valid column colorings of height 'm'
	// such that no two vertically adjacent cells have the same color
	private void generateColumnStates(String currentColumn, int rowsRemaining, char prevColor) {
		if (rowsRemaining == 0) {
			columnStates.add(currentColumn);
			return;
		}

		// Colors: 'R' = Red, 'G' = Green, 'B' = Blue
		for (char color : new char[] { 'R', 'G', 'B' }) {
			if (color == prevColor)
				continue;
			generateColumnStates(currentColumn + color, rowsRemaining - 1, color);
		}
	}

	private int solve(int remainingCols, int prevColumnIdx, int m) {
		if (remainingCols == 0)
			return 1;
		if (t[remainingCols][prevColumnIdx] != -1)
			return t[remainingCols][prevColumnIdx];

		int totalWays = 0;
		String prevColumn = columnStates.get(prevColumnIdx);

		for (int nextColumnIdx = 0; nextColumnIdx < columnStates.size(); nextColumnIdx++) {
			String nextColumn = columnStates.get(nextColumnIdx);
			boolean valid = true;

			// Check horizontal adjacency (no same color in same row across adjacent
			// columns)
			for (int r = 0; r < m; r++) {
				if (prevColumn.charAt(r) == nextColumn.charAt(r)) {
					valid = false;
					break;
				}
			}

			if (valid) {
				totalWays = (totalWays + solve(remainingCols - 1, nextColumnIdx, m)) % MOD;
			}
		}

		return t[remainingCols][prevColumnIdx] = totalWays;
	}

	public int colorTheGrid(int m, int n) {
		columnStates.clear();
		generateColumnStates("", m, '#'); // '#' denotes no previous color

		int numColumnPatterns = columnStates.size();
		t = new int[n][numColumnPatterns];
		for (int[] row : t) {
			Arrays.fill(row, -1);
		}

		int result = 0;
		for (int i = 0; i < numColumnPatterns; i++) {
			result = (result + solve(n - 1, i, m)) % MOD;
		}

		return result;
	}
	
	
	/*
	 * bit masking solution
	 * ---------------------
	 */
//	private static final int MOD = (int)1e9 + 7;
    private int[][] state_mem = new int[1002][1024]; // 1000 rows + 2, 1024 for 10 bits
    
    public int colorTheGrid2(int m, int n) {
        for (int i = 0; i < state_mem.length; i++) {
            Arrays.fill(state_mem[i], -1);
        }
        return countWays(m, n, 0, 0, 0, 0);
    }
    
    private int countWays(int m, int n, int r, int c, int curr_state, int prev_state) {
        if (c == n) return 1;
        if (r == m) return countWays(m, n, 0, c + 1, 0, curr_state);
        if (r == 0 && state_mem[c][prev_state] != -1) return state_mem[c][prev_state];
        
        int up_color = 0;
        if (r > 0) up_color = curr_state & 3;
        
        int left_color = (prev_state >> ((m - r - 1) * 2)) & 3;
        
        int ways_to_color = 0;
        for (int color = 1; color <= 3; color++) {
            if (color != up_color && color != left_color) {
                ways_to_color = (ways_to_color + countWays(m, n, r + 1, c, (curr_state << 2) | color, prev_state)) % MOD;
            }
        }
        
        if (r == 0) {
            state_mem[c][prev_state] = ways_to_color;
        }
        return ways_to_color;
    }
	
	
}
