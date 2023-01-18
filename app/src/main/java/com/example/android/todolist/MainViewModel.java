package com.example.android.todolist;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;


import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<TaskEntry>> tasks;

    private static final String TAG = MainViewModel.class.getSimpleName();


    public MainViewModel(Application application) {
        super(application);

        AppDatabase database = AppDatabase.getInstance(this.getApplication());

        Log.d(TAG , "Activity retrieving data from database");

        tasks = database.taskDao().loadAllTasks();


    }



    public LiveData<List<TaskEntry>> getTasks()
    {

        return tasks;

    }




}
