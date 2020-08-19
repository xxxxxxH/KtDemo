package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.util.Log
import android.view.View
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import coil.api.load
import com.alibaba.android.arouter.launcher.ARouter
import com.example.http.NetConfig
import com.example.http.RequestService
import com.example.http.RetrofitUtils
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*
import model.DataBean
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val TAG = "xxxxxxH"
    val retrofit = RetrofitUtils.get().retrofit
    val service = retrofit.create(RequestService::class.java)
    var dataBean: DataBean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)
        img.load("https://androidtest-75693.gzc.vod.tencent-cloud.com/timg.jpg")
        collapsing.setExpandedTitleColor(Color.WHITE)
        collapsing.setCollapsedTitleTextColor(Color.WHITE)
        toolbar.setOnClickListener {
            ARouter.getInstance().build(RouterPath.ACTIVITY_SELECT).navigation()
        }
        appBar.addOnOffsetChangedListener(object : AppBarStateChangeListener() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                when {
                    state === State.EXPANDED -> {

                        //展开状态
                        collapsing.title = ""

                    }
                    state === State.COLLAPSED -> {
                        //折叠状态
                        collapsing.title = dataBean?.city
                    }
                    else -> {
                        //中间状态
                        collapsing.title = ""
                    }
                }
            }
        })
        service.getDatas(NetConfig.VERSION_CODE, NetConfig.APP_ID, NetConfig.APP_SERCERT)
            .enqueue(object : Callback<DataBean> {
                override fun onFailure(call: retrofit2.Call<DataBean>, t: Throwable) {
                    Log.i(TAG, "onFailure")
                }

                override fun onResponse(
                    call: retrofit2.Call<DataBean>,
                    response: Response<DataBean>
                ) {
                    Log.i(TAG, "onResponse")
                    dataBean = response.body()
                    binding.data = dataBean
                    binding.alarmBean = dataBean?.alarm
                    alarm.visibility = if (isEmpty(dataBean?.alarm?.alarm_type)) {
                        GONE
                    } else {
                        View.VISIBLE
                    }
                }
            })
    }
}

