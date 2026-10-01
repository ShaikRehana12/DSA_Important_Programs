package kaprekar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KaprekarGenerator {
    private static List<Integer> numToDigits(int num) {
        return Integer.toString(num)
                      .chars()
                      .boxed()
                      .map(ch -> Character.toString(ch))
                      .map(ch -> Integer.valueOf(ch)).toList();
    }

    private static int digitsToNum(List<Integer> digits) {
        // int num = 0;
        // for (int i = 0; i < digits.size(); i++) {
        //     num = num * 10 + digits.get(i);
        // }
        // return num;

        int num = 0;
        for (var dig : digits) {
            num = num * 10 + dig;
        }
        return num;

        // return Integer.valueOf(digits
        //                         .stream()
        //                         .map(dig -> Integer.toString(dig))
        //                         .collect(Collectors.joining()));
    }

    private static int ascDigitsRearrange(int num) {
        return digitsToNum(numToDigits(num)
                            .stream()
                            .sorted(Comparator.naturalOrder())
                            .toList());
    }

    private static int descDigitsRearrange(int num) {
        return digitsToNum(numToDigits(num)
                            .stream()
                            .sorted(Comparator.reverseOrder())
                            .toList());
    }

    private static int nextKaprekar(int num) {
        return descDigitsRearrange(num) - ascDigitsRearrange(num);
    }

    public static List<Integer> kaprekars(int start) {
        List<Integer> kaprekars = new ArrayList<>();
        int current = start;
        do {
            kaprekars.add(current);
            current = nextKaprekar(current);
        } while (!kaprekars.contains(current));
        return kaprekars;
    }

    public static void main(String ...args) {
        System.out.println(digitsToNum(numToDigits(1234)));
        System.out.println(ascDigitsRearrange(1234));
        System.out.println(descDigitsRearrange(1234));
        System.out.println(kaprekars(1234));
    }
}