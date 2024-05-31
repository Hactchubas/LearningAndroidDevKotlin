package com.example.learningandroiddevkotlin.adapter


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroiddevkotlin.R
import com.example.learningandroiddevkotlin.model.MovieModel


class MoviesAdapter(var moviesList: Array<MovieModel>, var context: Activity) :
    RecyclerView.Adapter<MoviesAdapter.Movie>() {

    inner class Movie(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.titleMovie)
        var year = itemView.findViewById<TextView>(R.id.yearMovie)
        var category = itemView.findViewById<TextView>(R.id.categoryMovie)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Movie {
        val movieView : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_adapter_layout, parent,false)

        return Movie(movieView)

    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: Movie, position: Int) {
        val currentItem = moviesList[position]
        holder.title.text = currentItem.title
        holder.year.text = currentItem.year.toString()
        holder.category.text = currentItem.category
    }


}