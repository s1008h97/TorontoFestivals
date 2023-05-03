package com.toronto.festivals.jk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toronto.festivals.jk.R
import com.toronto.festivals.jk.databinding.ItemFestivalBinding
import com.toronto.festivals.jk.model.FestivalsModel

class FestivalsAdapter(val festivalsModel: ArrayList<FestivalsModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class FestivalViewHolder(view: ItemFestivalBinding) : RecyclerView.ViewHolder(view.root) {
        val textTitle = view.textTitle
        fun bind(festivalItem: FestivalsModel) {
            textTitle.text = festivalItem.title.toString()
        }
    }

    override fun getItemCount(): Int {
        return festivalsModel.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemFestivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = FestivalViewHolder(binding)

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val festivalsModel = festivalsModel[position]

        val festivalViewHolder = holder as FestivalViewHolder
        festivalViewHolder.bind(festivalsModel)
    }

}

