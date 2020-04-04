class Calculator {

    private String data;
    private int a;
    private int b;
    private int index;

    public Calculator(String data, int a, int b, int index) {
        this.data = data;
        this.a = a;
        this.b = b;
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getIndex() {
        return index;
    }

    int operation() {
        int result = 0;
        switch (data.charAt(index)) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }
        return result;
    }

    static boolean moreThanRomanTen(String romanNumber) {

        String value = romanNumber.toUpperCase();

        if (value.equals("I") || value.equals("II") || value.equals("III") || value.equals("IV")
                || value.equals("V") || value.equals("VI") || value.equals("VII")
                || value.equals("VIII") || value.equals("IX") || value.equals("X")) {
            return true;
        } else return false;
    }

    static int findSignIndex (String data){

        int index = 0;
        if (data.indexOf('+') != -1) {
            index = data.indexOf('+');
        } else if (data.indexOf('-') != -1) {
            index = data.indexOf('-');
        } else if (data.indexOf('*') != -1) {
            index = data.indexOf('*');
        } else if (data.indexOf('/') != -1) {
            index = data.indexOf('/');
        } else try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Уважаемый пользователь! Для корректной работы калькулятора необходим арифметический знак!");
        }
        return index;
    }

    public static class MoreThanTenException extends Exception {

        public MoreThanTenException() {
            super();
        }

        @Override
        public String toString() {
            return "Некорректное значение, введите числа от 1 до 10 или от I до X";
        }
    }
}
