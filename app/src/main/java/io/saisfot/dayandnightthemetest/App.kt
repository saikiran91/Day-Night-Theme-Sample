package io.saisfot.dayandnightthemetest

import android.app.Application
import android.support.v7.app.AppCompatDelegate
import getLastSavedDayNightTheme

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(getLastSavedDayNightTheme())
    }
}
