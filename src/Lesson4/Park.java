package Lesson4;

import java.util.ArrayList;

public class Park {
    String parkName;
    String address;
    ArrayList<Attraction> attractions;

    Park(String parkName, String address, ArrayList<Attraction> attractions) {
        this.parkName = parkName;
        this.address = address;
        this.attractions = attractions;
    }

    class Attraction {
        String attractionName;
        String workingHours;
        int price;
        String group;

        Attraction(String attractionName, String workingHours, int price, String group) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
            this.group = group;
        }


        public String attractionInfo() {
            return "Аттракцион " + attractionName +
                    " находится в парке " + Park.this.parkName +
                    " по адресу: " + Park.this.address +
                    " и доступен в период " + workingHours +
                    ", стоимость аттракциона: " + price +
                    ", группа: " + group + "\n";
        }
    }

    public static void main(String[] args) {

        ArrayList<Park.Attraction> divoOstrovAttractions = new ArrayList<>();

        Park divoOstrov = new Park("Диво остров", "Кемская ул., 1А, Санкт-Петербург", divoOstrovAttractions);

        Park.Attraction wingedSwing = divoOstrov.new Attraction("Крылатые качели", "с 10 до 21 ч", 500, "Экстремальная группа");
        Park.Attraction coolRacing = divoOstrov.new Attraction("Крутые гонки", "с 11 до 21 ч", 350, "Семейная группа");
        Park.Attraction zigzag = divoOstrov.new Attraction("Зиг-заг", "с 11 до 21 ч", 150, "Детская группа");

        divoOstrovAttractions.add(wingedSwing);
        divoOstrovAttractions.add(coolRacing);
        divoOstrovAttractions.add(zigzag);

        for (Attraction attraction: divoOstrovAttractions) {
            System.out.println(attraction.attractionInfo());
        }

        ArrayList<Park.Attraction> parkYeseninAttractions = new ArrayList<>();

        Park parkYesenin = new Park("Парк им. Есенина", "ул. Подвойского, 28-а, Санкт-Петербург", parkYeseninAttractions);

        Park.Attraction ferrisWheel = parkYesenin.new Attraction("Колесо обозрения", "с 11 до 20 ч", 250, "Семейная группа");
        Park.Attraction lighthouse = parkYesenin.new Attraction("Маяк", "с 11 до 20 ч", 300, "Семейная группа");

        parkYeseninAttractions.add(ferrisWheel);
        parkYeseninAttractions.add(lighthouse);

        for (Attraction attraction: parkYeseninAttractions) {
            System.out.println(attraction.attractionInfo());
        }

    }
}

