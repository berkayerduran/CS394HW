package com.example.cs394hw

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.cs394hw.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {
    companion object{
        const val USER_BRAND = "user_brand"
        const val USER_FEATURE = "user_feature"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity_user_detail)
        val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_user_detail)

        val brandName = intent.getStringExtra(USER_BRAND)
        val brandFeature = intent.getStringExtra(USER_FEATURE)

        binding.brandView.text = brandName
        binding.featureView.text = brandFeature

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}