package ru.skillbranch.news.view

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import ru.skillbranch.news.R
import ru.skillbranch.news.presenter.presenter
import ru.skillbranch.news.presenter.recyclerView


class MainActivity : AppCompatActivity(),UsersContractView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val i = Intent(this, recyclerView::class.java)
        val presenter = presenter()
        presenter.attachView(this)
        presenter.nextActivity()

    }
override fun getActivity():AppCompatActivity{
    return this
}
    }
