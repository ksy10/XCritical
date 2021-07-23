package com.example.xcritical.instruments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.R


class AdapterCardInstrument(private val cardInstrument: ArrayList<CardInstrumentWithImage>, private val clickListener: (Int) -> Unit)
    : RecyclerView.Adapter<AdapterCardInstrument.CardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_instrument, parent,false)
        return CardHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(cardInstrument[position], clickListener)
    }

    override fun getItemCount(): Int {
        return cardInstrument.size
    }

    class CardHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(cardInstrument: CardInstrumentWithImage, clickListener: (Int) -> Unit) {
            val textView1: TextView = itemView.findViewById(R.id.text1)
            val textView2: TextView = itemView.findViewById(R.id.text2)
            val textView3: TextView = itemView.findViewById(R.id.text3)
            val textView4: TextView = itemView.findViewById(R.id.text4)
            val textView5: TextView = itemView.findViewById(R.id.text5)
            val textView6: TextView = itemView.findViewById(R.id.text6)
            val textView7: TextView = itemView.findViewById(R.id.text7)
            itemView.setOnClickListener { clickListener(cardInstrument.Id) }
        }
    }
}