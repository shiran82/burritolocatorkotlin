package com.example.shiranpeer.burritolocator.screen.base

interface MvpView {

    val isNetworkAvailable: Boolean
    fun showNetworkErrorMessage()
}
