package june;


// Kth Largest Element in an Array
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (k == 1 && nums.length == 1) return nums[0];
        k = nums.length - k ;
        int n = -1;
        int left = 0;
        int right = nums.length - 1;
        while(n != k){
            n = quickSortIndex(nums,left,right);
            if (n == k ){
                return nums[n];
            } else if ( n < k) {
                left = n + 1;
            } else {
                right = n -1;
            }
        }
        return -1;
    }

    public int quickSortIndex(int[] nums,int left, int right) {
        int pivot = nums[right];
        int l = left , r = right -1;

        while (l <= r){
            while (l <= r && nums[l] < pivot){
                l++;
            } 
            while (l <= r && nums[r] > pivot){
                r --;
            }
            if (l <= r){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] =temp;
                l++;
                r--;
            }
        }

        int temp = nums[l];
        nums[l] = pivot;
        nums[right] = temp;
        return l;
    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
