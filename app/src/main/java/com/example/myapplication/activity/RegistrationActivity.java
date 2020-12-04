package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.myapplication.R;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = "RegistrationActivity";
    Spinner spinner;
    ArrayAdapter<String> spinnerAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_registration);

        init();
        initSpinner();
    }

    private void init() {
        spinner = findViewById(R.id.spinner);
    }

    private void initSpinner() {
        Log.d(TAG, "initSpinner: ");
        try {
            String[] arr = new String[]{"Godzilla_aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Triceratops"};
//            arr = loginViewModel.getSpinnerArr();
            spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr);
            spinnerAdapter.notifyDataSetChanged();
            spinner.setAdapter(spinnerAdapter);

//            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                    Log.d(TAG, ((AppCompatTextView) selectedItemView).getText().toString());
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parentView) {
//                    Log.d(TAG, parentView.toString());
//                }
//            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
