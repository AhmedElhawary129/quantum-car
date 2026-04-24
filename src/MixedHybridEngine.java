public class MixedHybridEngine implements Engine {
    private final GasolineEngine gasolineEngine;
    private final ElectronicEngine electronicEngine;
    private Engine activeEngine;
    private boolean running;

    public MixedHybridEngine() {
        this.gasolineEngine = new GasolineEngine();
        this.electronicEngine = new ElectronicEngine();
        this.activeEngine = electronicEngine;
        this.running = false;
    }

    @Override
    public void start() {
        running = true;
        activeEngine = electronicEngine;
        activeEngine.start();
        System.out.println("MixedHybridEngine started with ElectronicEngine.");
    }

    @Override
    public void stop() {
        gasolineEngine.stop();
        electronicEngine.stop();
        running = false;
        System.out.println("MixedHybridEngine stopped.");
    }

    @Override
    public void increase() {
        if (running) {
            activeEngine.increase();
        }
    }

    @Override
    public void decrease() {
        if (running) {
            activeEngine.decrease();
        }
    }

    @Override
    public void syncWithCarSpeed(int carSpeed) {
        if (!running) {
            return;
        }

        Engine targetEngine = carSpeed < 50 ? electronicEngine : gasolineEngine;

        if (activeEngine != targetEngine) {
            activeEngine.stop();
            targetEngine.start();
            activeEngine = targetEngine;
            System.out.println("MixedHybridEngine switched to " + activeEngine.getName());
        }

        activeEngine.syncWithCarSpeed(carSpeed);
    }

    @Override
    public int getEngineSpeed() {
        return activeEngine.getEngineSpeed();
    }

    @Override
    public String getName() {
        return "MixedHybridEngine";
    }
}