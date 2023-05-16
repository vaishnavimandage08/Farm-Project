package com.solvd.farm;

import com.solvd.farm.crop.Crop;
import com.solvd.farm.crop.Grain;
import com.solvd.farm.crop.Vegetable;

public enum CropType {
    CORN(Grain.class),
    WHEAT(Grain.class),
    SOYBEAN(Grain.class),
    TOMATO(Vegetable.class),
    CARROT(Vegetable.class),
    LETTUCE(Vegetable.class);

    private Class<? extends Crop> category;

    CropType(Class<? extends Crop> category) {
        this.category = category;
    }

    public Class<? extends Crop> getCategory() {
        return category;
    }
}


