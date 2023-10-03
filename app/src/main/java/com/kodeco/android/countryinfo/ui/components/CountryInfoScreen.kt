package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.model.Country
import com.kodeco.android.countryinfo.model.CountryService
import kotlinx.coroutines.launch

// TODO fill out CountryInfoScreen
@Composable
fun CountryInfoScreen(countryService: CountryService) {
    var countries by rememberSaveable { mutableStateOf(listOf<Country>()) }

    LaunchedEffect(Unit) {
        launch {
            val response = countryService.getAllCountries()
            if (response.isSuccessful) {
                countries = response.body() ?: listOf()
            }
        }
    }

    LazyColumn {
        items(countries) { country ->
            CountryInfoRow(country)
        }
    }
}

// TODO fill out the preview.
@Preview
@Composable
fun CountryInfoScreenPreview() { }
