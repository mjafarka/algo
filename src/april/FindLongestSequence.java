package april;


//Find Longest Sequence - coding ninjas

/** 
 * also add visited set or matrix, MY SOLUTION NOT WELL ROUNDED.
 */
public class FindLongestSequence {

//	static int res = 0;

	public static int findLongestOverAll(int[][] mat, int n) {

		int res = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (valid(i, j, mat)) {
					//System.out.println("valid is i= "+i+", and j ="+j+", and val="+mat[i][j]);
					res = Math.max(res,  dfs(mat[i][j] - 1, mat[i][j], i, j, mat, 1));
				}
			}
		}

		return res;
	}

	private static boolean valid(int r, int c, int[][] mat) {

		int[] dir = new int[] { -1, 0, 1, 0, -1 };
		
		//System.out.println("\n\n");


		//System.out.println("num before loop valid="+mat[r][c]+" r="+r+", c="+c);
		for (int i = 0; i < 4; i++) {
			int rD = r+ dir[i];
			int cD = c + dir[i + 1];
			//System.out.println("--> rD="+rD+", cD="+cD);

			if (!(rD < 0 || rD >= mat.length || cD < 0 || cD >= mat.length)) {
				//System.out.println("curr="+mat[r][c]+", neighbor = "+mat[rD][cD]);
			}
			
			if (!(rD < 0 || rD >= mat.length || cD < 0 || cD >= mat.length) && mat[rD][cD] + 1 == mat[r][c]) { // no smaller element with difference 1 in the neighbor 
				return false;
			}
		}
		
		//System.out.println("num ="+mat[r][c]+", returned true");
		return true;

	}

	private static int dfs(int prev, int curr, int r, int c, int[][] mat, int len) {
		if (curr - prev != 1) {
			return 0;
		}

//		res = Math.max(res, len);
		int temp = mat[r][c];
		mat[r][c] = Integer.MAX_VALUE;

		int[] dir = new int[] { -1, 0, 1, 0, -1 };
		
		int res = 0;
		
		

		for (int i = 0; i < 4; i++) {
			int rD = r + dir[i];
			int cD = c + dir[i + 1];
			if (!(rD < 0 || rD >= mat.length || cD < 0 || cD >= mat.length)) {
				
				res = Math.max(res, 1 + dfs(curr, mat[rD][cD], rD, cD, mat, len + 1));
			}
		}

		mat[r][c] = temp;
		
		//System.out.println("num="+curr+" res="+res);
		
		return res;

	}
	
	public static void main(String[] args) {
		int[][] mat = {{9,1,3},{7,4,2},{6,5,8}};
		
		//System.out.println(findLongestOverAll(mat,3));
	}
}
