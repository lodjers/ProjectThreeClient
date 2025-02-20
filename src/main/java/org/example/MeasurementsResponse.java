package org.example;

public class MeasurementsResponse {

    private int value;

    private boolean raining;

    private SensorResponse sensor;

    public MeasurementsResponse() {}

    public MeasurementsResponse(int value, boolean raining, SensorResponse sensor) {
        this.value = value;
        this.raining = raining;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorResponse getSensor() {
        return sensor;
    }

    public void setSensor(SensorResponse sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "MeasurementsResponse{" +
                "value=" + value +
                ", raining=" + raining +
                ", sensor=" + sensor +
                '}';
    }
}
