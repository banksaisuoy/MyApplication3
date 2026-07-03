package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter as AndroidxListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemListBinding

class ListAdapter : AndroidxListAdapter<Listing, ListAdapter.ListingViewHolder>(ListingDiffCallback()) {

    class ListingViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        val listing = getItem(position)
        holder.binding.tvItemTitle.text = listing.title
        holder.binding.tvItemDescription.text = listing.description
    }
}

class ListingDiffCallback : DiffUtil.ItemCallback<Listing>() {
    override fun areItemsTheSame(oldItem: Listing, newItem: Listing): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Listing, newItem: Listing): Boolean {
        return oldItem == newItem
    }
}
