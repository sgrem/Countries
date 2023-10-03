package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.countryinfo.model.Country
import com.kodeco.android.countryinfo.model.CountryFlags
import com.kodeco.android.countryinfo.model.CountryName

// TODO fill out CountryInfoRow
@Composable
fun CountryInfoRow(country: Country) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Text(text = "Name: " + country.commonName)
        Text(text = "Capital: " + (country.capital?.get(0) ?: "No Capital"))
    }
}

val mockCountry = Country(
        CountryName("USA"),
        listOf("Washington, D.C."),
        0,
        0.0,
        CountryFlags("No Flag")
    )
// TODO fill out the preview.
@Preview
@Composable
fun CountryInfoRowPreview() {
    CountryInfoRow(country = mockCountry)
}
