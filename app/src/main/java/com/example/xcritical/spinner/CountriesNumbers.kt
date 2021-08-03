package com.example.xcritical.spinner

import com.example.xcritical.R

data class CountriesNumbers(val image: Int, val country: String, val number: String) {

    object Countries {

        private val images = intArrayOf(
            R.drawable.ic_russia,
            R.drawable.ic_avstralia,
            R.drawable.ic_avstria,
            R.drawable.ic_azerbaizan,
            R.drawable.ic_alandskie,
            R.drawable.ic_albania,
            R.drawable.ic_alzur,
            R.drawable.ic_angalia,
            R.drawable.ic_russia,
            R.drawable.ic_avstralia,
            R.drawable.ic_avstria,
            R.drawable.ic_azerbaizan,
            R.drawable.ic_alandskie,
            R.drawable.ic_albania,
            R.drawable.ic_alzur,
            R.drawable.ic_angalia
        )

        private val countries = arrayOf(
            "Russia",
            "Астралия",
            "Австрия",
            "Азербайджан",
            "Аландские острова",
            "Албания",
            "Алжир",
            "Ангилья",
            "Russia",
            "Астралия",
            "Австрия",
            "Азербайджан",
            "Аландские острова",
            "Албания",
            "Алжир",
            "Ангилья"
        )

        private val numbers = arrayOf(
            "+7",
            "(+61)",
            "(+43)",
            "(+994)",
            "(+3581)",
            "(+355)",
            "(+213)",
            "(+1264)",
            "+7",
            "(+61)",
            "(+43)",
            "(+994)",
            "(+3581)",
            "(+355)",
            "(+213)",
            "(+1264)"
        )

        var list = ArrayList<CountriesNumbers>()
        get() {
            field = ArrayList()
            for (i in images.indices) {
                val imageId = images[i]
                val countryNames = countries[i]
                val numbersInCountries = numbers[i]

                val countriesNumbers = CountriesNumbers(imageId, countryNames, numbersInCountries)
                field.add(countriesNumbers)
            }
            return field
        }
    }
}