package com.angle.hshb.mykotlin.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.angle.hshb.mykotlin.SecondActivity

/**
 * Created by Administrator on 2017/8/23.
 */
class ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.textview.text=items[position]
        holder?.textview.setOnClickListener {
            holder?.textview.context.startActivity(Intent(holder?.textview.context,SecondActivity::class.java))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent!!.context))
    }


    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(val textview: TextView) : RecyclerView.ViewHolder(textview)
}