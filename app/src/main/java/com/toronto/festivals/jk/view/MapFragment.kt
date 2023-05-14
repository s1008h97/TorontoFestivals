package com.toronto.festivals.jk.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.toronto.festivals.jk.R
import com.toronto.festivals.jk.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    private var binding: FragmentMapBinding? = null  //fragment_tab.xml 을 바인딩

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMapBinding.inflate(inflater, container, false)


        return binding?.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
