package june;

// Max Difference You Can Get From Changing an Integer
public class MaxDiffYouCanGet {
    

    public int maxDiff(int num) {
        if (num / 10 == 0) {
            return 8;
        }
        

        String numStr = makeNumStr(num);

        int minNum = findMinNum(numStr);

        int maxNum = findMaxNum(numStr);

        // System.out.println("minNum="+minNum+", maxNum="+maxNum);

        return maxNum - minNum;
    }

    private int findMinNum(String numStr) {


        if (numStr.charAt(0) != '1') {
            numStr = numStr.replace(numStr.charAt(0),'1');
        } else {

            for (int i = 1 ; i < numStr.length() ; i++) {
                if (numStr.charAt(i) != '0' && numStr.charAt(i) != '1') {
                    numStr = numStr.replace(numStr.charAt(i),'0');
                    break;
                }
            }
        }

        return Integer.parseInt(numStr);


    }

    //todo
    private String makeNumStr(int num) {
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append(num%10);

            num /= 10;
        }

        return sb.reverse().toString();
    }

    private int findMaxNum(String numStr) {


        for (char c : numStr.toCharArray()) {
            if (c < '9') {
                numStr = numStr.replace(c,'9');

                return Integer.parseInt(numStr);
            }
        }

        return Integer.parseInt(numStr);
    }
    
}
