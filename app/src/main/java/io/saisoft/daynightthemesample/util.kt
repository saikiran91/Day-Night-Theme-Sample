package io.saisoft.daynightthemesample

import android.app.Activity
import android.content.Context
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatDelegate
import io.saisfot.dayandnightthemetest.R


fun Activity.setNightModeTheme(mode: Int) {
    AppCompatDelegate.setDefaultNightMode(mode)
    window.setWindowAnimations(R.style.AppTheme_ThemeChangeTransitionAnimation)
    recreate()
}

fun Context.saveDayNightTheme(mode: Int) =
    PreferenceManager.getDefaultSharedPreferences(this)
        .run { edit().putInt("NIGHT_MODE", mode).apply() }

fun Context.getLastSavedDayNightTheme()=
    PreferenceManager.getDefaultSharedPreferences(this)
        .run { getInt("NIGHT_MODE", AppCompatDelegate.MODE_NIGHT_AUTO) }

