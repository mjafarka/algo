package april;

public class CountGoodTriplets {
	/**
	 * brute force
	 * @param arr
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int countGoodTriplets(int[] arr, int a, int b, int c) {

		int count = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
							&& Math.abs(arr[i] - arr[k]) <= c) {
						count++;
					}
				}
			}
		}

		return count;
	}
	
	/**
	 * a small optimization, since input size is small
	 * @param arr
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int countGoodTriplets1(int[] arr, int a, int b, int c) {
        int count=0;
        int l=arr.length;
        for(int i=0;i<l-2;i++){
            for(int j=i+1;j<l-1;j++){
                if(Math.abs(arr[i]-arr[j]) <= a ){
                    for(int k=j+1;k<l;k++){
                        if(Math.abs(arr[j]-arr[k]) <=b && 
                        Math.abs(arr[i]-arr[k]) <=c){
                            count++;
                        }
                    }
                }
            }
        }return count;
    }
}


