package com.turing.api.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Box <T> {
    private Map<String, T> box;

    public Box() {
        this.box = new HashMap<>();
    }
    public void put(List<String> keys,Inventory<T> values) {
        box = new HashMap<>();
        for(int i =0; i< keys.size(); i++){
            box.put(keys.get(i), values.get(i));
        }




    }




}

