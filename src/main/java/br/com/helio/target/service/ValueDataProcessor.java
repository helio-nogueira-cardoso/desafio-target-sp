package br.com.helio.target.service;

import br.com.helio.target.model.ValueData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ValueDataProcessor {
    private ArrayList<ValueData> nonZeroValues;
    private double average;

    public ValueDataProcessor(List<ValueData> valueDataList) {
        this.nonZeroValues = (ArrayList<ValueData>) valueDataList.stream()
                .filter(v -> v.value() > 0.0)
                .collect(Collectors.toList());

        int numberOfNonZeroValue = nonZeroValues.size();

        this.average =  nonZeroValues.stream()
                .map(v -> v.value() / numberOfNonZeroValue)
                .reduce(0.0, Double::sum);
    }

    public double average() {
        return this.average;
    }

    public int numberOfdaysAboveAverage() {
        return (int) this.nonZeroValues.stream()
                .filter(v -> v.value() > this.average)
                .count();
    }

    public ValueData minValueData() {
        return this.nonZeroValues.stream()
                .min(Comparator.comparingDouble(ValueData::value))
                .orElse(null);
    }

    public ValueData maxValueData() {
        return this.nonZeroValues.stream()
                .max(Comparator.comparingDouble(ValueData::value))
                .orElse(null);
    }
}
