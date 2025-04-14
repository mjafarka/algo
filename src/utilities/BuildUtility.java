package utilities;

import java.util.Arrays;

public class BuildUtility {

	public static int[] createArrFromString(String nextLine) {
		
		String[] strArr = nextLine.split(",");
		
		int[] res = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
				
		return res;
	}

}
