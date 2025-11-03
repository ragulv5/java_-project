import java.util.Scanner;
import java.security.SecureRandom;

public class PasswordGenerator {

    // Character groups
    static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lower = "abcdefghijklmnopqrstuvwxyz";
    static String digits = "0123456789";
    static String special = "!@#$%^&*()-_=+[]{}<>?/";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.println("===== PASSWORD GENERATOR =====");

        // Input length
        System.out.print("Enter password length: ");
        int length = sc.nextInt();

        // Input options
        System.out.print("Include uppercase letters? (true/false): ");
        boolean useUpper = sc.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean useLower = sc.nextBoolean();

        System.out.print("Include digits? (true/false): ");
        boolean useDigits = sc.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean useSpecial = sc.nextBoolean();

        // Validate input
        if (length < 1) {
            System.out.println("Password length must be greater than 0!");
            return;
        }

        if (!useUpper && !useLower && !useDigits && !useSpecial) {
            System.out.println("You must select at least one character type!");
            return;
        }

        String selectedChars = "";
        if (useUpper) selectedChars += upper;
        if (useLower) selectedChars += lower;
        if (useDigits) selectedChars += digits;
        if (useSpecial) selectedChars += special;

        char[] password = new char[length];

        // Ensure at least one of each selected type
        int index = 0;

        if (useUpper) password[index++] = upper.charAt(random.nextInt(upper.length()));
        if (useLower) password[index++] = lower.charAt(random.nextInt(lower.length()));
        if (useDigits) password[index++] = digits.charAt(random.nextInt(digits.length()));
        if (useSpecial) password[index++] = special.charAt(random.nextInt(special.length()));

        // Fill remaining characters
        for (int i = index; i < length; i++) {
            password[i] = selectedChars.charAt(random.nextInt(selectedChars.length()));
        }

        // Print password
        System.out.print("Generated Password: ");
        for (char c : password) {
            System.out.print(c);
        }

        System.out.println("\n===============================");
        sc.close();
    }
}
