package rs.oisumida.mac0321.ex06;

import java.util.Scanner;

public class Communicator {
	public static String ANSI_RESET = "";
	public static String ANSI_BLACK = "";
	public static String ANSI_RED = "";
	public static String ANSI_GREEN = "";
	public static String ANSI_YELLOW = "";
	public static String ANSI_BLUE = "";
	public static String ANSI_MAGENTA = "";
	public static String ANSI_CYAN = "";
	public static String ANSI_WHITE = "";
	public static String ANSI_BOLD = "";
	private static Scanner scanner;
	
	public static void start() {
		scanner = new Scanner(System.in);
	}
	
	static void enableColors() {
		ANSI_RESET = "\u001B[0m";
		ANSI_BLACK = "\u001B[30m";
		ANSI_RED = "\u001B[31m";
		ANSI_GREEN = "\u001B[32m";
		ANSI_YELLOW = "\u001B[33m";
		ANSI_BLUE = "\u001B[34m";
		ANSI_MAGENTA = "\u001B[35m";
		ANSI_CYAN = "\u001B[36m";
		ANSI_WHITE = "\u001B[37m";
		ANSI_BOLD = "\u001B[1m";
	}
	
	public static int getInt(int min, int max) {
		System.out.print(ANSI_RESET+"> ");
		while (true) {
			int val = scanner.nextInt();
			if (min <= val && val <= max) {
				return val;
			}
			System.out.println(ANSI_BOLD+ANSI_RED+"Opção Inválida"+ANSI_RESET);
		}
	}
	public static boolean getBool() {
		System.out.print(ANSI_RESET+"> ");
		while (true) {
			String val = scanner.next().replaceAll("\\s", "");
			System.out.println(val);
			if (val.equals("S") || val == "s" || val == "Y" || val == "y") {
				return true;
			}
			if (val.equals("N") || val == "n") {
				return false;
			}
			System.out.println(ANSI_BOLD+ANSI_RED+"Opção Inválida"+ANSI_RESET);
		}
	}
	public static Object askWhich(Object opts[]) {
		System.out.println("Escolha uma opção:");
		for (int i=1; i <= opts.length; i++) {
			System.out.print("[");
			System.out.print(i);
			System.out.print("] "+opts[i].toString());
		}
		return Communicator.getInt(1, opts.length);
	}
	public static void passMessage(String str) {
		System.out.println(str);
	}
}
