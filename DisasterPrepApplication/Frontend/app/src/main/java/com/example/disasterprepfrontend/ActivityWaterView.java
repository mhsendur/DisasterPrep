package com.example.disasterprepfrontend;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityWaterView extends AppCompatActivity {

    public ActivityWaterView() {

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


        ApplicationClass app = (ApplicationClass) this.getApplication();


        setContentView(R.layout.activity_water_view);

        ModelDisaster receivedModel = (ModelDisaster) getIntent().getSerializableExtra("model");


        ImageView imgview = findViewById(R.id.imgview_act3);
        TextView name = findViewById(R.id.name_act3);
        desc = findViewById(R.id.desc_act3);

        box1 = findViewById(R.id.water_checkBox1);
        box2 = findViewById(R.id.water_checkBox2);
        box3 = findViewById(R.id.water_checkBox3);
        box4 = findViewById(R.id.water_checkBox4);
        box5 = findViewById(R.id.water_checkBox5);

        imgview.setImageResource(receivedModel.getImage());
        name.setText(receivedModel.getName());
        desc.setText(receivedModel.getPlan());

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
        contact1.setText(app.contactList.get(0).getContactName() + " : " + app.contactList.get(0).getContactPhoneNumber());

        TextView contact2= findViewById(R.id.cont2);
        contact2.setText(app.contactList.get(1).getContactName() + " : " + app.contactList.get(1).getContactPhoneNumber());

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
