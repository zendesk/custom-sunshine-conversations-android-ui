package com.example.stasi.customsmoochui;

/**
 * Created by stasi on 2018-01-18.
 */

import android.app.Application;

import io.smooch.core.Settings;
import io.smooch.core.Smooch;

public class CustomUiApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Smooch.init(this, new Settings("<your_app_id>"), null);
    }
}
