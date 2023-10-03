package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.model.Country

// TODO fill out CountryInfoRow
@Composable
fun CountryInfoRow(country: Country) {
    Column {
        Text(text = country.commonName)
        Text(text = country.capital?.get(0) ?: "No Capital")
    }
}

// TODO fill out the preview.
@Preview
@Composable
fun CountryInfoRowPreview() { }
