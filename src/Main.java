import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static boolean isInt(String value1, String value2) {
        try {
            var isInt1 = Integer.parseInt(value1);
            var isInt2 = Integer.parseInt(value2);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isInt(String value) {
        try {
            var isInt = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) throws IOException, MoreThanTenException, IncompatibleValuesException {
        String value1 = null;
        String value2 = null;
        int a = 0;
        int b = 0;
        int index = 0;


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        data = data.replaceAll(" ", "");


        index = Calculator.findSignIndex(data);

        value1 = data.substring(0, index);
        value2 = data.substring(index + 1);

        if (isInt(value1, value2)) {
            a = Integer.parseInt(value1);
            b = Integer.parseInt(value2);

            if (a <= 10 && 10 >= b) {
                Calculator arabicCalculator = new Calculator(data, a, b, index);
                int result = arabicCalculator.operation();
                System.out.println(result);
            }
            else {
                throw new MoreThanTenException();
            }
        } else {
            if (!isInt(value1) && !isInt(value2)) {
                if (Calculator.moreThanRomanTen(value1) && Calculator.moreThanRomanTen(value2)) {
                    a = NumberConverter.convertRomanToArabic(value1.toUpperCase());
                    b = NumberConverter.convertRomanToArabic(value2.toUpperCase());

                    Calculator romanCalculator = new Calculator(data, a, b, index);
                    int result = romanCalculator.operation();

                    String romanResult = NumberConverter.RomanNumeral.convertArabicToRoman(result);
                    System.out.println(romanResult);
                } else throw new MoreThanTenException();
            } else throw new IncompatibleValuesException();
        }
    }
}
