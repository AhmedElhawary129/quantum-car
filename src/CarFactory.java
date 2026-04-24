public class CarFactory {

    public Car createCar(EngineType engineType) {
        return new Car(createEngine(engineType));
    }

    public void replaceEngine(Car car, EngineType engineType) {
        car.replaceEngine(createEngine(engineType));
    }

    private Engine createEngine(EngineType engineType) {
        switch (engineType) {
            case GASOLINE:
                return new GasolineEngine();
            case ELECTRONIC:
                return new ElectronicEngine();
            case HYBRID:
                return new MixedHybridEngine();
            default:
                throw new IllegalArgumentException("Unsupported engine type");
        }
    }
}