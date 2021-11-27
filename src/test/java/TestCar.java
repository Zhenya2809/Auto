import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestCar {
    @Test
    void shouldCreateCar() {
        Auto car = new Auto(60, 16.5, "27.11.2020");

        int tank = car.getAmountOfFuelInTheTank();
        double comsumption = car.getFuelConsumption();
        String DateInspection = car.getDateOfInspection();

        Assertions.assertEquals(tank, 60);
        Assertions.assertEquals(comsumption, 16.5);
        Assertions.assertEquals(DateInspection, "27.11.2020");
    }

    @Test
    void testCarCanGoWithEmptyTank() {
        Auto car = new Auto(0, 16.5, "27.11.2020");
        Assertions.assertFalse(car.CanGo());
    }
    @Test
    void testCarCanGoWithFullTank() {
        Auto car = new Auto(60, 16.5, "27.11.2020");
        Assertions.assertTrue(car.CanGo());
    }
    @Test
    void testAprovedForUseCarMoreThen2Years(){
        Auto car = new Auto(60, 16.5, "27.11.2017");
        Assertions.assertFalse(car.ApprovedForUse());
    }
    @Test
    void testAprovedForUseCarLessThen2Years(){
        Auto car = new Auto(60, 16.5, "27.11.2020");
        Assertions.assertTrue(car.ApprovedForUse());
    }
    @Test
    void testCarCanGO500kmWith50lTank(){
        Auto car = new Auto(50, 10d, "27.11.2020");
        Assertions.assertEquals(car.CarCanGo(),500);
    }
}
