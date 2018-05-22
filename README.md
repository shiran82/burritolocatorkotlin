# burritolocator
The goal of the assignment is to build an app to find burrito places in your area. The app will use the user’s location and search the Google Places API to display them in a Recyclerview. After the user selects a place, the app will display it’s location with a Google Maps Mapview.

Please note:
1. Class EndlessRecyclerViewScrollListener was entirley taken from:
https://github.com/codepath/android_guides/wiki/Endless-Scrolling-with-AdapterViews-and-RecyclerView
2. According to the google maps api documentation: "next_page_token contains a token that can be used to return up to 20 additional results. A next_page_token will not be returned if there are no additional results to display. The maximum number of results that can be returned is 60. There is a short delay between when a next_page_token is issued, and when it will become valid.". To overcome this I added a retry option for rxJava and it will retry until that token is valid or up to 4 times
3. Most errors are handled in a generic way - depending on design a different error message/action would be executed
