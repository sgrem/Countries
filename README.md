# Countries

Countries is an Android Jetpack-Compose based app that  fetches data from the REST Countries API
and displays information about different countries.

## Week 5

### Assignment

- Country Data Class:
    - Define a data class CountryName with the following property:
        - common as String
    - Define a data class CountryFlags with the following property:
        - png as String
    - Define a data class Country with the following properties:
        - name as CountryName
    - capital as List<String>?
    - population as Long
    - area as Double
    - flags as CountryFlags

- Networking with Retrofit:
    - Use Retrofit to create a service that makes GET requests to the REST Countries API to fetch country data.
    - The endpoint to use will be https://restcountries.com/v3.1/all. 
    - Note that clicking the link will open up a tab with the JSON response.  
        - For example, the common name for each country can be found under name.common.

- Coroutines for Asynchronous Processing:
    - Utilize Kotlin Coroutines to perform network requests asynchronously.
    - The quickest way to do this is to use a LaunchedEffect in your top-level compose element where you want to make the call.

- Display Country List:
    - Implement a Compose LazyColumn to display a list of countries. 
    - Each list item should show the country name and capital.

- Error Handling and Loading:
    - Handle network errors gracefully by displaying a user-friendly message when data cannot be fetched.

- Above and Beyond
    - See the Above and Beyond section of the rubric for ways to enhance the app including
        - handling network errors
        - showing a loading state and providing a details screen.



