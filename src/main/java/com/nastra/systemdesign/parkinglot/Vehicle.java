package com.nastra.systemdesign.parkinglot;

/**
 *
 * @author nastra
 */
public class Vehicle {

    protected SpotSize spotSize;
    protected String licensePlate;

    public int spotsNeeded() {
        return spotSize.size();
    }

    public class MotorCycle extends Vehicle {

        public MotorCycle(String licensePlate) {
            this.licensePlate = licensePlate;
            spotSize = SpotSize.SMALL;
        }
    }

    public class Car extends Vehicle {

        public Car(String licensePlate) {
            this.licensePlate = licensePlate;
            spotSize = SpotSize.MEDIUM;
        }
    }

    public class Bus extends Vehicle {

        public Bus(String licensePlate) {
            this.licensePlate = licensePlate;
            spotSize = SpotSize.LARGE;
        }
    }
}
