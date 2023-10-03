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
import com.kodeco.android.countryinfo.model.CountryFlags
import com.kodeco.android.countryinfo.model.CountryName
import com.kodeco.android.countryinfo.model.CountryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

// TODO fill out CountryInfoScreen
@Composable
fun CountryInfoScreen(countryService: CountryService) {
    var countries by rememberSaveable { mutableStateOf(listOf<Country>()) }

    LaunchedEffect(Unit) {
        val response = withContext(Dispatchers.IO) {
            countryService.getAllCountries()
        }
        if (response.isSuccessful) {
            countries = response.body() ?: listOf()
        }
    }


    LazyColumn {
        items(countries) { country ->
            CountryInfoRow(country)
        }
    }
}

val mockCountries = listOf(
    Country(
        CountryName("USA"),
        listOf("Washington, D.C."),
        0,
        0.0,
        CountryFlags("No Flag")
    ),
    Country(
        CountryName("Canada"),
        listOf("Ottawa"),
        0,
        0.0,
        CountryFlags("No Flag")
    ),
    Country(
        CountryName("UK"),
        listOf("London"),
        0,
        0.0,
        CountryFlags("No Flag")
    ),
)

class MockCountryService : CountryService {
    override suspend fun getAllCountries(): Response<List<Country>> {
        return Response.success(mockCountries)
    }
}

// TODO fill out the preview.
@Preview
@Composable
fun CountryInfoScreenPreview() {
    val mockService = MockCountryService()
    CountryInfoScreen(countryService = mockService)
}
