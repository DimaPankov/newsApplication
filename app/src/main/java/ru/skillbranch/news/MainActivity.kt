package ru.skillbranch.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jsoup.Jsoup


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Thread(Runnable {

            Thread.sleep(30000)
            intent = Intent(this,recyclerView::class.java)
            startActivity(intent);

        }).start()

    }

    }
