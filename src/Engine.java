public interface Engine {
    void start();
    void stop();
    void increase();
    void decrease();
    void syncWithCarSpeed(int carSpeed);
    int getEngineSpeed();
    String getName();
}