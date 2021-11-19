package ru.skillbranch.news.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.news.R
import ru.skillbranch.news.model.model
import ru.skillbranch.news.view.UsersContractView

class recyclerView : AppCompatActivity(), UsersContractView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
          val data = model()
        recyclerView.adapter = CustomRecyclerAdapter(data.getHtmlFromWeb(),this)
    }

    override fun getActivity():AppCompatActivity{
        return this
    }
    }
