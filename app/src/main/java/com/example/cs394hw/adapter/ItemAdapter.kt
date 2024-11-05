package com.example.cs394hw.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cs394hw.R
import com.example.cs394hw.UserDetailActivity
import com.example.cs394hw.model.User

class ItemAdapter(private val data: List<User>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var user: User

        val brandView: TextView = view.findViewById(R.id.brandTV)
        val featureView: TextView = view.findViewById(R.id.featuresTV)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context,UserDetailActivity::class.java)
                showUserIntent.putExtra(UserDetailActivity.USER_BRAND,user.brand)
                showUserIntent.putExtra(UserDetailActivity.USER_FEATURE,user.FeaturesDesc)
                context.startActivity(showUserIntent)
            }
        }
        fun bind(user: User){
            this.user = user
            brandView.text = user.brand
            featureView.text = user.FeaturesDesc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
    return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = data[position]
        holder.bind(user)
    }
}