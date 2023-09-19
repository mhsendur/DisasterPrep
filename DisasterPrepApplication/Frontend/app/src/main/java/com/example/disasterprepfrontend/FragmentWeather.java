package com.example.disasterprepfrontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentWeather extends Fragment {

    List<ModelDisaster> modelList;

    public FragmentWeather(List<ModelDisaster> modelList) {
        this.modelList = modelList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_weather, container, false);

        RecyclerView myRecView = v.findViewById(R.id.weather_rec_view);

        RecyclerView.LayoutManager layMan = new LinearLayoutManager(this.getContext());
        myRecView.setLayoutManager(layMan);

        ApplicationClass application = (ApplicationClass) requireActivity().getApplication();

        RecyclerView.Adapter myRecAdapter = new AdapterWeather(requireContext(), application, modelList);
        myRecView.setAdapter(myRecAdapter);

        return v;
    }


}