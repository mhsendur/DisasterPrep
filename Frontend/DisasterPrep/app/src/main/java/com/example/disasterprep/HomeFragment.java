package com.example.disasterprep;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        Button geologicalButton = rootView.findViewById(R.id.geologicalButton);
        Button waterButton = rootView.findViewById(R.id.waterButton);
        Button weatherButton = rootView.findViewById(R.id.weatherButton);

        geologicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDisasterListActivity("Geological");
            }
        });

        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDisasterListActivity("Water");
            }
        });

        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDisasterListActivity("Weather");
            }
        });

        return rootView;
    }

    private void openDisasterListActivity(String category) {
        Intent intent = new Intent(requireContext(), DisasterListActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
