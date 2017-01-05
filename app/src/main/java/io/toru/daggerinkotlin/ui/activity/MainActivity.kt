package io.toru.daggerinkotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import io.toru.daggerinkotlin.R
import io.toru.daggerinkotlin.model.ItemTypeModel
import io.toru.daggerinkotlin.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val list = LinkedList<ItemTypeModel>().apply {
            add(ItemTypeModel("Toru"))
            add(ItemTypeModel("Pluu"))
            add(ItemTypeModel("Kunny"))
            add(ItemTypeModel("Taehwan"))
            add(ItemTypeModel("Nurinamu"))
            add(ItemTypeModel("Nayeon"))
            add(ItemTypeModel("Chansuk"))
            add(ItemTypeModel("JiHwan"))
        }
        val adapter = MainAdapter(list){
            Log.w("Main",it.text)
        }
        main_recyclerview.adapter = adapter
        main_recyclerview.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()
    }

    fun String.toInt():Int{
        return 18
    }

    fun test(item:ItemTypeModel){

    }
}