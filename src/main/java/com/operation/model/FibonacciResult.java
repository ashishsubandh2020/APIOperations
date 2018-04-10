package com.operation.model;

import java.util.Arrays;

/**
 * Created by hudapeng on 4/3/16.
 */
public class FibonacciResult {
    String number;
    String[] array;


    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FibonacciResult{" +
                "number='" + number + '\'' +
                ", array=" + Arrays.toString(array) +
                "}\n";
    }
}