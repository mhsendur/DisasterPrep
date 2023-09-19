package com.example.disasterprepfrontend;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityWeatherView extends AppCompatActivity {

    public ActivityWeatherView() {

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
        setContentView(R.layout.activity_weather_view);

        ModelDisaster receivedModel = (ModelDisaster) getIntent().getSerializableExtra("model");


        ImageView imgview = findViewById(R.id.imgview_act4);
        TextView name = findViewById(R.id.name_act4);
        desc = findViewById(R.id.desc_act4);

        box1 = findViewById(R.id.weather_checkBox1);
        box2 = findViewById(R.id.weather_checkBox2);
        box3 = findViewById(R.id.weather_checkBox3);
        box4 = findViewById(R.id.weather_checkBox4);
        box5 = findViewById(R.id.weather_checkBox5);



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
        contact1.setText(app.contactList.get(4).getContactName() + " : " + app.contactList.get(4).getContactPhoneNumber());

        TextView contact2= findViewById(R.id.cont2);
        contact2.setText(app.contactList.get(5).getContactName() + " : " + app.contactList.get(5).getContactPhoneNumber());

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
