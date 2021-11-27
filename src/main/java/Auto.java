import java.text.SimpleDateFormat;
import java.util.Date;

public class Auto {

    int amountOfFuelInTheTank;
    double fuelConsumption;
    String dateOfInspection;


    public Auto(int amountOfFuelInTheTank, double fuelConsumption, String dateOfInspection) {
        this.amountOfFuelInTheTank = amountOfFuelInTheTank;
        this.fuelConsumption = fuelConsumption;
        this.dateOfInspection = dateOfInspection;
    }
    public int getAmountOfFuelInTheTank() {
        return amountOfFuelInTheTank;
    }
    public double getFuelConsumption() {
        return fuelConsumption;
    }
    public String getDateOfInspection() {
        return dateOfInspection;
    }


    //Машина может ехать -> если у нее не пустой бак
    public boolean CanGo() {
        return amountOfFuelInTheTank > 0;
    }

    //Машина допущена к эксплуатации -> если у дата техосмотра не превышает 2 года
    public boolean ApprovedForUse() {
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
    public double CarCanGo() {
        double distance;
        distance = amountOfFuelInTheTank / fuelConsumption * 100;
        System.out.println("distance traveled by the car:" + distance);
        return distance;

    }
}
