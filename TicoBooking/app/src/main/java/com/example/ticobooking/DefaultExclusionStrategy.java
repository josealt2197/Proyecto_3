package com.example.ticobooking;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;

/*_____________________________CONVERTIR EL TEXTO EN JSON Y VICEVERSA________________________________*/

/**
 * Created by DavidGam on 29/11/16.
 */
public class DefaultExclusionStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(SerializedName.class) == null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
