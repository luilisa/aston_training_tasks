package Lesson7;

public class MyArrayDataException extends Exception{
    int i, j;
    public MyArrayDataException(int i, int j){
        this.i = i;
        this.j = j;
    }
    public String toString() {
        return "Невозможно преобразовать данные в ячейке: " + this.i + " " + this.j;
    }
}
