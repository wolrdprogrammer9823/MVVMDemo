package com.example.mvvmdemo.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.entity.Student

class DataRecyclerViewAdapter<T>(
    private val context: Context,
    private val layoutId: Int,
    private val variableId: Int
) : RecyclerView.Adapter<DataRecyclerViewAdapter<T>.DataViewHolder>() {

    private lateinit var mDataSet: List<T>

    private val layoutInflater by lazy {
        LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val dataBinding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, layoutId, parent, false)
        return DataViewHolder(dataBinding.root, dataBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.mViewDataBinding.setVariable(variableId, mDataSet[position])
        holder.mViewDataBinding.executePendingBindings()
    }

    override fun getItemCount(): Int = this.mDataSet.size

    fun setDataSet(mDataSet: List<T>) {
        this.mDataSet = mDataSet
        notifyDataSetChanged()
    }

    inner class DataViewHolder(itemView: View, viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(itemView) {
        val mViewDataBinding = viewDataBinding
    }

}