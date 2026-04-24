public class Main {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        System.out.println("========== GASOLINE CAR ==========");
        Car gasolineCar = factory.createCar(EngineType.GASOLINE);
        gasolineCar.start();
        gasolineCar.accelerate();
        gasolineCar.accelerate();
        gasolineCar.brake();
        gasolineCar.stop();

        System.out.println("\n========== ELECTRONIC CAR ==========");
        Car electronicCar = factory.createCar(EngineType.ELECTRONIC);
        electronicCar.start();
        electronicCar.accelerate();
        electronicCar.accelerate();
        electronicCar.brake();
        electronicCar.stop();

        System.out.println("\n========== HYBRID CAR ==========");
        Car hybridCar = factory.createCar(EngineType.HYBRID);
        hybridCar.start();
        hybridCar.accelerate();
        hybridCar.accelerate();
        hybridCar.accelerate();
        hybridCar.brake();
        hybridCar.stop();

        System.out.println("\n========== REPLACE ENGINE ==========");
        Car testCar = factory.createCar(EngineType.GASOLINE);
        testCar.start();
        testCar.accelerate();
        factory.replaceEngine(testCar, EngineType.HYBRID);
        testCar.start();
        testCar.accelerate();
        testCar.accelerate();
        testCar.stop();
    }
}