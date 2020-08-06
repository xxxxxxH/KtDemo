package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.http.NetConfig
import com.example.http.RequestService
import com.example.http.RetrofitUtils
import model.DataBean
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "xxxxxxH"
    val retrofit = RetrofitUtils.get().retrofit
    val service = retrofit.create(RequestService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        service.getDatas(NetConfig().VERSION_CODE, NetConfig().APP_ID, NetConfig().APP_SERCERT)
            .enqueue(object : Callback<DataBean> {
                override fun onFailure(call: retrofit2.Call<DataBean>, t: Throwable) {
                    Log.i(TAG, "onFailure")
                }

                override fun onResponse(
                    call: retrofit2.Call<DataBean>,
                    response: Response<DataBean>
                ) {
                    Log.i(TAG, "onResponse")
                }
            })
    }
}

