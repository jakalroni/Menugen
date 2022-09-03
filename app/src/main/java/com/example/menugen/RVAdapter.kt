package com.example.menugen

import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.menugen.databinding.RvItemBinding
import org.w3c.dom.Text

class RVAdapter(val items:MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>(){
    val recommend: Recommend ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(item : String){
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item

            val rv_btn = itemView.findViewById<Button>(R.id.addbtn)

            rv_btn.setOnClickListener{
                val foodlist = item.toString()
                Log.d("제발", item.toString())
            }
        }
    }
}