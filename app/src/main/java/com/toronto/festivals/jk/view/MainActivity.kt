package com.toronto.festivals.jk.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.toronto.festivals.jk.R
import com.toronto.festivals.jk.data.model.FestivalCalEventModel
import com.toronto.festivals.jk.data.network.FestivalAPIService
import com.toronto.festivals.jk.databinding.ActivityMainBinding
import com.toronto.festivals.jk.util.OnSingleClickListener
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var pagerAdapter: PagerAdapter

    var festivalsFragment: FestivalsFragment? = null
    var mapFragment: MapFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // ys - test code
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClientBuilder = OkHttpClient.Builder().addInterceptor(loggingInterceptor)

        val retrofit = Retrofit.Builder().baseUrl("https://secure.toronto.ca/")
            .client(httpClientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create()).build()
        val festivalService = retrofit.create(FestivalAPIService::class.java)

        festivalService.getFestivalCalEventJson("edc_eventcal_APR").enqueue(object :
            Callback<List<FestivalCalEventModel>> {
            override fun onResponse(
                call: Call<List<FestivalCalEventModel>>,
                response: Response<List<FestivalCalEventModel>>
            ) {
                if (response.isSuccessful) {
                    // 정상적으로 통신이 성공된 경우
                    var result: List<FestivalCalEventModel>? = response.body()
                    Log.d("Sun's TEST", "onResponse 성공: " + result?.toString());
                } else {
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("Sun's TEST", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<List<FestivalCalEventModel>>, t: Throwable) {
                Log.d("Sun's TEST", "onFailure Error: " + t.message.toString());
            }
        })


        setUpFragment()
    }

    // Fragment Setting
    private fun setUpFragment() {
        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager, 1)
        binding.viewPager.adapter = pagerAdapter

        pagerAdapter.startUpdate(binding.viewPager)
        festivalsFragment = pagerAdapter.instantiateItem(binding.viewPager, 0) as FestivalsFragment
        mapFragment = pagerAdapter.instantiateItem(binding.viewPager, 1) as MapFragment

        binding.viewPager.addOnPageChangeListener(mOnPageChangeListener)

        binding.tabMain.setOnClickListener(object : OnSingleClickListener() {
            override fun onSingleClick(view: View?) {
                binding.viewPager.currentItem = 0
            }
        })
        binding.tabMap.setOnClickListener(object : OnSingleClickListener() {
            override fun onSingleClick(view: View?) {
                binding.viewPager.currentItem = 1
            }
        })
    }

    private class ScreenSlidePagerAdapter(fm: FragmentManager, behavior: Int) :
        FragmentStatePagerAdapter(fm, behavior) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> FestivalsFragment()
                1 -> MapFragment()
                else -> return FestivalsFragment()
            }
        }

        override fun getCount(): Int {
            return 2
        }
    }

    private val mOnPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            if (position == 0) {
                binding.tabMain.setTextColor(resources.getColor(R.color.black))
                binding.tabMap.setTextColor(resources.getColor(R.color.colorE0E0E0))
            } else if (position == 1) {
                binding.tabMap.setTextColor(resources.getColor(R.color.black))
                binding.tabMain.setTextColor(resources.getColor(R.color.colorE0E0E0))
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

}
