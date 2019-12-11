package com.icosol.scs.andoriddebugdatabaseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.icosol.scs.andoriddebugdatabaseapp.user.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<User> list;

    public ListAdapter(List<User> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.tvId.setText(list.get(position).getId() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_id)
        TextView tvId;
        @BindView(R.id.tv_name)
        TextView tvName;

        public ListViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
