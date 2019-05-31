package me.gilo.wc.adapter

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.gilo.wc.R
import me.gilo.wc.adapter.viewholder.MenuViewHolder

import java.util.HashMap

class MenuAdapter(private val titles: List<String>) : RecyclerView.Adapter<MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            parent.context,
            LayoutInflater.from(parent.context).inflate(R.layout.single_menu_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.renderView(titles[position])
    }


    override fun getItemCount(): Int {
        return if (titles.isEmpty()) 0 else titles.size
    }
}
