public class MoreThanTenException extends Exception {

    public MoreThanTenException() {
        super();
    }

    @Override
    public String toString() {
        return "Некорректное значение, введите числа от 1 до 10 или от I до X";
    }
}
