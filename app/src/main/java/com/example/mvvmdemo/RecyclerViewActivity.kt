package com.example.mvvmdemo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.adapter.DataRecyclerViewAdapter
import com.example.mvvmdemo.databinding.ActivityRecyclerViewBinding
import com.example.mvvmdemo.entity.Student
import kotlinx.android.synthetic.main.activity_recycler_view.*

const val TAG = "RecyclerViewActivity"

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val recyclerViewActivityDataBinding: ActivityRecyclerViewBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)
        Log.d(TAG, "override fun onCreate")

        val dataList = ArrayList<Student>()
        dataList.add(Student("疾风金豪", "面对疾风吧...", android.R.color.holo_orange_dark))
        dataList.add(Student("德莱文", "欢迎来到德莱联盟...", android.R.color.holo_purple))
        dataList.add(Student("寒冰女神", "世间万物皆系于一箭之上...", android.R.color.holo_red_dark))
        dataList.add(Student("虚空之女", "艾卡西亚暴雨...", android.R.color.holo_blue_light))

        val dataAdapter =
            DataRecyclerViewAdapter<Student>(this, R.layout.rv_item, BR.student)
        data_iv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        data_iv.adapter = dataAdapter
        dataAdapter.setDataSet(dataList)

        Log.d(TAG, "dataSize:${dataAdapter.itemCount}")
    }

    override fun onContentChanged() {

        super.onContentChanged()
        Log.d(TAG, "override fun onContentChanged")
    }
}