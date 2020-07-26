package com.example.mvvmdemo.entity
import android.view.View
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR

data class Student(val name: String, @Bindable var hobby: String, val backgroundColor: Int) : BaseObservable() {

    fun onItemClick(view: View) {

        Toast.makeText(view.context, hobby, Toast.LENGTH_SHORT).show()

        //数据更新实现  1.字段用@Bindable修饰 2.继承BaseObservable类  3.使用notifyPropertyChanged()方法
        //dataBinding常用更新数据方式
        // 1.使用BaseObservable类
        // 2.使用ObservableFields创建实体类
        // 3.使用DataBinding提供的集合来存储数据 ObservableArrayList  ObservableArrayMap
        hobby = "虚空索尼..."
        notifyPropertyChanged(BR.hobby)
    }

    companion object {
        @BindingAdapter("bind:backgroundColor")
        @JvmStatic
        fun setViewBackground(view: View, backgroundColor: Int) {
            view.setBackgroundColor(view.context.resources.getColor(backgroundColor))
        }
    }

}