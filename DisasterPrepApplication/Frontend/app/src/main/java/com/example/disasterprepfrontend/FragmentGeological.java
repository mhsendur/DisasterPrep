package com.example.disasterprepfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class FragmentGeological extends Fragment {

    List<ModelDisaster> modelList;

    public FragmentGeological(List<ModelDisaster> modelList) {
        this.modelList = modelList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_geological, container, false);

        RecyclerView myRecView = v.findViewById(R.id.geo_rec_view);

        RecyclerView.LayoutManager layMan = new LinearLayoutManager(this.getContext());
        myRecView.setLayoutManager(layMan);

        ApplicationClass application = (ApplicationClass) requireActivity().getApplication();
        RecyclerView.Adapter myRecAdapter = new AdapterGeological(requireContext(),application, modelList);
        myRecView.setAdapter(myRecAdapter);


        return v;
    }


}