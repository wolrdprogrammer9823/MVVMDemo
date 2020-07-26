package com.example.mvvmdemo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.mvvmdemo.databinding.ActivityUserBinding
import com.example.mvvmdemo.entity.UserInfo
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val userActivityMainBinding: ActivityUserBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_user)
        val userInfo =
            UserInfo("王老五", "http://img2.cache.netease.com/auto/2016/7/28/201607282215432cd8a.jpg")
        userActivityMainBinding.user = userInfo
    }
}