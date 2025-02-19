import java.util.Scanner;

public class MaxSunnyDays {

    public static int maxSunnyDays(int n, String weather) {
        // Split the weather string by 'P' and get the lengths of the 'S' segments
        String[] segments = weather.split("P");
        int maxOriginal = 0;

        // Find the maximum length of 'S' segments
        for (String segment : segments) {
            if (segment.length() > maxOriginal) {
                maxOriginal = segment.length();
            }
        }

        // If there are no 'P's, return the maximum length of 'S' segments
        if (segments.length == 1) {
            return maxOriginal;
        }

        // Calculate the maximum consecutive 'S' days by combining adjacent segments
        int maxConsecutive = 0;
        for (int i = 0; i < segments.length - 1; i++) {
            int combinedLength = segments[i].length() + 1 + segments[i + 1].length();
            if (combinedLength > maxConsecutive) {
                maxConsecutive = combinedLength;
            }
        }

        // Return the maximum of the original maximum and the combined maximum
        return Math.max(maxOriginal, maxConsecutive);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of lines
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Read the weather data
        StringBuilder weatherBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            weatherBuilder.append(scanner.nextLine().trim());
        }
        String weather = weatherBuilder.toString();

        // Calculate and print the result
        System.out.println(maxSunnyDays(n, weather));

        scanner.close();
    }
}
