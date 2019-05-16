package rs.oisumida.mac0321.ex06;

public class ProgressBar {	
	static public String toString(int val, int max_val, int width) {
		String chars[] = {"█", "▉", "▊", "▋", "▌", "▍", "▎", "▏"};
		int char_val[] = {0, 0, 0, 0, 0, 0, 0, 0};
		int n_char = chars.length;
		
		for (int i=0; i < n_char; i++) {
			char_val[i] = (n_char-i) * max_val/(width*n_char);
		}
		
		String str = "";
		int remaining = val;
		int fulls = width * val/max_val;
		int mode = 0;
		for (int i=0; i < width; i++) {
			if (mode == 0) {
				if (i < fulls) {
					str += chars[0];
					remaining -= char_val[0];
				} else {
					mode = 1;
				}
			}
			if (mode == 1) {
				String next = " ";
				for (int j=1; j < n_char; j++) {
					if (remaining >= char_val[j]) {
						next = chars[j];
						break;
					}
				}
				str += next;
				mode = 2;
			} else if (mode == 2) {
				str += " ";
			}
		}
		return "["+str+"]";
	}
}
