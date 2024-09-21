import java.text.DecimalFormat;
import java.util.*;

public class NumberToWords {

    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final String[] thousands = {
            "", "thousand", "million", "billion"
    };

    public static String convert(int number) {
        if (number == 0) {
            return "zero";
        }

        String wordRepresentation = "";

        int thousandGroup = 0;

        while (number > 0) {
            int remainder = number % 1000;
            if (remainder != 0) {
                String groupWords = convertLessThanThousand(remainder);
                wordRepresentation = groupWords + " " + thousands[thousandGroup] + " " + wordRepresentation;
            }
            number /= 1000;
            thousandGroup++;
        }

        return wordRepresentation.trim();
    }

    private static String convertLessThanThousand(int number) {
        String wordRepresentation;

        if (number % 100 < 20) {
            wordRepresentation = units[number % 100];
            number /= 100;
        } else {
            wordRepresentation = units[number % 10];
            number /= 10;

            wordRepresentation = tens[number % 10] + " " + wordRepresentation;
            number /= 10;
        }
        if (number > 0) {
            wordRepresentation = units[number] + " hundred " + wordRepresentation;
        }

        return wordRepresentation.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number :-");
        int a = sc.nextInt();
        System.out.println("Output: '" + convert(a) + "'");
    }
}