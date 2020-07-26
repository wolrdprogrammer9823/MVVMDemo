package com.example.mvvmdemo.entity
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class UserInfo(val userName: String, val userFace: String) {
    companion object {
        @BindingAdapter("bind:userFace")
        @JvmStatic
        fun getInternetImage(appCompatImageView: AppCompatImageView, userFace: String) {
            Glide.with(appCompatImageView.context).load(userFace).into(appCompatImageView)
        }
    }
}