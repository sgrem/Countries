package com.kodeco.android.countryinfo.data

import com.kodeco.android.countryinfo.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryService {
    @GET("/v3.1/all")
    suspend fun getAllCountries(): Response<List<Country>>
}

