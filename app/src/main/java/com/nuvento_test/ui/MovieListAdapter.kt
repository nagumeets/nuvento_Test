package com.nuvento_test.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nuvento_test.data.model.Search
import com.nuvento_test.databinding.ItemMovieListBinding

class MovieListAdapter(
    private val onItemClicked: (( String,String,String, String, View?) -> Unit)
) :
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    var content: List<Search> = listOf()

    inner class ViewHolder(
        private val itemBinding: ItemMovieListBinding,
        private val onItemClicked: ((String,String,String, String, View?) -> Unit)
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Search) {
            itemBinding.data=item
            Glide.with(itemBinding.imgHeader)
                .load(item.Poster)
                .into(itemBinding.imgHeader)
            itemBinding.root.setOnClickListener {
                onItemClicked.let { onItemClick ->
                    onItemClick(item.imdbID, item.Title,item.Poster,item.Year,it)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return content.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemMovieListBinding =
            ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemMovieListBinding, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = content[position]
        holder.bind(item)
    }

    @JvmName("setContent1")
    fun setContent(list: List<Search>) {
        content = list
        notifyDataSetChanged()
    }

}