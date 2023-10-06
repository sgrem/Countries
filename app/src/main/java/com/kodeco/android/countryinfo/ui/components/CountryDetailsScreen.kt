package com.kodeco.android.countryinfo.ui.components

import android.net.Uri
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.kodeco.android.countryinfo.model.Country
import com.kodeco.android.countryinfo.model.CountryFlags
import com.kodeco.android.countryinfo.model.CountryName

// TODO fill in the CountryDetailsScreen. NOTE this is above-and-beyond the required
//  section of the homework assignment.
@Composable
fun CountryDetailsScreen(encodedJsonString: String?) {

// TODO next lines aren't finished
    val country = if (encodedJsonString == null)
        mockCountry
    else
        Gson().fromJson(Uri.decode(encodedJsonString), Country::class.java)


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Text(
            text = "Name: " + country.commonName,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            )
        Text(text = "Population: " + country.population,
            fontSize = 28.sp,)
        Text(text = "Area: " + country.area + " square miles",
            fontSize = 28.sp,)
    }
}

// TODO fill out the preview. NOTE this is above-and-beyond the required
////  section of the homework assignment.
private val mockCountry = Country(
    CountryName("USA"),
    listOf("Washington, D.C."),
    331_900_000,
    3_500_000.0,
    CountryFlags("No Flag")
)
@Preview
@Composable
fun CountryDetailsScreenPreview() {
    CountryDetailsScreen(null)
}
