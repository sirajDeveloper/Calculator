import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NumberConverter {

    public static int convertRomanToArabic(String rome) {

        int result = 0;
        switch (rome) {
            case "I":
                result = 1;
                break;
            case "II":
                result = 2;
                break;
            case "III":
                result = 3;
                break;
            case "IV":
                result = 4;
                break;
            case "V":
                result = 5;
                break;
            case "VI":
                result = 6;
                break;
            case "VII":
                result = 7;
                break;
            case "VIII":
                result = 8;
                break;
            case "IX":
                result = 9;
                break;
            case "X":
                result = 10;
                break;
        }
        return result;
    }


    /*Вложенный Enum класс RomanNumeral с его методами имплементирован. Код написан не мной. Но я немного добавил
    в него значений.
     */
    public enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }

        public static String convertArabicToRoman(int number) {
            if ((number <= 0) || (number > 4000)) {
                throw new IllegalArgumentException(number + " is not in range (0,4000]");
            }

            List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

            int i = 0;
            StringBuilder sb = new StringBuilder();

            while ((number > 0) && (i < romanNumerals.size())) {
                RomanNumeral currentSymbol = romanNumerals.get(i);
                if (currentSymbol.getValue() <= number) {
                    sb.append(currentSymbol.name());
                    number -= currentSymbol.getValue();
                } else {
                    i++;
                }
            }

            return sb.toString();
        }
    }
}
