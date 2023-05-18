package com.toronto.festivals.jk.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.toronto.festivals.jk.R
import com.toronto.festivals.jk.adapter.RollingViewPagerAdapter
import com.toronto.festivals.jk.data.model.FestivalsModel
import com.toronto.festivals.jk.databinding.FragmentFestivalsBinding
import com.toronto.festivals.jk.viewmodel.FestivalsViewModel
import com.toronto.festivals.jk.viewmodel.MapViewModel


class FestivalsFragment : Fragment() {

    private lateinit var festivalsViewModel: FestivalsViewModel
    private lateinit var binding: FragmentFestivalsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_festivals, container, false)
        festivalsViewModel = ViewModelProvider(this).get(FestivalsViewModel::class.java)

        binding.viewmodel = festivalsViewModel

        var bannerImgList: ArrayList<FestivalsModel> = ArrayList()

        val bannerModel = FestivalsModel()
        bannerModel.id.set("1")
        bannerModel.img.set("https://purepng.com/public/uploads/large/purepng.com-mario-basedmariosuper-mariovideo-gamefictional-characternintendoshigeru-miyamotomario-franchise-1701528638261qawv8.png")
        bannerModel.title.set("Festival 1")
        bannerImgList.add(bannerModel)
        val bannerModel2 = FestivalsModel()

        bannerModel2.id.set("2")
        bannerModel2.img.set("https://pngimg.com/d/mario_PNG41.png")
        bannerModel2.title.set("Festival 2")
        bannerImgList.add(bannerModel2)

        val bannerModel3 = FestivalsModel()
        bannerModel3.id.set("3")
        bannerModel3.img.set("https://www.pngimages.in/uploads/png-webp/2022/2022-August/Super_Mario_png_images.webp")
        bannerModel3.title.set("Festival 3")
        bannerImgList.add(bannerModel3)

        val adapter = context?.let { RollingViewPagerAdapter(bannerImgList, it) }
        binding.rollingViewPager.adapter = adapter

        festivalsViewModel.startAutoScroll(binding.rollingViewPager)


        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

}
