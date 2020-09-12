package com.example.mvvmdemo
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.example.mvvmdemo.databinding.ActivityUserBinding
import com.example.mvvmdemo.entity.UserInfo
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val userActivityMainBinding: ActivityUserBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_user)

        val bitmap : Bitmap = runBlocking(Dispatchers.IO) {
            Glide.with(this@UserActivity).asBitmap().load("http://img2.cache.netease.com/auto/2016/7/28/201607282215432cd8a.jpg").submit().get()
        }
        val palette  = Palette.from(bitmap).generate()
        val mutedColor = palette.getVibrantColor(Color.BLACK)
        //val mutedColor = palette.getDarkMutedColor(Color.BLACK)
        //val mutedColor = palette.getLightMutedColor(Color.BLACK)
        //val mutedColor = palette.getMutedColor(Color.BLACK)
        //val mutedColor = palette.getDominantColor(Color.BLACK)
        //val mutedColor = palette.getDarkVibrantColor(Color.BLACK)

        val userInfo =
            UserInfo(
                "王老五",
                mutedColor,
                "http://img2.cache.netease.com/auto/2016/7/28/201607282215432cd8a.jpg"
            )
        userActivityMainBinding.user = userInfo

    }
}