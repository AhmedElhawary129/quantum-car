public class GasolineEngine implements Engine {
    private int engineSpeed;
    private boolean running;

    public GasolineEngine() {
        this.engineSpeed = 0;
        this.running = false;
    }

    @Override
    public void start() {
        running = true;
        engineSpeed = 0;
        System.out.println("GasolineEngine started.");
    }

    @Override
    public void stop() {
        engineSpeed = 0;
        running = false;
        System.out.println("GasolineEngine stopped.");
    }

    @Override
    public void increase() {
        if (running) {
            engineSpeed++;
        }
    }

    @Override
    public void decrease() {
        if (running && engineSpeed > 0) {
            engineSpeed--;
        }
    }

    @Override
    public void syncWithCarSpeed(int carSpeed) {
        if (!running) {
            return;
        }

        while (engineSpeed < carSpeed) {
            increase();
        }

        while (engineSpeed > carSpeed) {
            decrease();
        }

        System.out.println("GasolineEngine synced to car speed: " + carSpeed + " km/h");
    }

    @Override
    public int getEngineSpeed() {
        return engineSpeed;
    }

    @Override
    public String getName() {
        return "GasolineEngine";
    }
}