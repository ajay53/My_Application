package com.example.myapplication.viewModel;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private static final String TAG = "LoginViewModel";

    private String grid0 = null;
    private boolean isGrid_1Visible = false;
    private String[] spinnerArr = null;
    private MutableLiveData<List<String>> mImageNames;
    private MutableLiveData<Boolean> mIsListUpdating = new MutableLiveData<>();

//    @Bindable
    public String getGrid0() {
        return grid0;
    }

    public void setGrid0(String text) {
        grid0 = text;
//        notifyPropertyChanged(BR.grid0);
    }

//    @Bindable
    public boolean isGrid_1Visible() {
        return isGrid_1Visible;
    }

    public void setGrid_1Visible(boolean grid_1Visible) {
        isGrid_1Visible = grid_1Visible;
//        notifyPropertyChanged(BR.grid_1Visible);
    }

//    @Bindable
    public String[] getSpinnerArr() {
        return spinnerArr;
    }

    public void setSpinnerArr(String[] spinnerArr) {
        this.spinnerArr = new String[]{};
        this.spinnerArr = spinnerArr;
//        notifyPropertyChanged(BR.spinnerArr);
    }

    public void setImageNames() {
        Log.d(TAG, "getRecyclerViewData: reached");

        List<String> imageNames = new ArrayList<>();
        imageNames.add("ImageName_1");
        imageNames.add("ImageName_2");
        imageNames.add("ImageName_3");
        imageNames.add("ImageName_4");
        imageNames.add("ImageName_5");

        try {
            mImageNames = new MutableLiveData<>();
            mImageNames.setValue(imageNames);
            Log.d(TAG, "name: "+mImageNames.getValue().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return imageNames;
    }

    public LiveData<List<String>> getImageNames() {
        Log.d(TAG, "getImageNames: reached");

        return mImageNames;
    }

    public void addNewValue(final String imageName) {
        mIsListUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<String> currentImageNames = mImageNames.getValue();
                currentImageNames.add(imageName);
                mImageNames.postValue(currentImageNames);
                mIsListUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                /*try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                return null;
            }
        }.execute();
    }

    public LiveData<Boolean> getmIsListUpdating() {
        return mIsListUpdating;
    }
}
