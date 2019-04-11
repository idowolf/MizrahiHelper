package com.richkidz.mizrahihelper;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<BankObject> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView resultImage;
        public ImageButton linkButton;
        public TextView descriptionView;
        public MyViewHolder(View v) {
            super(v);
            resultImage = v.findViewById(R.id.imageView);
            linkButton = v.findViewById(R.id.link_btn);
            descriptionView = v.findViewById(R.id.resultText);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<BankObject> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view

        // Inflate the custom layout
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item, parent, false);
        // Return a new holder instance
        return new MyAdapter.MyViewHolder(contactView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.descriptionView.setText(mDataset.get(position).getDescription());
        holder.linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(holder.descriptionView.getContext(), Uri.parse(mDataset.get(position).getUrl()));
            }
        });
        Glide.with(holder.resultImage.getContext()).load(mDataset.get(position).getImage()).into(holder.resultImage);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}