package com.example.myapplication.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class LoginModel extends BaseObservable {
    public String grid_1;

    @Bindable
    public String getGrid_1() {
        return grid_1;
    }

    public void setGrid_1(String grid_1) {
        this.grid_1 = grid_1;
        notifyPropertyChanged(BR.grid_1);
    }
}
