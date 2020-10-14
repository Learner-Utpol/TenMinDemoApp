package com.example.tenmindemoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tenmindemoapp.pojo.Data;
import com.example.tenmindemoapp.R;

import java.util.ArrayList;

public class AdapterForRootList extends RecyclerView.Adapter<AdapterForRootList.ViewHolder> {

    private ArrayList<Data> arrayListForRootRecyclerView;
    private Context context;
    private AdapterFroSubList adapterFroSubList;


    //constructor for this adapter, it receive a array and context from MainActivity
    public AdapterForRootList(ArrayList<Data> arrayListForRootRecyclerView, Context context) {
        this.arrayListForRootRecyclerView = arrayListForRootRecyclerView;
        this.context = context;
    }


    //connect the layout_ui with adapter
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    //set data into list
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Data data = arrayListForRootRecyclerView.get(position);
        holder.itemNameTV.setText(data.getItemName());
        holder.itemIconIV.setImageResource(data.getIcon_address());

        boolean expendCondition = data.isExpendend();
        if (expendCondition == false){
            holder.subRecyclerView.setVisibility(View.GONE);
        } else{
            holder.subRecyclerView.setVisibility(View.VISIBLE);
        }

        if (data.isHasSublist()) {
            //if the element has a sublist then this section will initialize the sublist
            holder.expendIV.setImageResource(R.drawable.ic_baseline_expand_more_24);
            adapterFroSubList = new AdapterFroSubList(getDataForSubList(position));
            holder.subRecyclerView.setAdapter(adapterFroSubList);
            holder.expendIV.setVisibility(View.VISIBLE);

        }
        holder.expendIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hi", Toast.LENGTH_SHORT).show();

                boolean expendCondition = data.isExpendend();
                if (expendCondition == false){
                    data.setExpendend(true);
                } else if (expendCondition == true){
                    data.setExpendend(false);
                }

                notifyItemChanged(position);

            }
        });


    }


    //count the size of received arrayList
    @Override
    public int getItemCount() {
        return arrayListForRootRecyclerView.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTV;
        ImageView expendIV, itemIconIV;
        RecyclerView subRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTV = itemView.findViewById(R.id.itemNameTV);
            expendIV = itemView.findViewById(R.id.expandListIV);
            itemIconIV = itemView.findViewById(R.id.itemIconIV);
            subRecyclerView = itemView.findViewById(R.id.subRecyclerView);
            subRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
    }


    //prepare data for subRecyclerView
    private ArrayList<Data> getDataForSubList(int position) {
        ArrayList<Data> dataForSubList = new ArrayList<>();

        Data videoData = new Data("Video " + (position + 1) + "_" + (position + 1), R.drawable.ic_video, false);
        dataForSubList.add(videoData);

        Data audioData = new Data("Audio " + (position + 1) + "_" + (position + 1), R.drawable.ic_audio, false);
        dataForSubList.add(audioData);

        Data documentData = new Data("Document " + (position + 1) + "_" + (position + 1), R.drawable.ic_document, false);
        dataForSubList.add(documentData);

        return dataForSubList;
    }
}
