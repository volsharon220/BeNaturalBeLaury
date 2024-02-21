package com.example.yourappname.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.benaturalbylaury.Product
import com.example.benaturalbylaury.R

class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.view.product_name.text = product.name
        holder.view.product_price.text = "$${product.price}"
        holder.view.setOnClickListener { onProductClick(product) }
}
    override fun getItemCount(): Int = products.size
}