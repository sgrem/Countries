package com.kodeco.android.countryinfo.data

import com.kodeco.android.countryinfo.model.Country
import com.kodeco.android.countryinfo.ui.components.MockCountryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


suspend fun countryServiceWorker(countryService: CountryService) : CountryServiceStatus {
    return withContext(Dispatchers.Main) {
        try {
            // preview only works in interactive mode when using Dispatchers.IO
            val response = if (countryService is MockCountryService) {
                countryService.getAllCountries()
            } else {
                withContext(Dispatchers.IO) {
                    countryService.getAllCountries()
                }
            }
            if (response.isSuccessful) {
                CountryServiceStatus.Success(response)
            } else {
                CountryServiceStatus.Error(response)
            }
        } catch (e: Exception) {
            // TODO("Not yet implemented")
            CountryServiceStatus.ServiceException(e)
        }
    }
}

    sealed class CountryServiceStatus {
        data object Ready: CountryServiceStatus()
        data class Success(val response: Response<List<Country>>) : CountryServiceStatus()
        data class Error(val response: Response<List<Country>>) : CountryServiceStatus()
        data class ServiceException(val countryServiceException: Exception) : CountryServiceStatus()
    }
