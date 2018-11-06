package io.saisoft.daynightthemesample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import io.saisfot.dayandnightthemetest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val radioGroupChangeListener: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { _, checkedId ->

            //To prevent infinite loop while recreating and to prevent any
            // theme changes when activity no longer exist
            if (!findViewById<RadioButton>(checkedId).isPressed || isDestroyed || isFinishing)
                return@OnCheckedChangeListener

            val mode = when (checkedId) {
                R.id.rb_auto -> AppCompatDelegate.MODE_NIGHT_AUTO
                R.id.rb_day -> AppCompatDelegate.MODE_NIGHT_NO
                R.id.rb_night -> AppCompatDelegate.MODE_NIGHT_YES
                R.id.rb_system -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                else -> AppCompatDelegate.MODE_NIGHT_AUTO
            }

            setNightModeTheme(mode = mode)
            saveDayNightTheme(mode = mode)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        restoreRadioGroupSelection(getLastSavedDayNightTheme())
        radio_group.setOnCheckedChangeListener(radioGroupChangeListener)
    }

    private fun restoreRadioGroupSelection(mode: Int) {
        val resId = when (mode) {
            AppCompatDelegate.MODE_NIGHT_AUTO -> R.id.rb_auto
            AppCompatDelegate.MODE_NIGHT_NO -> R.id.rb_day
            AppCompatDelegate.MODE_NIGHT_YES -> R.id.rb_night
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -> R.id.rb_system
            else -> AppCompatDelegate.MODE_NIGHT_AUTO
        }
        radio_group.check(resId)
    }

    fun onLaunchNewActivityClicked(view: View) =
        startActivity(Intent(this, TestActivity::class.java))

}
