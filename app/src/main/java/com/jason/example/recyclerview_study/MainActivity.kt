package com.jason.example.recyclerview_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 리사이클러 뷰에 데이터를 추가하기위해서 지정
        val items = mutableListOf<String>()

        // 아이템을 하나하나 추가한다
        items.add("a")
        items.add("b")
        items.add("c")

        // recycler view 가져오기
        // databinding을 사용해도된다.
        val rv = findViewById<RecyclerView>(R.id.rv)

        // main과 adapter연결
        val rvAdapter = RvAdapter(items)
        rv.adapter = rvAdapter

        // 리스트뷰와 다른점이다.
        // 레이아웃 매니저를 사용해야한다.
        rv.layoutManager = LinearLayoutManager(this)

        rvAdapter.itemClick = object : RvAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position],Toast.LENGTH_SHORT).show()
            }

        }
    }
}