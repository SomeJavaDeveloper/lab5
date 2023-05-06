package com.example.lab5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RentalAdapter : RecyclerView.Adapter<RentalAdapter.RentalViewHolder>() {

    var onItemClick: ((Int) -> Unit)? = null
    var items: List<RentalOfProperty> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RentalViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RentalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onViewRecycled(holder: RentalViewHolder) {
        super.onViewRecycled(holder)
        holder.unbind()
    }

    inner class RentalViewHolder(
        private val root: View
    ) : RecyclerView.ViewHolder(root) {
        fun bind(rentalOfProperty: RentalOfProperty) {
            root.setOnClickListener { onItemClick?.invoke(adapterPosition) }
            root.findViewById<TextView>(R.id.textView).text = rentalOfProperty.address
            root.findViewById<TextView>(R.id.textView9).text =
                rentalOfProperty.monthlyCost.toString()
        }

        fun unbind() {
            root.setOnClickListener { }
        }
    }
}