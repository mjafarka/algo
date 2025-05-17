package may;

/* Reverse Words in a String */
public class ReverseWordInAString {
	public String reverseWords(String s) {

		int n = s.length();
		StringBuilder res = new StringBuilder();

		int i = s.length() - 1;

		while (i >= 0) {
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
			}

			if (i == -1) {
				break;
			}

			int st = i;

			while (i >= 0 && s.charAt(i) != ' ') {
				i--;
			}

			res.append(s.substring(i + 1, st + 1));
			res.append(' ');
		}

		if (res.length() > 0) {
			res.setLength(res.length() - 1);
		}

		return res.toString();
	}
}
