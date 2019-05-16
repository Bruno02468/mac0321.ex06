package rs.oisumida.mac0321.ex06;

public class ProgressBar {	
	static public String toString(int val, int max_val, int width) {
		String chars[] = {"█", "▓", "▒", "░"};
		int char_val[] = {0, 0, 0, 0};
		int n_char = chars.length;
		
		for (int i=0; i < n_char; i++) {
			char_val[i] = (n_char-i) * max_val/(width*n_char);
		}
		
		int remaining = val;
		String str = "[";
		for (int i=0; i < width; i++) {
			String next = "-";
			for (int j=0; j < n_char; j++) {
				if (remaining >= char_val[j]) {
					next = chars[j];
					remaining -= char_val[j];
					break;
				}
			}
			if (i == width-1 && next == chars[0] && val < max_val) {
				next = chars[1];
			}
			if (i == 0 && next == "-" && val > 0) {
				next = chars[n_char-1];
			}
			str += next;
		}
		str += "]";
		return str;
	}
}
