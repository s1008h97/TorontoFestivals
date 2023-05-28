package com.toronto.festivals.jk.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.toronto.festivals.jk.R
import com.toronto.festivals.jk.databinding.FragmentFestivalsBinding
import com.toronto.festivals.jk.databinding.FragmentMapBinding
import com.toronto.festivals.jk.viewmodel.FestivalsViewModel
import com.toronto.festivals.jk.viewmodel.MapViewModel

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private lateinit var mapViewModel: MapViewModel
    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)
        mapViewModel = ViewModelProvider(this).get(MapViewModel::class.java)
        binding.viewmodel = mapViewModel

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val toronto = LatLng(43.7102627, -79.397455)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toronto))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(12f))
    }

}
