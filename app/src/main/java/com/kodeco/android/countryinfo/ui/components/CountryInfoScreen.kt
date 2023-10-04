package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.kodeco.android.countryinfo.model.Country
import com.kodeco.android.countryinfo.model.CountryFlags
import com.kodeco.android.countryinfo.model.CountryName
import com.kodeco.android.countryinfo.data.CountryService
import com.kodeco.android.countryinfo.data.CountryServiceStatus
import com.kodeco.android.countryinfo.data.countryServiceWorker
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException


// DONE: TODO fill out CountryInfoScreen
@Composable
fun CountryInfoScreen(
    navController: NavController?,
    countryService: CountryService
) {
    var countries by rememberSaveable { mutableStateOf(listOf<Country>()) }
    var countryServiceStatus: CountryServiceStatus by remember { mutableStateOf(CountryServiceStatus.Ready) }

    LaunchedEffect(Unit) {
        countryServiceStatus = countryServiceWorker(countryService)
    }
        when (val status = countryServiceStatus) {
            is CountryServiceStatus.Ready -> {}
            is CountryServiceStatus.Success -> {
                countries = status.response.body() ?: listOf()
                LazyColumn {
                    items(countries) { country ->
                        CountryInfoRow(country)
                    }
                }
            }

            is CountryServiceStatus.Error -> {
                println("Error: ${status.response.code()} ${status.response.message()}")
                navController?.navigate("error_screen")
            }

            is CountryServiceStatus.ServiceException -> {
                println(status.countryServiceException.message)
                if (status.countryServiceException is UnknownHostException || status.countryServiceException is SocketTimeoutException) {
                    // TODO No network connection
                }
                navController?.navigate("error_screen")
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
    CountryInfoScreen(null, countryService = mockService)
}
