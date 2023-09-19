package com.example.disasterprepfrontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityGeoView extends AppCompatActivity {

    public ActivityGeoView() {

    }

    CheckBox box1;
    CheckBox box2;
    CheckBox box3;
    CheckBox box4;
    CheckBox box5;
    TextView desc;
    ModelChecklist targetObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_view);

        ModelDisaster receivedModel = (ModelDisaster) getIntent().getSerializableExtra("model");
        Handler refreshHandler = getIntent().getParcelableExtra("handler");



        ImageView imgview = findViewById(R.id.imgview_act2);
        TextView name = findViewById(R.id.name_act2);
        desc = findViewById(R.id.desc_act2);

        box1 = findViewById(R.id.checkBox1);
        box2 = findViewById(R.id.checkBox2);
        box3 = findViewById(R.id.checkBox3);
        box4 = findViewById(R.id.checkBox4);
        box5 = findViewById(R.id.checkBox5);


        imgview.setImageResource(receivedModel.getImage());
        name.setText(receivedModel.getName());
        desc.setText(receivedModel.getPlan());


        ApplicationClass app = (ApplicationClass) this.getApplication();

        imgview.setImageResource(app.map.get(name.getText()));



        for (ModelChecklist model: app.checklistsList) {
            if (model.getDisasterType().equals(name.getText())) {
                targetObject = model;
                break;  // Exit the loop once the object is found
            }
        }

        box1.setText(targetObject.checklist.get(0));
        box2.setText(targetObject.checklist.get(1));
        box3.setText(targetObject.checklist.get(2));
        box4.setText(targetObject.checklist.get(3));
        box5.setText(targetObject.checklist.get(4));


        TextView contact1 = findViewById(R.id.cont1);
        contact1.setText(app.contactList.get(2).getContactName() + " : " + app.contactList.get(2).getContactPhoneNumber());

        TextView contact2= findViewById(R.id.cont2);
        contact2.setText(app.contactList.get(3).getContactName() + " : " + app.contactList.get(3).getContactPhoneNumber());


        if(targetObject.checklist.get(0).charAt(targetObject.checklist.get(0).length()-1) == '1')
            box1.setChecked(true);
        if(targetObject.checklist.get(1).charAt(targetObject.checklist.get(1).length()-1) == '1')
            box2.setChecked(true);
        if(targetObject.checklist.get(2).charAt(targetObject.checklist.get(2).length()-1) == '1')
            box3.setChecked(true);
        if(targetObject.checklist.get(3).charAt(targetObject.checklist.get(3).length()-1) == '1')
            box4.setChecked(true);
        if(targetObject.checklist.get(4).charAt(targetObject.checklist.get(4).length()-1) == '1')
            box5.setChecked(true);


        box1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true) {
                    targetObject.checklist.set(0, targetObject.checklist.get(0) + "1");
                    Log.e("DEV", targetObject.checklist.get(0));
                }
            }
        });

        box2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true) {
                    targetObject.checklist.set(1, targetObject.checklist.get(1) + "1");
                    Log.e("DEV", targetObject.checklist.get(1));
                }
            }
        });

        box3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true) {
                    targetObject.checklist.set(2, targetObject.checklist.get(2) + "1");
                    Log.e("DEV", targetObject.checklist.get(2));
                }
            }
        });

        box4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true) {
                    targetObject.checklist.set(3, targetObject.checklist.get(3) + "1");
                    Log.e("DEV", targetObject.checklist.get(3));
                }
            }
        });

        box5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true) {
                    targetObject.checklist.set(4, targetObject.checklist.get(4) + "1");
                    Log.e("DEV", targetObject.checklist.get(4));
                }
            }
        });


    }
}