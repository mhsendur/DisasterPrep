package com.example.disasterprepfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityHomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button startButton = findViewById(R.id.startButton);
        ImageView imgview = findViewById(R.id.imageView);

        imgview.setImageResource(R.drawable.disasterprep);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the main app activity
                Intent intent = new Intent(ActivityHomeScreen.this, MainActivity.class);
                startActivity(intent);
                finish(); // Optional: Finish the home activity to prevent going back to it
            }
        });
    }
}
