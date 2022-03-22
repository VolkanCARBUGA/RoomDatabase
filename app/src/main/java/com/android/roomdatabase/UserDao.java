package com.android.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
 void insertUsers(User users);
    @Query("select*from users")
    public List<User> getData();
@Delete
    void deleteUsers(User users);
@Update
    void updateUsers(User users);

}
