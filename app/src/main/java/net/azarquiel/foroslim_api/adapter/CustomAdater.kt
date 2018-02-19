package net.azarquiel.foroslim_api.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_row.view.*
import net.azarquiel.foroslim_api.model.Topic

/**
 * Created by alberto on 19/02/2018.
 */
class CustomAdater (val context: Context,
                    val layout: Int,
                    val data: List<Topic>): RecyclerView.Adapter<CustomAdater.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout,context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout){
        fun bind (dataItem: Topic){
            itemView.tvRow.text = dataItem.description
        }
    }
}