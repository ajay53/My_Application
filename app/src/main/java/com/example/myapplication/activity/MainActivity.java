package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    Spinner spinner = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        spinner = findViewById(R.id.spinner);
        String arr[] = new String[]{"Godzilla","Triceratops"};
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Log.d("test", ((AppCompatTextView)selectedItemView).getText().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Log.d("test", parentView.toString());
            }
        });
    }

    public void onLoginClicked(View view) {
        Toast.makeText(this,"Main Activity_Login Button", Toast.LENGTH_SHORT).show();
    }

}
