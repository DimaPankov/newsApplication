package ru.skillbranch.news.presenter
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.news.view.MainActivity
import ru.skillbranch.news.view.UsersContractView





class presenter {

    private var view: UsersContractView? = null

   fun attachView(view: UsersContractView?) {
        this.view = view
    }


    fun nextActivity(){
        val i = Intent(view?.getActivity(),recyclerView::class.java)
        Thread(Runnable {
            Thread.sleep(3000)


            view?.getActivity()?.startActivity(i)

        }).start()

    }

}