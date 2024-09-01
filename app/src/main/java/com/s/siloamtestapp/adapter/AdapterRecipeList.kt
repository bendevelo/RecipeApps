package com.s.siloamtestapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.recyclerview.widget.RecyclerView
import com.s.siloamtestapp.R
import com.s.siloamtestapp.databinding.ListRecipeBinding
import com.s.siloamtestapp.model.Data
import com.s.siloamtestapp.view.DetailActivity
import com.squareup.picasso.Picasso


class AdapterRecipeList() : RecyclerView.Adapter<AdapterRecipeList.CustomHolder>() {

    private val recipelist = mutableListOf<Data>()
    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = ListRecipeBinding.inflate(inflater, parent, false)
        return CustomHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        holder.bind(recipelist[position])

    }

    override fun getItemCount(): Int = recipelist.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Data>) {
        recipelist.clear()
        recipelist.addAll(list)
        notifyDataSetChanged()
    }

    inner class CustomHolder(private val binding: ListRecipeBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(list: Data) {
            binding.apply {
                list.also {
                   binding.title.text = list.strMeal
                    binding.category.text = list.strCategory
                    binding.source.text = list.strArea
                    Picasso.get()
                        .load(list.strMealThumb)
                        .resize(200, 200)
                        .centerCrop()
                        .into(binding.imageView)

                    binding.imageView.setOnClickListener { showPopup(list.strMealThumb) }

                    binding.root.setOnClickListener {
                        val intent = Intent(mContext, DetailActivity::class.java)
                        intent.putExtra("title",list.strMeal)
                        intent.putExtra("image",list.strMealThumb)
                        intent.putExtra("instructor",list.strInstructions)

                        intent.putExtra("ingredient1","${list.strIngredient1}  ${list.strMeasure1}")
                        intent.putExtra("ingredient2","${list.strIngredient2}  ${list.strMeasure2}")
                        intent.putExtra("ingredient3","${list.strIngredient3}  ${list.strMeasure3}")
                        intent.putExtra("ingredient4","${list.strIngredient3}  ${list.strMeasure4}")
                        intent.putExtra("ingredient5","${list.strIngredient3}  ${list.strMeasure5}")
                        intent.putExtra("ingredient6","${list.strIngredient3}  ${list.strMeasure6}")
                        intent.putExtra("ingredient7","${list.strIngredient3}  ${list.strMeasure7}")
                        intent.putExtra("ingredient8","${list.strIngredient3}  ${list.strMeasure8}")

                        mContext.startActivity(intent)
                    }

                }
            }
        }
    }

    fun showPopup(url: String) {
        val inflater = LayoutInflater.from(mContext)
        val popupView = inflater.inflate(R.layout.layout_popup_image, null)
        val popupImageView = popupView.findViewById<ImageView>(R.id.popupImageView)
        Picasso.get()
            .load(url)
            .resize(650, 650)
            .centerCrop()
            .into(popupImageView)



        val popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        popupWindow.showAtLocation(popupImageView, Gravity.CENTER, 0, 0)

        popupView.setOnClickListener {
            popupWindow.dismiss()
        }
    }

}