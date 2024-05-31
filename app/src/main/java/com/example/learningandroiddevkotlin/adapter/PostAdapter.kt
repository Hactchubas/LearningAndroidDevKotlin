package com.example.learningandroiddevkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroiddevkotlin.R
import com.example.learningandroiddevkotlin.model.PostModel

class PostAdapter(var postsList: Array<PostModel>, var context: Context):
    RecyclerView.Adapter<PostAdapter.Post>() {


    inner class Post(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        var timeFromPost = itemView.findViewById<TextView>(R.id.timeFromPost)
        var image = itemView.findViewById<ImageView>(R.id.postImage)
        var legend = itemView.findViewById<TextView>(R.id.legend)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Post {
        val cardView : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_adapter_layout, parent, false)

        return Post(cardView)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: Post, position: Int) {
        val currentItem = postsList[position]
        holder.name.text = currentItem.name
        holder.timeFromPost.text = currentItem.timeFromPost
        holder.image.setImageResource(currentItem.image)
        holder.legend.text = currentItem.legend
    }
}