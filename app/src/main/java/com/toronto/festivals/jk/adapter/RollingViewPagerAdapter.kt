package com.toronto.festivals.jk.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.toronto.festivals.jk.data.model.FestivalsModel
import com.toronto.festivals.jk.databinding.ItemRollingBannerBinding

class RollingViewPagerAdapter(var festivalsModel: ArrayList<FestivalsModel>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class FestivalViewHolder(view: ItemRollingBannerBinding, private val context: Context) :
        RecyclerView.ViewHolder(view.root) {
        val festivalName = view.festivalName
        val thumbnailImg = view.thumbnailImg
        fun bind(festivalItem: FestivalsModel) {
            festivalName.text = festivalItem.title.get()
            Glide.with(context)
                .load(festivalItem.img.get())
                .into(thumbnailImg)
        }
    }

    override fun getItemCount(): Int {
        return festivalsModel.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemRollingBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = FestivalViewHolder(binding, context)

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val festivalsModel = festivalsModel[position]

        val festivalViewHolder = holder as FestivalViewHolder
        festivalViewHolder.bind(festivalsModel)
    }

}

