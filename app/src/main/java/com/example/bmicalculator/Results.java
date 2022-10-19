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

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Results.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        rText = findViewById(R.id.results);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String rBMI = extras.getString("BMI");
        String rStatus  = extras.getString("Status");
        String rName = extras.getString("Name");
        String dy_results = getString(R.string.results_dy, rName, rBMI, rStatus);

        rText.setText(dy_results);

        button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                Intent intent = new Intent(Results.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void calculate(View view) {
    }
}