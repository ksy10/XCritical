package com.example.xcritical.instruments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.R
import java.util.*
import kotlin.collections.ArrayList


class AdapterCardInstrument(private val cardInstrument: ArrayList<CardInstrumentWithImage>, private val onClick: (Int) -> Unit)
    : RecyclerView.Adapter<AdapterCardInstrument.CardHolder>(), Filterable{

    private var filterList = ArrayList<CardInstrumentWithImage>()
    init {
        filterList = cardInstrument
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_instrument, parent,false)
        return CardHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val currentItem = filterList[position]

        holder.imageCountry.setImageResource(currentItem.imageCountry)
        holder.imageStar.setImageResource(currentItem.imageStar)
        holder.country.text =  currentItem.country
        holder.stick1.text =  currentItem.stick1
        holder.currency.text =  currentItem.currency
        holder.money2.text =  currentItem.money2
        holder.stick2.text =  currentItem.stick2
        holder.money1.text =  currentItem.money1
        holder.profit.text =  currentItem.profit
        holder.itemView.setOnClickListener { onClick(currentItem.id) }
    }

    override fun getItemCount(): Int = filterList.size

    class CardHolder(item: View) : RecyclerView.ViewHolder(item) {
            var imageCountry : ImageView = itemView.findViewById(R.id.imagecountry)
            var imageStar : ImageView = itemView.findViewById(R.id.imagestar)
            val country: TextView = itemView.findViewById(R.id.country)
            val stick1: TextView = itemView.findViewById(R.id.stick1)
            val currency: TextView = itemView.findViewById(R.id.currency)
            val money2: TextView = itemView.findViewById(R.id.money2)
            val stick2: TextView = itemView.findViewById(R.id.stick2)
            val money1: TextView = itemView.findViewById(R.id.money1)
            val profit: TextView = itemView.findViewById(R.id.profit)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filterList = cardInstrument
                } else {
                    val resultList = ArrayList<CardInstrumentWithImage>()
                    for (card in cardInstrument) {
                        if (card.country.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(card)
                        }
                    }
                    filterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results?.values as ArrayList<CardInstrumentWithImage>
                notifyDataSetChanged()
            }
        }
    }
}