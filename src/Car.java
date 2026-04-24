public class Car {
    private Engine engine;
    private int speed;
    private boolean started;

    public Car(Engine engine) {
        this.engine = engine;
        this.speed = 0;
        this.started = false;
    }

    public void start() {
        if (!started) {
            started = true;
            speed = 0;
            engine.start();
            engine.syncWithCarSpeed(speed);
            System.out.println("Car started at 0 km/h using " + engine.getName());
        } else {
            System.out.println("Car is already started.");
        }
    }

    public void stop() {
        if (!started) {
            System.out.println("Car is already stopped.");
            return;
        }

        speed = 0;
        engine.syncWithCarSpeed(speed);
        engine.stop();
        started = false;
        System.out.println("Car stopped.");
    }

    public void accelerate() {
        if (!started) {
            System.out.println("Start the car first.");
            return;
        }

        if (speed < 200) {
            speed += 20;
            engine.syncWithCarSpeed(speed);
            System.out.println("Car accelerated to " + speed + " km/h");
        } else {
            System.out.println("Car is already at maximum speed 200 km/h");
        }
    }

    public void brake() {
        if (!started) {
            System.out.println("Start the car first.");
            return;
        }

        if (speed > 0) {
            speed -= 20;
            engine.syncWithCarSpeed(speed);
            System.out.println("Car slowed down to " + speed + " km/h");
        } else {
            System.out.println("Car is already at minimum speed 0 km/h");
        }
    }

    public void replaceEngine(Engine newEngine) {
        if (started) {
            stop();
        }
        this.engine = newEngine;
        System.out.println("Engine replaced with " + newEngine.getName());
    }

    public int getSpeed() {
        return speed;
    }

    public Engine getEngine() {
        return engine;
    }
}