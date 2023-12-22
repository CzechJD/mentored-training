package exceptions;

public class exceptionBasics {
    public static void main(String[] args) {
        try {
            int[] array = {1, 4, 7, 10};
            printArrayElement(array, 3);
            System.out.println(divisionOfIntegers(5, 0));
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы массива");
        } catch (ArithmeticException exception) {
            throw new ArithmeticException("Деление на 0 невозможно");
        } finally {
            System.out.println("Завершение блока try-catch");
        }
    }

    public static int divisionOfIntegers(int num1, int num2) {
        return num1 / num2;
    }

    public static void printArrayElement(int[] array, int index) {
        System.out.println(array[index]);
    }
}
