package com.example.mvvmdemo.entity
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Handler
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

data class UserInfo(val userName: String, val textColor : Int, val userFace: String) {

    companion object {
        @BindingAdapter("bind:userFace")
        @JvmStatic
        fun getInternetImage(appCompatImageView: AppCompatImageView, userFace: String) {

            Glide.with(appCompatImageView.context).load(userFace).into(appCompatImageView)
        }

        @BindingAdapter("bind:textColor")
        @JvmStatic
        fun setTextColor(textView: AppCompatTextView, textColor: Int) {
            textView.setTextColor(textColor)
        }
    }
}