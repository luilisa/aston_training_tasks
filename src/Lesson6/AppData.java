package Lesson6;

import java.io.*;

public class AppData implements Serializable{
    private String[] header;
    private int[][] values;

    public AppData(String[] header, int[][] values) {
        this.header = header;
        this.values = values;
    }

    public AppData() {}

    public String toString() {
        String s = "";
        for (int i = 0; i < this.header.length; i ++) {
            if (i == header.length - 1) {
                s += this.header[i];
            } else {
                s += this.header[i] + ";";
            }
        }
        s += "\n";
        for (int i = 0; i < this.values.length; i ++) {
            for (int j = 0; j < this.values[i].length; j ++) {
                if (j == values[i].length - 1) {
                    s += this.values[i][j] + "\n";
                } else {
                    s += this.values[i][j] + ";";
                }
            }
        }
        return s;
    }

    //запись объекта в бинарный файл tmp.bin (хранит двоичную запись объекта)
    public static void writeObjectToTmpFile(AppData data) {
        try (FileOutputStream out = new FileOutputStream("tmp.bin");
             ObjectOutputStream objOut = new ObjectOutputStream(out)) {
            objOut.writeObject(data);
        } catch (IOException e) {
            System.out.println("Не удалось записать объект в tmp.bin");
        }
    }

    //Считывание объекта из tmp и запись в формате string в appd.csv
    public static void save(AppData data) {
        writeObjectToTmpFile(data);
        try (FileOutputStream out = new FileOutputStream("appd.csv");
             FileInputStream in = new FileInputStream("tmp.bin");
             ObjectInputStream objIn = new ObjectInputStream(in)) {
            AppData appData;
            appData = (AppData) objIn.readObject();
            out.write(appData.toString().getBytes());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Восстановление объекта, записанного в tmp.bin
    public static AppData read() {
        AppData appData = null;
        try (FileInputStream in = new FileInputStream("tmp.bin");
             ObjectInputStream objIn = new ObjectInputStream(in)) {
            appData = (AppData) objIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return appData;
    }


    public static void main(String[] args) {

        int[][] values1 = {{100, 200, 123, 400, 500},
                {300, 400, 500, 800, 500},
                {600, 700, 1000, 9, 800}};
        String[] header1 = {"Value 1", "Value 2", "Value 3", "Value 4", "Value 5"};

        int[][] values2 = {{100, 200, 123},
                {300, 400, 500},
                {600, 700, 1000}};
        String[] header2 = {"Value 1", "Value 2", "Value 3"};

        AppData appData1 = new AppData(header1, values1);
        AppData appData2 = new AppData(header2, values2);

        save(appData1);
        //save перезаписывает файл tmp и appd
        save(appData2);

        System.out.println(read().toString());
    }

}
