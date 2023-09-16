package Lesson7;

public class LessonSeven {

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int sumStringArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int[][] newArray = new int[4][4];
        int sum = 0;
        if ((array.length != 4) || (array[0].length != 4) || (array[1].length != 4)
         || (array[2].length != 4) || (array[3].length != 4)) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array[0].length; j++) {
                if (!isNumeric(array[i][j])) {
                    throw new MyArrayDataException(i,j);
                }
                else
                {
                    newArray[i][j] = Integer.parseInt(array[i][j]);
                    sum += newArray[i][j];
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        //полностью верный вариант массива
        String[][] strings1 = new String[][]{ {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"1", "2", "3", "4"}};

        //выбросит myArraySizeException
        String[][] strings2 = new String[][]{ {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"1", "2", "3"}};

        //Выбросит Lesson7.MyArrayDataException
        String[][] strings3 = new String[][]{ {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"1", "2", "3", "four"}};

        try {
            System.out.println(sumStringArray(strings3));
        }
        catch (Exception exc) {
            System.out.println(exc.toString());
        }
    }
}
