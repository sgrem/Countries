package com.kodeco.android.countryinfo.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryName(val common: String)

@JsonClass(generateAdapter = true)
data class CountryFlags(val png: String)


@JsonClass(generateAdapter = true)
data class Country(
    val name: CountryName,
    val capital: List<String>?,

    val population: Long,
    val area: Double,
    val flags: CountryFlags,
) {

    val commonName = name.common

    val flagsPng = flags.png
}
