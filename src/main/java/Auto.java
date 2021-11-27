import java.text.SimpleDateFormat;
import java.util.Date;

public class Auto {
    int amountOfFuelInTheTank;

    public Auto(int amountOfFuelInTheTank, double fuelConsumption, String dateOfInspection) {
        this.amountOfFuelInTheTank = amountOfFuelInTheTank;
        this.fuelConsumption = fuelConsumption;
        this.dateOfInspection = dateOfInspection;
    }

    public Auto() {
    }

    public int getAmountOfFuelInTheTank() {
        return amountOfFuelInTheTank;
    }

    public void setAmountOfFuelInTheTank(int amountOfFuelInTheTank) {
        this.amountOfFuelInTheTank = amountOfFuelInTheTank;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getDateOfInspection() {
        return dateOfInspection;
    }

    public void setDateOfInspection(String dateOfInspection) {
        this.dateOfInspection = dateOfInspection;
    }

    double fuelConsumption;
    String dateOfInspection;


    //Машина может ехать -> если у нее не пустой бак
    public static boolean CanGo(double amountOfFuelInTheTank) {
        return amountOfFuelInTheTank > 0;
    }

    //Машина допущена к эксплуатации -> если у дата техосмотра не превышает 2 года
    public static boolean ApprovedForUse(String dateOfInspection) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOne = null;
        Date todaySdate = new Date();
        try {
            dateOne = format.parse(dateOfInspection);

        } catch (Exception e) {
            e.printStackTrace();
        }
        assert dateOne != null;
        long difference = todaySdate.getTime() - dateOne.getTime();
        int days = (int) (difference / (24 * 60 * 60 * 1000));
        System.out.println("today's Date :" + todaySdate);
        System.out.println("Days with inspection :" + days);
        return days <= 730;
    }

    //Сколько машина может проехать
    public static double CarCanGo(int tank, double Consumption) {
        double distance;
        distance = tank / Consumption * 100;
        System.out.println("distance traveled by the car:" + distance);
        return distance;

    }
}
