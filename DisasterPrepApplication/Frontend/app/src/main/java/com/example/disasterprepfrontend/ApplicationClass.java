package com.example.disasterprepfrontend;

import android.app.Application;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationClass extends Application {

    ExecutorService srv = Executors.newCachedThreadPool();
    ArrayList<ModelChecklist> checklistsList = new ArrayList<>();
    ArrayList<ModelContact> contactList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<String, Integer>();

    @Override
    public void onCreate() {
        super.onCreate();

        Resources resources = this.getResources();
        String packageName = this.getPackageName();

        map.put("Blizzard", resources.getIdentifier("blizzard", "drawable", packageName));
        map.put("Avalanche", resources.getIdentifier("avalanches", "drawable", packageName));
        map.put("Drought", resources.getIdentifier("drought", "drawable", packageName));
        map.put("Earthquake", resources.getIdentifier("earthquake", "drawable", packageName));
        map.put("Flood", resources.getIdentifier("flood", "drawable", packageName));
        map.put("Heatwave", resources.getIdentifier("heatwave", "drawable", packageName));
        map.put("Hurricane", resources.getIdentifier("hurricane", "drawable", packageName));
        map.put("Landslide", resources.getIdentifier("landslide", "drawable", packageName));
        map.put("Limnic Eruption", resources.getIdentifier("limnic", "drawable", packageName));
        map.put("Sinkhole", resources.getIdentifier("sinkhole", "drawable", packageName));
        map.put("Tornado", resources.getIdentifier("tornado", "drawable", packageName));
        map.put("Tsunami", resources.getIdentifier("tsunami", "drawable", packageName));
        map.put("Volcanic Eruption", resources.getIdentifier("volcanic", "drawable", packageName));
        map.put("Wildfire", resources.getIdentifier("wildfire", "drawable", packageName));
    }

    public ExecutorService getSrv() {
        return srv;
    }

    public ArrayList<ModelChecklist> getChecklistsList() {
        return checklistsList;
    }
}
