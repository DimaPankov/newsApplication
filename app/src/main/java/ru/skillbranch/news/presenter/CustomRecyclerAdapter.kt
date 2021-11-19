package ru.skillbranch.news.presenter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.news.R
import ru.skillbranch.news.view.UsersContractView
import ru.skillbranch.news.view.newsItem
import android.graphics.Bitmap
import java.io.ByteArrayOutputStream


class CustomRecyclerAdapter (private val names:List<News>, private val activity:UsersContractView) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>()  {



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
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView).listen { pos, type ->




            val i = Intent(activity.getActivity(), newsItem::class.java)
            i.putExtra("title", names[pos].title)
            i.putExtra("image",names[pos].byteArray)
            activity.getActivity().startActivity(i)


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