package com.example.gyere.footballdata.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gyere.footballdata.R;
import com.example.gyere.footballdata.model.Team;
import com.example.gyere.footballdata.model.TeamsResponse;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private Context context;
    private TeamsResponse teamsResponse;
    private ItemClickListener itemClickListener;

    public TeamsAdapter(Context context, TeamsResponse teamsResponse) {
        this.context = context;
        this.teamsResponse = teamsResponse;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_team, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = teamsResponse.getTeams().get(position);
        Glide.with(context).load(team.getCrestUrl()).into(holder.ivImage);
        holder.tvName.setText(team.getName());
    }

    @Override
    public int getItemCount() {
        return teamsResponse.getTeams().size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView ivImage;
        public TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Team getItem(int id) {
        return teamsResponse.getTeams().get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
