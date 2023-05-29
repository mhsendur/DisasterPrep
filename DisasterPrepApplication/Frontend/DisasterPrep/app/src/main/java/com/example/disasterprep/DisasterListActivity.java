package com.example.disasterprep;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisasterListActivity extends AppCompatActivity {

    private String[] geologicalDisasters = {"Earthquake", "Volcanic Eruptions", "Landslide", "Avalanche", "Sinkholes"}; //Geological
    private String[] waterDisasters = {"Flood", "Tsunami", "Hurricane", "Limnic Eruption"}; //Water based
    private String[] weatherDisasters = {"Tornado", "Blizzard", "Heatwave", "Drought", "Wildfire"}; //Weather related

    private ListView disasterListView;
    private ArrayAdapter<String> adapter;

    private int[] geologicalImages = {R.drawable.geological_earthquake, R.drawable.geological_volcano, R.drawable.geological_landslide, R.drawable.geological_avalanche, R.drawable.geological_sinkhole};
    private int[] waterImages = {R.drawable.water_flood, R.drawable.water_tsunami, R.drawable.water_hurricane, R.drawable.water_limniceruption};
    private int[] weatherImages = {R.drawable.weather_tornado, R.drawable.weather_blizzard, R.drawable.weather_heatwave, R.drawable.weather_drought, R.drawable.weather_wildfire};

    private String[] geologicalDescriptions = {
            "\t Sudden shaking or trembling of the ground caused by the release of energy in the Earth's crust, usually resulting from tectonic plate movements.", //Earthquake
            "\t Explosive release of molten rock (magma), gases, and other materials from a volcano, often accompanied by ash clouds, lava flows, and volcanic gases.", //Volcano
            "\t The sudden movement of rock, debris, or earth down a slope, often triggered by heavy rainfall, seismic activity, or human actions.", //Landslide
            "\t An avalanche is a powerful and destructive mass of snow, ice, and debris that rapidly cascades down a mountainside, posing a severe threat to human life and infrastructure.",
            "\t A sinkhole is a natural disaster characterized by the sudden collapse or sinking of the Earth's surface, often resulting from the dissolution of underground limestone or erosion of underground water sources."
    };
    private String[] waterDescriptions = {
            "\t A flood is characterized by the overflow of water onto normally dry land, resulting in widespread inundation and potential damage to structures, infrastructure, and ecosystems.", //Flood
            "\t A tsunami is a devastating natural disaster consisting of a series of massive ocean waves, typically triggered by undersea earthquakes, capable of causing widespread destruction along coastlines.", //Tsunami
            "\t A hurricane is a severe tropical cyclone characterized by strong winds, heavy rainfall, and storm surges in coastal areas.'",
            "\t A rare natural event where a large amount of dissolved carbon dioxide suddenly erupts from a lake, posing a deadly threat to both humans and wildlife due to the release of toxic gases.", //Hurricane
            "\t A catastrophic event where a large amount of dissolved carbon dioxide is suddenly released from deep lake waters, creating a deadly cloud that can suffocate humans and animals in the surrounding area."
    };
    private String[] weatherDescriptions = {
            "\t A tornado is a violent and rapidly rotating column of air that extends from a thunderstorm to the ground, causing widespread destruction along its path.",
            "\t A blizzard is a fierce winter storm characterized by strong winds, heavy snowfall, and reduced visibility, causing hazardous conditions and potential disruption of transportation, infrastructure, and daily activities.",
            "\t A heatwave is an extended period of abnormally high temperatures, often accompanied by intense sunlight and heat-related health hazards, posing a significant risk to human life and the environment.",
            "\t Drought is a natural disaster characterized by an extended period of significantly below-average precipitation, resulting in severe water scarcity and agricultural losses.",
            "\t A wildfire is an uncontrolled and rapidly spreading fire that consumes vegetation and can cause extensive damage to forests, wildlife, and human communities."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_list);

        disasterListView = findViewById(R.id.disasterListView);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        Button geologicalButton = findViewById(R.id.geologicalButton);
        Button waterButton = findViewById(R.id.waterButton);
        Button weatherButton = findViewById(R.id.weatherButton);

        geologicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDisasterList("Geological");
            }
        });

        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDisasterList("Water");
            }
        });

        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDisasterList("Weather");
            }
        });

        // Set initial category
        if (category != null) {
            loadDisasterList(category);
        }
    }

    private void loadDisasterList(String category) {
        int[] images;
        String[] descriptions;
        if (category.equals("Geological")) {
            adapter = new ArrayAdapter<String>(this, R.layout.list_item_disaster, R.id.disasterNameTextView, geologicalDisasters) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = convertView;
                    if (view == null) {
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        view = inflater.inflate(R.layout.list_item_disaster, null);
                    }

                    ImageView imageView = view.findViewById(R.id.disasterImageView);
                    TextView nameTextView = view.findViewById(R.id.disasterNameTextView);
                    TextView descriptionTextView = view.findViewById(R.id.disasterDescriptionTextView);

                    imageView.setImageResource(geologicalImages[position]);
                    nameTextView.setText(geologicalDisasters[position]);
                    descriptionTextView.setText(geologicalDescriptions[position]);

                    return view;
                }
            };
            images = geologicalImages;
            descriptions = geologicalDescriptions;
        } else if (category.equals("Water")) {
            adapter = new ArrayAdapter<String>(this, R.layout.list_item_disaster, R.id.disasterNameTextView, waterDisasters) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = convertView;
                    if (view == null) {
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        view = inflater.inflate(R.layout.list_item_disaster, null);
                    }

                    ImageView imageView = view.findViewById(R.id.disasterImageView);
                    TextView nameTextView = view.findViewById(R.id.disasterNameTextView);
                    TextView descriptionTextView = view.findViewById(R.id.disasterDescriptionTextView);

                    imageView.setImageResource(waterImages[position]);
                    nameTextView.setText(waterDisasters[position]);
                    descriptionTextView.setText(waterDescriptions[position]);

                    return view;
                }
            };
            images = waterImages;
            descriptions = waterDescriptions;
        } else if (category.equals("Weather")) {
            adapter = new ArrayAdapter<String>(this, R.layout.list_item_disaster, R.id.disasterNameTextView, weatherDisasters) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = convertView;
                    if (view == null) {
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        view = inflater.inflate(R.layout.list_item_disaster, null);
                    }

                    ImageView imageView = view.findViewById(R.id.disasterImageView);
                    TextView nameTextView = view.findViewById(R.id.disasterNameTextView);
                    TextView descriptionTextView = view.findViewById(R.id.disasterDescriptionTextView);

                    imageView.setImageResource(weatherImages[position]);
                    nameTextView.setText(weatherDisasters[position]);
                    descriptionTextView.setText(weatherDescriptions[position]);

                    return view;
                }
            };
            images = weatherImages;
            descriptions = weatherDescriptions;
        } else {
            adapter = new ArrayAdapter<>(this, R.layout.list_item_disaster, R.id.disasterNameTextView, new String[]{});
            images = new int[]{};
            descriptions = new String[]{};
        }

        disasterListView.setAdapter(adapter);

        disasterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedDisaster = (String) parent.getItemAtPosition(position);
                Intent detailsIntent = new Intent(DisasterListActivity.this, DisasterDetailsActivity.class);
                detailsIntent.putExtra("category", category);
                detailsIntent.putExtra("disaster", selectedDisaster);
                detailsIntent.putExtra("description", descriptions[position]);
                detailsIntent.putExtra("image", images[position]);
                startActivity(detailsIntent);
            }
        });
    }
}
