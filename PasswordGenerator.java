import java.util.Scanner;
import java.security.SecureRandom;

public class PasswordGenerator {

    // Arrays for characters
    static char[] uppercase = {
        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };

    static char[] lowercase = {
        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
    };

    static char[] digits = {
        '0','1','2','3','4','5','6','7','8','9'
    };

    static char[] special = {
        '!','@','#','$','%','^','&','*','(',')','-','_','+','=','?'
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.println("===== PASSWORD GENERATOR =====");
        System.out.print("Enter password length: ");
        int length = sc.nextInt();

        System.out.print("Use uppercase letters? (true/false): ");
        boolean useUpper = sc.nextBoolean();

        System.out.print("Use lowercase letters? (true/false): ");
        boolean useLower = sc.nextBoolean();

        System.out.print("Use digits? (true/false): ");
        boolean useDigits = sc.nextBoolean();

        System.out.print("Use special characters? (true/false): ");
        boolean useSpecial = sc.nextBoolean();

        if (length <= 0) {
            System.out.println("Password length must be greater than 0.");
            return;
        }

        if (!useUpper && !useLower && !useDigits && !useSpecial) {
            System.out.println("You must select at least one character type.");
            return;
        }

        char[] password = new char[length];

        // Guarantee at least one of each selected type
        int index = 0;

        if (useUpper) {
            password[index++] = uppercase[random.nextInt(uppercase.length)];
        }

        if (useLower) {
            password[index++] = lowercase[random.nextInt(lowercase.length)];
        }

        if (useDigits) {
            password[index++] = digits[random.nextInt(digits.length)];
        }

        if (useSpecial) {
            password[index++] = special[random.nextInt(special.length)];
        }

        // Fill the remaining password characters
        for (int i = index; i < length; i++) {

            int choice = random.nextInt(4); // select char type

            if (choice == 0 && useUpper) {
                password[i] = uppercase[random.nextInt(uppercase.length)];
            }
            else if (choice == 1 && useLower) {
                password[i] = lowercase[random.nextInt(lowercase.length)];
            }
            else if (choice == 2 && useDigits) {
                password[i] = digits[random.nextInt(digits.length)];
            }
            else if (choice == 3 && useSpecial) {
                password[i] = special[random.nextInt(special.length)];
            }
            else {
                i--; // try again if type not allowed
            }
        }

        // Print final password
        System.out.print("Generated Password: ");
        for (char c : password) {
            System.out.print(c);
        }

        System.out.println("\n================================");
        sc.close();
    }
}
