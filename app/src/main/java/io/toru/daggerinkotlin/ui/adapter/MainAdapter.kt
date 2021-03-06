package io.toru.daggerinkotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.toru.daggerinkotlin.R
import io.toru.daggerinkotlin.model.ItemTypeModel
import kotlinx.android.synthetic.main.main_adapter.view.*

/**
 * Created by wonyoung on 2017. 1. 4..
 */
class MainAdapter(var itemList:List<ItemTypeModel>, val itemClick: (ItemTypeModel) -> Unit): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        with(holder){
            update(itemList[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.main_adapter, parent, false)
        return MainViewHolder(view, itemClick)
    }

    inner class MainViewHolder(itemView:View, val itemClick:(ItemTypeModel)->Unit) : RecyclerView.ViewHolder(itemView){

        fun update(item:ItemTypeModel){
            with(item){
                itemView.main_adapter_text.text = this.text
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}
