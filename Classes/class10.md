Java: Abstract Classes and Interfaces
🧩 ABSTRACT CLASSES
🔹 Example 1: Basic Abstract and Concrete Methods
abstract class Vehicle {
    abstract void startEngine();

    void showStatus() {
        System.out.println("Vehicle is in standby mode.");
    }
}

class Car extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Car engine started.");
    }
}

class Demo1 {
    public static void main(String[] args) {
        Car car = new Car();
        car.startEngine();
        car.showStatus();
    }
}
Output:

Car engine started.
Vehicle is in standby mode.
🔹 Example 2: Abstract and Normal Methods
abstract class Machine {
    abstract void powerOn();
    abstract void powerOff();

    public void displayInfo() {
        System.out.println("Machine information displayed.");
    }

    public void diagnostics() {
        System.out.println("Running diagnostics...");
    }
}

class Printer extends Machine {
    @Override
    void powerOn() {
        System.out.println("Printer powered on.");
    }

    @Override
    void powerOff() {
        System.out.println("Printer powered off.");
    }
}

class Demo2 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.powerOn();
        printer.powerOff();
        printer.displayInfo();
        printer.diagnostics();
    }
}
Output:

nginx
Copy
Edit
Printer powered on.
Printer powered off.
Machine information displayed.
Running diagnostics...
🔹 Example 3: Two Abstract Classes

abstract class Device {
    abstract void operate();

    void status() {
        System.out.println("Device is operational.");
    }
}

class Phone extends Device {
    @Override
    void operate() {
        System.out.println("Phone is now working.");
    }
}

abstract class Gadget {
    void config1() {
        System.out.println("Gadget config1.");
    }

    void config2() {
        System.out.println("Gadget config2.");
    }
}

class SmartWatch extends Gadget {
    @Override
    void config1() {
        System.out.println("SmartWatch config1 overridden.");
    }

    @Override
    void config2() {
        System.out.println("SmartWatch config2 overridden.");
    }
}

class Demo3 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.operate();
        phone.status();

        SmartWatch watch = new SmartWatch();
        watch.config1();
        watch.config2();
    }
}
Output:

Phone is now working.
Device is operational.
SmartWatch config1 overridden.
SmartWatch config2 overridden.
🔹 Example 4: Static/Instance Members and Abstract Method
abstract class Appliance {
    static int voltage = 220;
    int power = 1500;

    abstract void activate();

    void standby() {
        System.out.println("Appliance is in standby mode.");
    }

    static void specifications() {
        System.out.println("Appliance specs listed.");
    }
}

class Heater extends Appliance {
    @Override
    void activate() {
        System.out.println("Heater activated.");
    }
}

class Demo4 {
    public static void main(String[] args) {
        Heater heater = new Heater();
        heater.activate();
        heater.standby();
        Appliance.specifications();

        System.out.println("Power rating: " + heater.power);
        System.out.println("Voltage: " + Appliance.voltage);
    }
}
Output:

Heater activated.
Appliance is in standby mode.
Appliance specs listed.
Power rating: 1500
Voltage: 220
🔗 INTERFACES
🔹 Interface Implementation
interface Engine {
    void ignite();
    void shutdown();
    void monitor();
    int version = 2;
}

class Generator implements Engine {
    @Override
    public void ignite() {
        System.out.println("Generator ignition started.");
    }

    @Override
    public void shutdown() {
        System.out.println("Generator is shutting down.");
    }

    @Override
    public void monitor() {
        System.out.println("Monitoring generator performance.");
    }
}

class Demo5 {
    public static void main(String[] args) {
        Generator gen = new Generator();
        gen.ignite();
        gen.shutdown();
        gen.monitor();
        System.out.println("Engine version: " + Engine.version);
    }
}
Output:

Generator ignition started.
Generator is shutting down.
Monitoring generator performance.
Engine version: 2
