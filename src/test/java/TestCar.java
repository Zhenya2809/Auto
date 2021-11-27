import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestCar {
    @Test
    void shouldCreateCar() {
        // given
        Auto car = new Auto(60, 16.5, "27.11.2020");
        // when
        int tank = car.getAmountOfFuelInTheTank();
        double comsumption = car.getFuelConsumption();
        String DateInspection = car.getDateOfInspection();
        // then
        Assertions.assertEquals(tank, 60);
        Assertions.assertEquals(comsumption, 16.5);
        Assertions.assertEquals(DateInspection, "27.11.2020");
    }

    @Test
    void testCarCanGoWithEmptyTank() {
        Auto car = new Auto(0, 16.5, "27.11.2020");
        System.out.println("может ли поехать авто с пустым баком?");
        Assertions.assertFalse(Auto.CanGo(car.amountOfFuelInTheTank));
    }
    @Test
    void testCarCanGoWithFullTank() {
        Auto car = new Auto(60, 16.5, "27.11.2020");
        System.out.println("может ли поехать авто с полным баком?");
        Assertions.assertTrue(Auto.CanGo(car.amountOfFuelInTheTank));
    }
    @Test
    void testAprovedForUseCarMoreThen2Years(){
        Auto car = new Auto(60, 16.5, "27.11.2017");
        System.out.println("можно ли использовать машину, если времени с ТО прошло больше 2 лет?");
        Assertions.assertFalse(Auto.ApprovedForUse(car.getDateOfInspection()));
    }
    @Test
    void testAprovedForUseCarLessThen2Years(){
        Auto car = new Auto(60, 16.5, "27.11.2020");
        System.out.println("можно ли использовать машину, если времени с ТО прошло меньше 2 лет?");
        Assertions.assertTrue(Auto.ApprovedForUse(car.getDateOfInspection()));
    }
    @Test
    void testCarCanGO500kmWith50lTank(){
        Auto car = new Auto(50, 10d, "27.11.2020");
        System.out.println("проедет ли машина 500 км с расходом 10л /100км с заполненым баком на 50л?");
        Assertions.assertEquals(Auto.CarCanGo(car.getAmountOfFuelInTheTank(),car.getFuelConsumption()),500);
    }
}
