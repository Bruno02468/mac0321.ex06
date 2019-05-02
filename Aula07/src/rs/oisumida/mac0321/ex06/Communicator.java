package rs.oisumida.mac0321.ex06;

import java.util.ArrayList;
import java.util.Scanner;

public class Communicator {
	public static String ANSI_RESET   = "";
	public static String ANSI_BLACK   = "";
	public static String ANSI_RED     = "";
	public static String ANSI_GREEN   = "";
	public static String ANSI_YELLOW  = "";
	public static String ANSI_BLUE    = "";
	public static String ANSI_MAGENTA = "";
	public static String ANSI_CYAN    = "";
	public static String ANSI_WHITE   = "";
	public static String ANSI_BOLD    = "";
	private static Scanner scanner;
	
	public static void start() {
		scanner = new Scanner(System.in);
	}
	
	static void enableColors() {
		ANSI_RESET   = "\u001B[0m";
		ANSI_BLACK   = "\u001B[30m";
		ANSI_RED     = "\u001B[31m";
		ANSI_GREEN   = "\u001B[32m";
		ANSI_YELLOW  = "\u001B[33m";
		ANSI_BLUE    = "\u001B[34m";
		ANSI_MAGENTA = "\u001B[35m";
		ANSI_CYAN    = "\u001B[36m";
		ANSI_WHITE   = "\u001B[37m";
		ANSI_BOLD    = "\u001B[1m";
	}
	
	public static int getInt(int min, int max) {
		while (true) {
			System.out.print(ANSI_RESET+"> ");
			try {
				int val = scanner.nextInt();
				if (min <= val && val <= max) {
					return val;
				}
			} catch (Exception e) {
				scanner.nextLine();
			}
			System.out.println(ANSI_BOLD+ANSI_RED+"Opção Inválida"+ANSI_RESET);
		}
	}
	public static boolean getBool() {
		while (true) {
			System.out.print(ANSI_RESET+"> ");
			String val = scanner.next().replaceAll("\\s", "").toUpperCase();
			if (val.equals("S") || val.equals("Y")) {
				return true;
			}
			if (val.equals("N")) {
				return false;
			}
			System.out.println(ANSI_BOLD+ANSI_RED+"Opção Inválida"+ANSI_RESET);
		}
	}
	public static String getString() {
		while (true) {
			System.out.print(ANSI_RESET+"> ");
			String val = scanner.next().replaceAll("\\s", "");
			if (val.length() != 0) {
				return val;
			}
			System.out.println(ANSI_BOLD+ANSI_RED+"Opção Inválida"+ANSI_RESET);
		}
	}
	public static Object askWhich(Object opts[]) {
		return Communicator.askWhich("Escolha uma opção:", opts);
	}
	public static Object askWhich(String prompt, Object opts[]) {
		System.out.println(prompt);
		for (int i=1; i <= opts.length; i++) {
			System.out.print("[");
			System.out.print(i);
			System.out.println("] "+opts[i-1].toString());
		}
		int pos = Communicator.getInt(1, opts.length);
		pos -= 1;
		return opts[pos];
	}
	public static void passMessage(String str) {
		System.out.println(str);
	}

	public static void divider() {
		System.out.println("---------------------------------");
	}

	@SuppressWarnings("unchecked")
	public static <T> T askWhich(String prompt, ArrayList<T> opts) {
		return (T) Communicator.askWhich(prompt, opts.toArray());
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T askWhichArrayList(String prompt, ArrayList<T> opts) {
		return (T) Communicator.askWhich(prompt, opts.toArray());
	}
}
