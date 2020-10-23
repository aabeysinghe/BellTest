package com.example.belltest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belltest.R
import com.example.belltest.ui.util.util
import com.example.belltest.ui.util.util.Companion.showAlertDialog


interface Communicator {
    fun passDataBetweenFrgments(dataOne: String?, dataTwo: String?, fragmentName: String)
}

const val TITLE = "title"
const val SCREEN_TYPE = "screen_type"
const val NAMEESPACE = "name_space"
const val ALIAS = "alias"

class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!util.isWiFiConnected(this)) showAlertDialog(
            this,
            getString(R.string.error),
            getString(R.string.internet_connection)
        ) else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frmMain, FirstFragment())
                .commit()
        }
    }

    override fun passDataBetweenFrgments(dataOne: String?, dataTwo: String?, fragmentName: String) {
        val transaction = this.supportFragmentManager.beginTransaction()
        if (fragmentName == "SecondFragment") {
            val bundle = Bundle().apply {
                putString(TITLE, dataOne)
                putString(SCREEN_TYPE, dataTwo)
            }
            val screenFragment = SecondFragment().also {
                it.arguments = bundle
            }
            transaction.replace(R.id.frmMain, screenFragment)
        } else if (fragmentName == "ThirdFragment") {
            val bundle = Bundle().apply {
                putString(NAMEESPACE, dataOne)
                putString(ALIAS, dataTwo)
            }
            val screenFragment = ThirdFragment().also {
                it.arguments = bundle
            }
            transaction.replace(R.id.frmMain, screenFragment)
        }

        transaction.addToBackStack(null)
        transaction.commit()

    }
}
