package com.example.shiranpeer.burritolocator.screen.mainActivity

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

import com.example.shiranpeer.burritolocator.R
import com.example.shiranpeer.burritolocator.adapter.PlacesRecyclerViewAdapter
import com.example.shiranpeer.burritolocator.presenter.MainActivityPresenter
import com.example.shiranpeer.burritolocator.receiver.ConnectivityReceiver
import com.example.shiranpeer.burritolocator.repository.MainActivityDataRepository
import com.example.shiranpeer.burritolocator.screen.EndlessRecyclerViewScrollListener
import com.example.shiranpeer.burritolocator.util.NetworkUtil
import com.google.android.gms.location.FusedLocationProviderClient
import com.example.shiranpeer.burritolocator.databinding.ActivityMainBinding
import com.example.shiranpeer.burritolocator.model.Place
import com.google.android.gms.location.LocationServices

class MainActivity : Activity(), MainActivityMvpView, ConnectivityReceiver.ConnectivityReceiverListener {

    private var recyclerViewAdapter: PlacesRecyclerViewAdapter? = null
    private var presenter: MainActivityPresenter? = null
    private var fusedLocationClient: FusedLocationProviderClient? = null
    private var binding: ActivityMainBinding? = null

    private var lng: Double = 0.toDouble()
    private var lat: Double = 0.toDouble()
    private var pageToken: String? = null
    private var refreshRequired: Boolean = false
    private var connectivityReceiver: ConnectivityReceiver? = null

    override val isNetworkAvailable: Boolean
        get() = NetworkUtil.isNetworkAvailable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding!!.toolbar!!.toolbar.setTitle(R.string.app_name)

        refreshRequired = false

        binding!!.buttonFindMyBurrito.setOnClickListener { initialize() }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocationAndFindNearbyPlaces()
                } else {
                    closeApp()
                }
            }
        }
    }

    override fun showNearbyPlaces(places: List<com.example.shiranpeer.burritolocator.model.Place>, nextPageToken: String) {
        this.pageToken = nextPageToken
        recyclerViewAdapter = PlacesRecyclerViewAdapter(places as MutableList<Place>)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding!!.recyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                if (pageToken!!.isNotEmpty()) {
                    binding!!.progressBarLoader.visibility = View.VISIBLE
                    presenter!!.requestNearbyPlacesAdditionalResults(pageToken!!, getString(R.string.google_maps_key))
                }
            }
        })

        binding!!.recyclerView.layoutManager = layoutManager
        binding!!.recyclerView.adapter = recyclerViewAdapter
        binding!!.recyclerView.visibility = View.VISIBLE
    }

    override fun showNearbyAdditionalPlaces(places: List<com.example.shiranpeer.burritolocator.model.Place>, nextPageToken: String) {
        binding!!.progressBarLoader.visibility = View.INVISIBLE
        this.pageToken = nextPageToken
        recyclerViewAdapter!!.addItems(places)
    }

    override fun hideProgressBar() {
        binding!!.progressBar.visibility = View.GONE
    }

    override fun hideProgressBarLoader() {
        binding!!.progressBarLoader.visibility = View.INVISIBLE
    }

    override fun showProgressBar() {
        binding!!.progressBar.visibility = View.VISIBLE
    }

    override fun showGPSErrorMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.gps_error_message)
                .setPositiveButton(R.string.ok) { _, _ -> fetchLocationAndFindNearbyPlaces() }
                .setNegativeButton(R.string.cancel) { _, _ -> closeApp() }

        builder.setCancelable(false)
        builder.create()

        builder.show()
    }

    override fun showNetworkErrorMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.network_error_message)
                .setPositiveButton(R.string.ok) { _, _ -> fetchLocationAndFindNearbyPlaces() }
                .setNegativeButton(R.string.cancel) { _, _ -> closeApp() }

        builder.setCancelable(false)
        builder.create()

        builder.show()
    }

    override fun showNetworkErrorMessageForLoading() {
        refreshRequired = true
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.network_error_message_for_loading)
                .setPositiveButton(R.string.ok) { dialog, _ -> dialog.dismiss() }

        builder.setCancelable(false)
        builder.create()

        builder.show()
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (pageToken!!.isNotEmpty() && isConnected && refreshRequired) {
            Toast.makeText(this, getString(R.string.online_again), Toast.LENGTH_LONG).show()
            presenter!!.requestNearbyPlacesAdditionalResults(pageToken!!, getString(R.string.google_maps_key))
            pageToken = ""
            refreshRequired = false
        }
    }

    override fun onResume() {
        super.onResume()

        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)

        connectivityReceiver = ConnectivityReceiver()
        registerReceiver(connectivityReceiver, intentFilter)

        ConnectivityReceiver.connectivityReceiverListener = this
    }

    @SuppressLint("MissingPermission")
    private fun fetchLocationAndFindNearbyPlaces() {

        showProgressBar()
        val mvpView = this

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient!!.lastLocation.addOnSuccessListener(this) { location ->
            if (location != null) {
                lng = location.longitude
                lat = location.latitude

                presenter = MainActivityPresenter(MainActivityDataRepository(), mvpView)
                presenter!!.requestNearbyPlaces(TYPES, lat.toString() + "," + lng, BURRITO, DISTANCE,
                        getString(R.string.google_maps_key))
            } else {
                hideProgressBar()
                showGPSErrorMessage()
            }
        }
    }

    private fun initialize() {
        binding!!.buttonFindMyBurrito.visibility = View.GONE
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION)
        } else {
            fetchLocationAndFindNearbyPlaces()
        }
    }

    private fun closeApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity()
        } else {
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
        if (connectivityReceiver != null) {
            unregisterReceiver(connectivityReceiver)
        }
    }

    companion object {
        private const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1
        private const val TYPES = "restaurant, food"
        private const val BURRITO = "burrito"
        private const val DISTANCE = "distance"
    }
}
