package com.example.android.todolist.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Database(entities = {TaskEntry.class} , version = 1 , exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "todolist";
    private static AppDatabase sInstance;
    
    public static AppDatabase getInstance(Context context)
    {
        if(sInstance==null)
        {
            synchronized (LOCK){

                Log.d(LOG_TAG , "Creating new Database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class , AppDatabase.DATABASE_NAME)
                        .build();

            }

        }
        Log.d(LOG_TAG , "Getting database Instance");

        return sInstance;

    }

    public abstract TaskDao taskDao();






}
