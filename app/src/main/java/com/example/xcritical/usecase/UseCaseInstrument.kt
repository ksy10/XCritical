package com.example.xcritical.usecase

import com.example.xcritical.R
import com.example.xcritical.instruments.CardInstrument
import com.example.xcritical.instruments.CardInstrumentWithImage
import com.example.xcritical.repository.Repository
import javax.inject.Inject


class UseCaseInstrument @Inject constructor(private val repository: Repository) {

    private val listInstrument: ArrayList<CardInstrument> = repository.getList()
    private val listPresentation = ArrayList<CardInstrumentWithImage>()

    fun getList(): ArrayList<CardInstrumentWithImage> {
        return repletionImage(repository.getList())
    }

    private fun repletionImage(listInstrument: ArrayList<CardInstrument>) : ArrayList<CardInstrumentWithImage>{
        val listPresentation = ArrayList<CardInstrumentWithImage>()
        for (i in 0 until listInstrument.size) {
                listPresentation += CardInstrumentWithImage(
                    listInstrument[i].id,
                    listInstrument[i].country,
                    listInstrument[i].currency,
                    listInstrument[i].money2,
                    listInstrument[i].stick1,
                    listInstrument[i].money1,
                    listInstrument[i].stick2,
                    listInstrument[i].profit,
                    R.drawable.ic_default_icon_currency,
                    R.drawable.ic_star)
        }
        return listPresentation
    }
}