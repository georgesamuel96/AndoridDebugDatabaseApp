package com.icosol.scs.andoriddebugdatabaseapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.icosol.scs.andoriddebugdatabaseapp.user.User;
import com.icosol.scs.andoriddebugdatabaseapp.user.UserDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.rv_users)
    RecyclerView rvUsers;
    private List<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        rvUsers.setLayoutManager(new LinearLayoutManager(ListActivity.this, RecyclerView.VERTICAL, false));
        rvUsers.setHasFixedSize(true);
        ListAdapter adapter = new ListAdapter(list);
        rvUsers.setAdapter(adapter);

        UserDatabase userDatabase = Room.databaseBuilder(ListActivity.this, UserDatabase.class, "userdb").allowMainThreadQueries().build();
        list.clear();
        list.addAll(userDatabase.getUserDao().getUsers());
        adapter.notifyDataSetChanged();
    }
}
