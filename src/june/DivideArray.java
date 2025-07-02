package june;

import java.util.Arrays;


//Divide Array Into Arrays With Max Difference
public class DivideArray {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n % 3 != 0) return new int[][]{}; // Cannot divide evenly

        Arrays.sort(nums);
        int numOfArrays = n / 3;
        int[][] res = new int[numOfArrays][3];

        int x = 0; // Pointer in nums array

        for (int i = 0; i < numOfArrays; i++) {
            int a = nums[x++];
            int b = nums[x++];
            int c = nums[x++];

            // Check condition between the smallest and largest in group
            if (c - a > k) return new int[][]{};

            res[i][0] = a;
            res[i][1] = b;
            res[i][2] = c;
        }

        return res;
    }
}
