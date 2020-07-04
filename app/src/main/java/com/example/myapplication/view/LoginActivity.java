package com.example.myapplication.view;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityLoginBinding;
import com.example.myapplication.helper.RecyclerViewAdapter;
import com.example.myapplication.model.LoginModel;
import com.example.myapplication.viewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private LoginViewModel loginViewModel;
    private LoginModel loginModel;
    private int clickCount = 0;
    Spinner spinner = null;
    EditText grid_0 = null;
    EditText grid_1 = null;
    RecyclerView recyclerView = null;
    private List<String> imageNames = new ArrayList<>();
    private List<Image> images = new ArrayList<>();

    ActivityLoginBinding binding;
    ArrayAdapter<String> spinnerAdapter = null;
    RecyclerViewAdapter recyclerViewAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");

        setContentView(R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
//        loginViewModel = new LoginViewModel();
        loginModel = new LoginModel();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.setLoginModel(loginModel);
        binding.setLoginViewModel(loginViewModel);
        init();
    }

    private void init() {
        Log.d(TAG, "init: ");
        grid_0 = findViewById(R.id.grid_0);
        grid_1 = findViewById(R.id.grid_1);
        spinner = findViewById(R.id.spinner);
        recyclerView = findViewById(R.id.recyclerView);

        loginViewModel.setGrid0("Login_VM");
        loginModel.setGrid_1("loginModel");
        //loginViewModel.setGrid_0Visible();

        /*String arr[] = new String[]{"Godzilla","Triceratops"};
        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr);
        spinner.setAdapter(adapter);*/

        loginViewModel.setSpinnerArr(new String[]{"Hoompa", "Loompa"});

        initSpinner();
        initRecyclerView();
    }

    private void initSpinner() {
        Log.d(TAG, "initSpinner: ");
        try {
            String[] arr = new String[]{"Godzilla", "Triceratops"};
            arr = loginViewModel.getSpinnerArr();
            spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr);
            spinnerAdapter.notifyDataSetChanged();
            spinner.setAdapter(spinnerAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    Log.d(TAG, ((AppCompatTextView) selectedItemView).getText().toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    Log.d(TAG, parentView.toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started");

        loginViewModel.setImageNames();
        imageNames = loginViewModel.getImageNames().getValue();
        loginViewModel.getImageNames().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });

        try {
            recyclerViewAdapter = new RecyclerViewAdapter(this, imageNames, images);
            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onLoginClicked(View view) {
        Log.d(TAG, "onLoginClicked: ");
//        Toast.makeText(this,"Login Activity", Toast.LENGTH_SHORT).show();
//        loginViewModel.setGrid0("0_Activity_button");

//        loginModel.setGrid_1("Click - "+clickCount++);
//        loginViewModel.setSpinnerArr(new String[]{"Pokemon","Digimon"});
//        initSpinner();

//        loginViewModel.addNewValue("ImageName_6");

        startActivity(new Intent(this, RegistrationActivity.class));
    }
}
