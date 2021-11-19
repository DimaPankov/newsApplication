package ru.skillbranch.news.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ru.skillbranch.news.R
import android.content.Intent
import android.graphics.BitmapFactory

import android.graphics.Bitmap







class newsItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_item)
        val imageView = findViewById<ImageView>(R.id.imageView2)
        val textView =  findViewById<TextView>(R.id.textView2)
        val intent = intent
        val byteArray = intent.getByteArrayExtra("image")
        textView.setText(intent.getStringExtra("title"))
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size))
    }
}