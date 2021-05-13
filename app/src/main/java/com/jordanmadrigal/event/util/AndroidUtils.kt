package com.jordanmadrigal.event.util

import android.app.Activity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.jordanmadrigal.event.R

class AndroidUtils {

    companion object {

        fun showSnackBar(activity: Activity, msg: String) {

            Snackbar.make(activity.findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG)
                .setAction("Dismiss") {
                }.setActionTextColor(ContextCompat.getColor(activity, R.color.purple_200))
                .show()
        }
    }
}