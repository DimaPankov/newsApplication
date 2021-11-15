package ru.skillbranch.news

import android.graphics.BitmapFactory
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.net.URL
import androidx.core.content.ContextCompat.startActivity

import android.content.Intent
import android.os.Bundle


class CustomRecyclerAdapter (private val names:List<News>) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>()  {

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mTVTitle: TextView? = null
        var mIicon: ImageView? = null

        init {
            mTVTitle = itemView.findViewById(R.id.textViewTitle)
            mIicon = itemView.findViewById(R.id.imageViewIcon)



        }


    }
    //В методе onCreateViewHolder нужно указать идентификатор макета для отдельного
    // элемента списка, созданный нами ранее в файле recyclerview_item.xml. А также вернуть наш
    // объект класса ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val items = names
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView).listen { pos, type ->
            val item = items.get(pos)
            Log.d("TAG", pos.toString())
            val a = recyclerView()

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTVTitle?.text = names[position].title
        holder.mIicon?.setImageBitmap(names[position].image)


    }
// Тут мы указываем колличество item которое должно быть в списке
    override fun getItemCount(): Int {
     return names.size
    }


}