package com.example.mvvmdemo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.entity.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val activityMainBinding : ActivityMainBinding  = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val userEntity = UserEntity("江德福", "三小", 20)
        activityMainBinding.user = userEntity
    }

    override fun onContentChanged() {
        super.onContentChanged()
        btn_load_img.setOnClickListener(onClickListener)
        btn_show_list.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { v ->
        when (v?.id) {

            R.id.btn_load_img -> {
                startActivity(Intent(this, UserActivity::class.java))
            }

            R.id.btn_show_list -> {
                startActivity(Intent(this, RecyclerViewActivity::class.java))
            }

            else -> {}
        }
    }
}