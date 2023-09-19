package com.example.disasterprepfrontend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterWater extends RecyclerView.Adapter<AdapterWater.MyViewHolder> {

    List<ModelDisaster> modelList;
    AdapterWater.AdapteWaterListener listener;
    ApplicationClass app;


    interface AdapteWaterListener{
        public void clicked(ModelDisaster model,ModelChecklist checklist);
    }


    AdapterWater(Context context, ApplicationClass app, List<ModelDisaster> modelList) {
        this.modelList = modelList;
        this.app = app;


        listener = new AdapteWaterListener() {
            @Override
            public void clicked(ModelDisaster model, ModelChecklist checklist) {

                Intent i = new Intent(context, ActivityWaterView.class);
                i.putExtra("model", model);
                context.startActivity(i);

            }

        };

    }

    public int getDoneChecklistCount(List<String> checklist) {
        int doneCount = 0;
        for (String item : checklist) {
            if (item.charAt(item.length() - 1) == '1') { // Replace 'isDone()' with the appropriate condition for checking if an item is done
                doneCount++;
            }
        }
        return doneCount;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.water_row, parent, false);
        MyViewHolder holder = new MyViewHolder(root);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        int doneCount = getDoneChecklistCount(app.checklistsList.get(position+5).checklist);
        int progress = (int) ((doneCount / (float) 5) * 100);

        holder.prgbar.setProgress(progress);
        holder.description.setText(modelList.get(position).getName());
        holder.imgview.setImageResource(app.map.get(modelList.get(position).getName()));
        holder.name.setText(modelList.get(position).getDesc());

        holder.root.setOnClickListener(v->{
            listener.clicked(modelList.get(position), app.checklistsList.get(position));
        });

    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }




    class MyViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout root;
        ImageView imgview;
        TextView name;
        TextView description;
        ProgressBar prgbar;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            prgbar = itemView.findViewById(R.id.water_progressBar);
            root = itemView.findViewById(R.id.water_row_lyt);
            imgview = itemView.findViewById(R.id.water_row_img);
            name = itemView.findViewById(R.id.water_row_name);
            description = itemView.findViewById(R.id.water_row_desc);
        }
    }

}
