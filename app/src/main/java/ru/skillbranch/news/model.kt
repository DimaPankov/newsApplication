package ru.skillbranch.news

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException
import java.io.InputStream
import java.net.URL

class model {
    public fun getHtmlFromWeb():MutableList<News> {
    return getResult()
    }




                                      //TITLES//
   private class TaskBacgraundWorkTitle(): AsyncTask<Void, Void, MutableList<String>>(){
        override fun doInBackground(vararg p0: Void?): MutableList<String> {
            lateinit var  links: Elements
            lateinit var doc:Document
            val titles = mutableListOf<String>()
            doc = Jsoup.connect("https://www.rbc.ru/short_news/").get()
            links =    doc.getElementsByClass("item__title rm-cm-item-text")
            for(g in links){
                    titles.add(Regex(""">|<""").replace(Regex(""">.*<""").find(g.toString()!!)!!.value,""))
                }
            return titles

        }
    }

                                     //IMAGE//
    private class TaskBacgraundWorkImage(): AsyncTask<Void, Void, MutableList<Bitmap>>(){

        override fun doInBackground(vararg p0: Void?): MutableList<Bitmap> {
            lateinit var  links: Elements
            lateinit var doc:Document
            var img = mutableListOf<Bitmap>()
            doc = Jsoup.connect("https://www.rbc.ru/short_news/").get()
            val imgClass = doc.getElementsByClass("item__image-block")
            for(g in imgClass){
                    var url:URL = URL(Regex("""<span class=\".*c=\"|\" class=.*""").replace(g.toString(),""))
                     img.add(BitmapFactory.decodeStream(url.openStream()))
            }
            return img
        }

    }
                              //URL
    private class TaskBacgraundWorkURL(): AsyncTask<Void, Void, MutableList<String>>(){

        override fun doInBackground(vararg p0: Void?): MutableList<String> {
            lateinit var  links: Elements
            lateinit var doc:Document
            var urlString = mutableListOf<String>()
            doc = Jsoup.connect("https://www.rbc.ru/short_news/").get()
            val imgClass = doc.getElementsByClass("item__link")
            for(g in imgClass){
              Log.d("FFFFFFFFFFFF",g.attr("href"))

        }
            return urlString
    }}


    fun getResult() : MutableList<News>{
        val result = mutableListOf<News>()
        val taskImage = TaskBacgraundWorkImage().execute().get()
        val taskTitle = TaskBacgraundWorkTitle().execute().get()
        val taskUrl = TaskBacgraundWorkURL().execute().get()
        for(g in 0..taskTitle.size-5){
            result.add(News(taskTitle[g],taskImage[g]))
        }






        return result

   }}

