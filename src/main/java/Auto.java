import java.text.SimpleDateFormat;
import java.util.Date;

public class Auto {

    int FuelInTank;
    double Consumption;
    String dateOfInspection;


    public Auto(int FuelInTank, double Consumption, String dateOfInspection) {
        this.FuelInTank = FuelInTank;
        this.Consumption = Consumption;
        this.dateOfInspection = dateOfInspection;
    }
    public int getFuelInTank() {
        return FuelInTank;
    }
    public double getConsumption() {
        return Consumption;
    }
    public String getDateOfInspection() {
        return dateOfInspection;
    }


    //Машина может ехать -> если у нее не пустой бак
    public boolean canGo() {
        return FuelInTank > 0;
    }

    //Машина допущена к эксплуатации -> если у дата техосмотра не превышает 2 года
    public boolean approvedForUse() {
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
        return days <= 730;
    }

    //Сколько машина может проехать
    public double carDistance() {
        double distance;
        distance = FuelInTank / Consumption * 100;
        return distance;

    }
}
