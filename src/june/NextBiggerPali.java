package june;


// Next higher palindromic number using the same set of digits


public class NextBiggerPali {

    public static String nextPalin(String num) {
        int n = num.length();
        if (n <= 3) return "-1";

        // Work with first half of the number
        char[] half = num.substring(0, n / 2).toCharArray();

        // Try to find next permutation of the first half
        if (!nextPermutation(half)) return "-1";

        // Form the palindrome using new half and its mirror
        StringBuilder res = new StringBuilder();
        res.append(half);

        // Add middle digit if length is odd
        if (n % 2 == 1) {
            res.append(num.charAt(n / 2));
        }

        // Append reverse of first half
        res.append(new StringBuilder(new String(half)).reverse());

        return res.toString();
    }

    // Standard next permutation logic
    private static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        // Swap
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Reverse the remaining
        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
