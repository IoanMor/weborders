package my.project.weborders.util;

public final class NormalizeData {
    public static String normalizePhone(String rawPhone) {
        String digits = rawPhone.replaceAll("[^0-9]", "");

        if (digits.isEmpty()) return rawPhone;

        if (digits.startsWith("8")) {
            digits = "7" + digits.substring(1);
        }
        if (digits.length() == 10 && digits.startsWith("9")) {
            digits = "7" + digits;
        }
        return digits;
    }
}
