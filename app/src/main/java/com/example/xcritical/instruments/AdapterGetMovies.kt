package com.example.xcritical.instruments

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.xcritical.R
import com.example.xcritical.retrofit.Movies
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList


class AdapterGetMovies(private var movies: MutableList<Movies>?) : RecyclerView.Adapter<AdapterGetMovies.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.movies_item, parent, false)
        return MoviesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies!![position])
        Picasso.get().load(movies!![position].imageurl).into(holder.imageMovie)
    }

    override fun getItemCount(): Int {
        return movies!!.size
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameMovie: TextView = itemView.findViewById(R.id.name)
        val realName: TextView = itemView.findViewById(R.id.realname)
        val team: TextView = itemView.findViewById(R.id.team)
        val firstAppearance: TextView = itemView.findViewById(R.id.firstappearance)
        val createDby: TextView = itemView.findViewById(R.id.createdby)
        val publisher: TextView = itemView.findViewById(R.id.publisher)
        val imageMovie: ImageView = itemView.findViewById(R.id.imageurl)

        @SuppressLint("CheckResult")
        fun bind(movies: Movies) {
            nameMovie.text = movies.name
            realName.text = movies.realname
            team.text = movies.team
            firstAppearance.text = movies.firstappearance
            createDby.text = movies.createdby
            publisher.text = movies.publisher
        }
    }

    fun updateFilteredList(listFilter: MutableList<Movies>?) {
        movies = listFilter
        notifyDataSetChanged()
    }
}
