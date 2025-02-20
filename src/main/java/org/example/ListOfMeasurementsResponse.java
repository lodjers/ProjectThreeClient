package org.example;

import java.util.List;

public class ListOfMeasurementsResponse {
    private List<MeasurementsResponse> measurementsResponses;

    public ListOfMeasurementsResponse() {}

    public ListOfMeasurementsResponse(List<MeasurementsResponse> measurementsResponses) {
        this.measurementsResponses = measurementsResponses;
    }

    public List<MeasurementsResponse> getMeasurementsResponses() {
        return measurementsResponses;
    }

    public void setMeasurementsResponses(List<MeasurementsResponse> measurementsResponses) {
        this.measurementsResponses = measurementsResponses;
    }

    @Override
    public String toString() {
        return "ListOfMeasurementsResponse{" +
                "measurementsResponses=" + measurementsResponses +
                '}';
    }
}
