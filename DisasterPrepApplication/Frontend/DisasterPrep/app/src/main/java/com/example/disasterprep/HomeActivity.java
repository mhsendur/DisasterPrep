package com.example.disasterprep;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button geologicalButton = findViewById(R.id.geologicalButton);
        Button waterButton = findViewById(R.id.waterButton);
        Button weatherButton = findViewById(R.id.weatherButton);

        geologicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DisasterListActivity.class)
                        .putExtra("category", "Geological"));
            }
        });

        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DisasterListActivity.class)
                        .putExtra("category", "Water"));
            }
        });

        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DisasterListActivity.class)
                        .putExtra("category", "Weather"));
            }
        });
    }
}
