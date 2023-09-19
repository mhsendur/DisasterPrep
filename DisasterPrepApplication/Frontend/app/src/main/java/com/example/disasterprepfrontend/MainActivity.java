package com.example.disasterprepfrontend;


import java.util.ArrayList;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    List<ModelDisaster> modelList = new ArrayList<>();
    List<ModelChecklist> checklistList = new ArrayList<>();
    List<ModelContact> contactList = new ArrayList<>();

    List<ModelDisaster> modelListGeo = new ArrayList<>();
    List<ModelDisaster> modelListWater = new ArrayList<>();
    List<ModelDisaster> modelListWeather = new ArrayList<>();

    List<String> geologicalDisasters = Arrays.asList("Earthquake", "Volcanic Eruption", "Landslide", "Avalanche", "Sinkhole");
    List<String> waterDisasters = Arrays.asList("Flood", "Tsunami", "Hurricane", "Limnic Eruption");
    List<String> weatherDisasters = Arrays.asList("Tornado", "Blizzard", "Heatwave", "Drought", "Wildfire");

    ApplicationClass app;

    Handler myhandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            modelList = (List<ModelDisaster>) msg.obj;

            for(ModelDisaster mdl : modelList) {

                if(geologicalDisasters.contains(mdl.getName())) {
                    modelListGeo.add(mdl);
                }
                else if(waterDisasters.contains(mdl.getName()))
                    modelListWater.add(mdl);
                else
                    modelListWeather.add(mdl);
            }
            return true;
        }
    });
    Handler myhandler1 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            checklistList = (List<ModelChecklist>) msg.obj;
            app.checklistsList = (ArrayList<ModelChecklist>) checklistList;

            return true;
        }
    });

    Handler myhandler2 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            contactList = (List<ModelContact>) msg.obj;
            app.contactList = (ArrayList<ModelContact>) contactList;

            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button geoButton = findViewById(R.id.btn_geo);
        Button waterButton = findViewById(R.id.btn_water);
        Button weatherButton = findViewById(R.id.btn_weather);

        app = (ApplicationClass) this.getApplication();

        Repository myrepo = new Repository();
        myrepo.getDisasterList(app.srv, myhandler);
        myrepo.getCheckList(app.srv, myhandler1);
        myrepo.getContacts(app.srv,myhandler2);

        geoButton.setOnClickListener(v -> {
            FragmentGeological geoFrament = new FragmentGeological(modelListGeo);
            FragmentTransaction trans  = getSupportFragmentManager().beginTransaction();
            trans.replace(R.id.framelayout, geoFrament);
            trans.commit();
        });


       waterButton.setOnClickListener(v -> {
            FragmentWater waterFrag = new FragmentWater(modelListWater);
            FragmentTransaction trans  = getSupportFragmentManager().beginTransaction();
            trans.replace(R.id.framelayout, waterFrag);
            trans.commit();
        });


       weatherButton.setOnClickListener(v -> {
           FragmentWeather weatherFrag = new FragmentWeather(modelListWeather);
           FragmentTransaction trans  = getSupportFragmentManager().beginTransaction();
           trans.replace(R.id.framelayout, weatherFrag);
           trans.commit();
       });




    }
}