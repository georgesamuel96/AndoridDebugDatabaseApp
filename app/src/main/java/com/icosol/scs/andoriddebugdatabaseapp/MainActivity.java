package com.icosol.scs.andoriddebugdatabaseapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.icosol.scs.andoriddebugdatabaseapp.user.User;
import com.icosol.scs.andoriddebugdatabaseapp.user.UserDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etName)
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        saveToPreference("george samuel - android debug database");
    }

    private void saveToPreference(String text) {
        SharedPreferences preferences = getSharedPreferences("PREF", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", text);
        editor.apply();
    }

    @OnClick(R.id.btn_shared_preference)
    public void onSharedPreferenceClicked() {
        final String etText = etName.getText().toString().trim();
        saveToPreference(etText);
    }

    @OnClick(R.id.btn_room_database)
    public void onRoomDatabaseClicked() {
        final String etText = etName.getText().toString().trim();
        User user = new User();
        user.setName(etText);
        UserDatabase userDatabase = Room.databaseBuilder(MainActivity.this, UserDatabase.class, "userdb").allowMainThreadQueries().build();
        userDatabase.getUserDao().insertUser(user);
    }

    @OnClick(R.id.btn_show)
    public void onShowClicked() {
        startActivity(new Intent(MainActivity.this, ListActivity.class));
    }
}
