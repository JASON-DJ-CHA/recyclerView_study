package com.jason.example.recyclerview_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(val items : MutableList<String>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int) : RvAdapter.ViewHolder {
        //리사이클러뷰의 아이템을 가져온다
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.rv_items, parent,false)

        return ViewHolder(view)
    }

    // onClickListener를 구현하기 한 코드 1
    interface  ItemClick{
        fun onClick(view: View, position: Int)
    }
    // onClickListener를 구현하기 한 코드 2
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {

        // onClickListener를 구현하기 한 코드 3
        if (itemClick != null) {
            holder.itemView.setOnClickListener { v->
                itemClick?.onClick(v,position)
            }
        }

        // 뷰홀더에 바인딩해준다.
        // viewbinding이란 어뎁터에서 넘어온 데이터를 아이템을 리사이클러뷰로 포함시키는 것
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        // 리사이클러뷰의 갯수를 알려준다.
        return items.size
    }



    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item: String){
            // 데이터들 매핑해주기
            val rv_text = itemView.findViewById<TextView>(R.id.rv_items1)
            rv_text.text = item
        }

    }
}