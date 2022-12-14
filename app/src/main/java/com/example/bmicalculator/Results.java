package com.example.bmicalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Results extends AppCompatActivity {
    Button button;
    TextView rText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowCustomEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setCustomView(R.layout.toolbar_title);
        View view = Objects.requireNonNull(getSupportActionBar()).getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_home);

        imageButton.setOnClickListener(this::onClickImg);
//Displaying the results from bundle in the created in the other activity
        rText = findViewById(R.id.results);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String rBMI = extras.getString("BMI");
        String rStatus  = extras.getString("Status");
        String rName = extras.getString("Name");
        String rTime = extras.getString("Time");
        String dy_results = getString(R.string.results_dy, rTime, rName, rBMI, rStatus);

        rText.setText(dy_results);
//Takes you back to the home Page(MainActivity)
        button = findViewById(R.id.back);
        button.setOnClickListener(this::onClickBtn);
    }

    public void calculate(View view) {
    }

    private void onClickImg(View v) {
//Allows user to exit the current Activity to main Activity
        Intent intent = new Intent(Results.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void onClickBtn(View v){
        finishAffinity();
        Intent intent = new Intent(Results.this, MainActivity.class);
        startActivity(intent);

    }
}