import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductCodeTransformer {

    public static String transformProductCode(String code) {
        List<Character> uppercaseLetters = new ArrayList<>();
        int integerSum = 0;
        int i = 0;

        while (i < code.length()) {
            if (Character.isUpperCase(code.charAt(i))) {
                uppercaseLetters.add(code.charAt(i));
                i++;
            } else if (code.charAt(i) == '-') {
                int j = i + 1;
                while (j < code.length() && Character.isDigit(code.charAt(j))) {
                    j++;
                }
                integerSum += Integer.parseInt(code.substring(i + 1, j));
                i = j;
            } else if (Character.isDigit(code.charAt(i))) {
                int j = i;
                while (j < code.length() && Character.isDigit(code.charAt(j))) {
                    j++;
                }
                integerSum += Integer.parseInt(code.substring(i, j));
                i = j;
            } else {
                i++;
            }
        }

        StringBuilder newCode = new StringBuilder();
        for (char ch : uppercaseLetters) {
            newCode.append(ch);
        }
        newCode.append(integerSum);
        return newCode.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 0; i < N; i++) {
            String originalCode = scanner.nextLine().trim();
            String newCode = transformProductCode(originalCode);
            System.out.println(newCode);
        }

        scanner.close();
    }
}
