package com.girish.notes;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.example.girish.notes.BuildConfig;
import com.girish.model.NotesDAO;

public class NotesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initalize ActiveAndroid

        if (BuildConfig.DEBUG) {
            ActiveAndroid.initialize(this, true);
        } else {
            ActiveAndroid.initialize(this);
        }
    }
}
