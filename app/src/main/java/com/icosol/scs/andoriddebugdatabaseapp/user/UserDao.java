package com.icosol.scs.andoriddebugdatabaseapp.user;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("select * from user")
    List<User> getUsers();
}
