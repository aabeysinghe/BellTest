package com.example.belltest.ui.util

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import com.example.belltest.R


class util {
    companion object {
        fun isWiFiConnected(context: Context): Boolean {
            val connectivityManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager
                .activeNetworkInfo
            return networkInfo != null && networkInfo.isConnectedOrConnecting
        }
       fun showAlertDialog(context: Context, title: String, message: String){
           AlertDialog.Builder(context)
               .setTitle(title)
               .setMessage(message)
               .setPositiveButton(R.string.alert_ok, null)
               .setCancelable(false)
               .show()
       }

    }

}

