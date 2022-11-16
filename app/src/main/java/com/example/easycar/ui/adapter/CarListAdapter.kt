package com.example.easycar.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.easycar.databinding.CarItemCardBinding
import com.example.easycar.model.Car

class ForageableListAdapter(
    private val clickListener: (Car) -> Unit
) : ListAdapter<Car, ForageableListAdapter.CarViewHolder>(DiffCallback) {

    class CarViewHolder(
        private var binding: CarItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(car: Car) {
            binding.Car = car
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback: DiffUtil.ItemCallback<Car>() {
        override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem.licencePlate == newItem.licencePlate
        }

        override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem == newItem
        }

    }
    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val forageable = getItem(position)
        holder.itemView.setOnClickListener{
            clickListener(forageable)
        }
        holder.bind(forageable)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CarViewHolder(
            CarItemCardBinding.inflate(layoutInflater, parent, false)
        )
    }
}