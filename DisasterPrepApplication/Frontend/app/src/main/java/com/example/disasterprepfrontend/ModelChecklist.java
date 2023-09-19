package com.example.disasterprepfrontend;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;

public class ModelChecklist implements Serializable {

    private String disasterType;
    public ArrayList<String> checklist = new ArrayList<String>();

    public ModelChecklist(String disasterType, JSONArray list) {

        this.disasterType = disasterType;

        for (int i = 0; i < list.length(); i++) {
            try {
                String element = list.getString(i);
                checklist.add(element);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public ArrayList<String> getChecklist() {
        return checklist;
    }

    public void setChecklist(ArrayList<String> checklist) {
        this.checklist = checklist;
    }
}
