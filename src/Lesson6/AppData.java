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

    //Считывание объекта из tmp и запись в формате string в appd.csv
    public static void save(AppData data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("appd.csv"))) {
        bw.write(data.toString());
        } catch (IOException e) {
        e.printStackTrace();
        }
    }

    //считает количество строк в файле, не считая headers
    public int countRowsInFile(String file) {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((br.readLine())!=null) {
                i++;
            }
        }
        catch (IOException exc){
            exc.printStackTrace();

        }
        return i-1;
    }

    //считывает файл и записывает данные в экзмепляр AppData
    public void readFromCSV(String file) {
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String s;

            if ((s = br.readLine())!=null) {
                this.header = s.split(";");
            }

            String[][] valuesString = new String[countRowsInFile(file)][];

            int i = 0;
            while (((s = br.readLine())!=null)) {
                valuesString[i] = s.split(";");
                i++;
            }
            this.values = new int[valuesString.length][valuesString[0].length];
            for (int x = 0; x < valuesString.length; x ++) {
                for (int y = 0; y < valuesString[x].length; y ++) {
                    this.values[x][y] = Integer.parseInt(valuesString[x][y]);
                }
            }

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) {

        int[][] values1 = {{100, 200, 123},
                {300, 400, 500},
                {600, 700, 1000}};
        String[] header1 = {"Value 1", "Value 2", "Value 3"};

        int[][] values2 = {{100, 200, 123, 400, 500},
                {300, 400, 500, 800, 500},
                {600, 700, 1000, 9, 800}};
        String[] header2 = {"Value 1", "Value 2", "Value 3", "Value 4", "Value 5"};

        AppData appData1 = new AppData(header1, values1);
        AppData appData2 = new AppData(header2, values2);
        AppData appData3 = new AppData();

//        Запишем в файл csv созданный объект appData1 со значениями header1 и values1
        save(appData1);
        System.out.println("Записанные значения объекта appData1 в файле csv\n" + appData1.toString());

        //Прочитаем файл appd.csv и запишем его данные в новый, пустой объект appData3
        appData3.readFromCSV("appd.csv");
        System.out.println("Значения объекта appData3, заполненные из файла appd.csv:\n" + appData3.toString());

        //Запишем в файл csv созданный объект appData2 со значениями header2 и values2
        save(appData2);
        System.out.println("Записанные значения объекта appData2 в файле csv\n" + appData2);

//        Прочитаем файл appd.csv и запишем его данные в объект appData3
        appData3.readFromCSV("appd.csv");
        System.out.println("Новые значения appData3:\n" + appData3.toString());

    }

}
