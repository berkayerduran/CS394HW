package com.example.cs394hw.data

import android.content.Context
import com.example.cs394hw.R
import com.example.cs394hw.model.User

class DataSource (val context: Context){
    fun getCarBrandList(): Array<String>{
        return context.resources.getStringArray(R.array.car_brand)
    }
    fun getFeaturesOfCarList(): Array<String>{
        return context.resources.getStringArray(R.array.featuresOfCars)
    }

    fun loadUsers(): List<User>{
        val brandList = getCarBrandList()
        val featuresList = getFeaturesOfCarList()

        val users = mutableListOf<User>()
        for (i in brandList.indices){
            users.add(User(brandList[i],featuresList[i]))
        }
        return users
    }
}