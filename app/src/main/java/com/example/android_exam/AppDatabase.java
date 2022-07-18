package com.example.android_exam;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 1)
public abstract class AppDatabase  extends RoomDatabase {
    private static AppDatabase appDatabase;
    public abstract EmployeeDao employeeDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context,AppDatabase.class,"Employee.db")
                    .allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
