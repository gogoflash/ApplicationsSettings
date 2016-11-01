package com.example.student.applicationssettings;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by student on 2016.
 */
public class ApplicationData {

    public String name;

    public String iconPath;

    public String getPermittions() {
        return permittions;
    }

    public void setPermittions(String permittions) {
        this.permittions = permittions;
    }

    public String permittions;

    public Drawable icon;

    public ApplicationData(String name, String iconPath) {
        this.name = name;
        this.iconPath = iconPath;
    }

    public ApplicationData() {
    }
}
