package com.operation.model;



import java.util.Arrays;

/**
 * Created by Ashish Subandh on 4/8/18.
 */
public class CombinedArray {
    
    Integer[] array;


    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }


    @Override
    public String toString() {
        return "{"+"Array="+Arrays.toString(array)+"}";
    }
    public String getResponse() {
        return "{"+"\"Array\":"+Arrays.toString(array)+"}";
    }
}