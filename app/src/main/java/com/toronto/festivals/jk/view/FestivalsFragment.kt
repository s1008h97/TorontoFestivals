package com.toronto.festivals.jk.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.toronto.festivals.jk.R
import com.toronto.festivals.jk.databinding.FragmentFestivalsBinding
import com.toronto.festivals.jk.databinding.FragmentMapBinding

class FestivalsFragment : Fragment() {

    private var binding: FragmentFestivalsBinding? = null  //fragment_tab.xml 을 바인딩

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFestivalsBinding.inflate(inflater, container, false)


        return binding?.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
