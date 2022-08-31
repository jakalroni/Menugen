package com.example.menugen

import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.menugen.databinding.FragmentManagement1Binding
import com.example.menugen.databinding.RvItemBinding
import org.w3c.dom.Text

class RVAdapter(val items:MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>(){

    // 최종 음식 확인란에 들어갈 데이터
    val listData = mutableListOf<Member>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    // 사용자가 음식 추가 클릭 시 이벤트 처리를 위한 함수수
    interface ItemClick{
        fun OnClick(view: View, position: Int)
    }


    // 사용자가 음식 추가 클릭 시 처리 이벤트를 위한 함수와 변수
    private lateinit var itemClickListener: ItemClickListener

    interface ItemClickListener{
        fun OnClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null
    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener=itemClickListener
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position])
        holder.name.text = items[position]

        holder.itemView.setOnClickListener{
            itemClickListener.OnClick(it, position)
        }

        if(itemClick != null){
            holder?.itemView?.setOnClickListener{v->
                itemClick!!.OnClick(v, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(item : String){
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item
        }

        val name: TextView = itemView.findViewById<TextView>(R.id.rvItem)
    }

    /*
    inner class ViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem(item : String){
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item
        }

        init{
            binding.addbtn.setOnClickListener{
                val pos = adapterPosition
                val item = binding.rvItem.text
            }
        }
    }
     */
}