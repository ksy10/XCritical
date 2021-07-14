package com.example.xcritical.instruments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.R

class AdapterInstrument(private val cardInstrument:List<CardInstrument>) : RecyclerView.Adapter<AdapterInstrument.CardHolder>() {

    class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val textView1: TextView = itemView.findViewById(R.id.text1)
            val textView2: TextView = itemView.findViewById(R.id.text2)
            val textView3: TextView = itemView.findViewById(R.id.text3)
            val textView4: TextView = itemView.findViewById(R.id.text4)
            val textView5: TextView = itemView.findViewById(R.id.text5)
            val textView6: TextView = itemView.findViewById(R.id.text6)
            val textView7: TextView = itemView.findViewById(R.id.text7)
//            val imageView1: ImageView = itemView.findViewById(R.id.image1Id)
//            val imageView2: ImageView = itemView.findViewById(R.id.image2Id)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_wallet, parent,false)
        return CardHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val currentItem = cardInstrument[position]
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
        holder.textView5.text = currentItem.text5
        holder.textView6.text = currentItem.text6
        holder.textView7.text = currentItem.text7

    }

    override fun getItemCount(): Int = cardInstrument.size
}