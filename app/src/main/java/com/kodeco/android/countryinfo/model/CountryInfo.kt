package com.kodeco.android.countryinfo.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class CountryName(val common: String)

data class CountryFlags(val png: String)

@JsonClass(generateAdapter = true)
data class Country(
    val name: CountryName,
    @Json(name = "capital") val capital: List<String>?,
    val population: Long,
    val area: Double,
    val flags: CountryFlags,
) {
    @Json(name = "name") val commonName = name.common
    val flagsPng = flags.png
}
