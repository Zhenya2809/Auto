import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestCar {
    @Test
    void shouldCreateCar() {
        Auto car = new Auto(60, 16.5, "27.11.2020");

        int tank = car.getFuelInTank();
        double consumption = car.getConsumption();
        String DateInspection = car.getDateOfInspection();

        Assertions.assertEquals(tank, 60);
        Assertions.assertEquals(consumption, 16.5);
        Assertions.assertEquals(DateInspection, "27.11.2020");
    }

    @Test
    void testEmptyTank() {
        Auto car = new Auto(0, 16.5, "27.11.2020");
        Assertions.assertFalse(car.canGo());
    }
    @Test
    void testFullTank() {
        Auto car = new Auto(60, 16.5, "27.11.2020");
        Assertions.assertTrue(car.canGo());
    }
    @Test
    void testMoreThen2Years(){
        Auto car = new Auto(60, 16.5, "27.11.2017");
        Assertions.assertFalse(car.approvedForUse());
    }
    @Test
    void testLessThen2Years(){
        Auto car = new Auto(60, 16.5, "27.11.2020");
        Assertions.assertTrue(car.approvedForUse());
    }
    @Test
    void test500km(){
        Auto car = new Auto(50, 10d, "27.11.2020");
        Assertions.assertEquals(car.carDistance(),500);
    }
}
