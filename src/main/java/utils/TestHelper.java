package utils;

public class TestHelper {
	public static String formatPhone(String phoneNumber) {
		return phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
	}
	
	public static String formatPhonoWithExtention(String phoneNumber, String extention) {
		return formatPhone(phoneNumber) + " x" + extention;
	}
	
	public static String formatAmount(String amount) {
		return String.format("$%,.2f", Double.parseDouble(amount));
	}

}
