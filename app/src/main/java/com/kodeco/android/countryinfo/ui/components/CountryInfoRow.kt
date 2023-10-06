package com.kodeco.android.countryinfo.ui.components

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.google.gson.Gson
import com.kodeco.android.countryinfo.model.Country
import com.kodeco.android.countryinfo.model.CountryFlags
import com.kodeco.android.countryinfo.model.CountryName

// TODO fill out CountryInfoRow
@Composable
fun CountryInfoRow(
    country: Country,
    navController: NavController?,
    ) {
    val jsonString: String = Gson().toJson(country)
    val encodedJsonString = Uri.encode(jsonString)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                Log.d("Clickable", "Item clicked")
                navController?.navigate("country_details_screen/$encodedJsonString")
            }
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Text(text = "Name: " + country.commonName)
        Text(text = "Capital: " + (country.capital?.get(0) ?: "No Capital"))
    }
}

private val mockCountry = Country(
        CountryName("USA"),
        listOf("Washington, D.C."),
        331_900_000,
        3_500_000.0,
        CountryFlags("No Flag")
    )
// TODO fill out the preview.
@Preview
@Composable
fun CountryInfoRowPreview() {
    CountryInfoRow(
        country = mockCountry,
        null,
        )
}
