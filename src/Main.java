/**
 ДЗ №2 - Исключения
 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и
 вывести результат расчета.
 */

public class Main {
    public static void main(String[] args) {

        String[][] arr = new String[][]{{"9", "7", "4", "10"}, {"0", "2", "5", "3"}, {"4", "2", "4", "2"}, {"1", "2", "3", "2"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeExc e) {
                System.out.println("Размер массива превышен");
            }
        }
        catch (MyArrayDataExc e) {
            System.out.println("Неправильное значение массива");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }
    }

    public static int method(String[][] arr) throws MyArraySizeExc, MyArrayDataExc {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeExc();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeExc();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataExc(i, j);
                }
            }
        }
        return count;
    }
}
