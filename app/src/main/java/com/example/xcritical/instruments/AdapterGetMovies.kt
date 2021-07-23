//package com.example.xcritical.instruments
//
//import android.annotation.SuppressLint
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
////import com.bumptech.glide.Glide
//import com.example.xcritical.R
////import com.example.xcritical.retrofit.Movies
//
//
//class AdapterGetMovies(private var movies: List<Movies>) : RecyclerView.Adapter<AdapterGetMovies.MoviesViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movies_item, parent,false)
//        return MoviesViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
//        holder.bind(movies[position])
//    }
//
//    override fun getItemCount(): Int {
//        return movies.size
//    }
//
//    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        val nameMovie: TextView = itemView.findViewById(R.id.name)
//        val realName: TextView = itemView.findViewById(R.id.realname)
//        val team: TextView = itemView.findViewById(R.id.team)
//        val firstAppearance: TextView = itemView.findViewById(R.id.firstappearance)
//        val createDby: TextView = itemView.findViewById(R.id.createdby)
//        val publisher: TextView = itemView.findViewById(R.id.publisher)
//        val imageMovie : ImageView = itemView.findViewById(R.id.imageurl)
//
//        @SuppressLint("CheckResult")
//        fun bind(movies: Movies) {
//            nameMovie.text = movies.name
//            realName.text = movies.realname
//            team.text = movies.team
//            firstAppearance.text = movies.firstappearance
//            createDby.text = movies.createdby
//            publisher.text = movies.publisher
//
//            fun bindImage(imageMovie: ImageView, imageurl: String) {
//                Glide.with(imageMovie)
//                    .load(imageurl)
//                    .into(imageMovie)
//
//            }
//            /*Glide.with(imageMovie)
//                .load(imageMovie)
//                .into(imageMovie)*/
//        }
//    }
//}