package com.example.shiranpeer.burritolocator.screen

import android.app.AlertDialog
import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentActivity

import com.example.shiranpeer.burritolocator.Constant
import com.example.shiranpeer.burritolocator.R
import com.example.shiranpeer.burritolocator.databinding.MapLayoutBinding
import com.example.shiranpeer.burritolocator.presenter.PlacesOnMapActivityPresenter
import com.example.shiranpeer.burritolocator.util.NetworkUtil
import com.example.shiranpeer.burritolocator.util.StringUtil
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.shiranpeer.burritolocator.databinding.ActivityPlacesOnMapBinding

class PlacesOnMapActivity : FragmentActivity(), PlacesOnMapActivityMvpView, OnMapReadyCallback {

    private var binding: ActivityPlacesOnMapBinding? = null
    private var googleMap: GoogleMap? = null
    private var presenter: PlacesOnMapActivityPresenter? = null

    private var lng: Double = 0.toDouble()
    private var lat: Double = 0.toDouble()
    private var name: String? = null
    private var address: String? = null
    private var priceLevel: Int = 0

    override val isNetworkAvailable: Boolean
        get() = NetworkUtil.isNetworkAvailable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places_on_map)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_places_on_map)

        presenter = PlacesOnMapActivityPresenter(this)

        presenter!!.requestMaps()

    }

    override fun showMap() {
        val mapLayoutBinding = DataBindingUtil.inflate<MapLayoutBinding>(layoutInflater, R.layout.map_layout, binding!!.frameLayout, true)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val intent = intent

        if (intent != null) {
            lng = intent.getDoubleExtra(Constant.EXTRA_LNG, 0.0)
            lat = intent.getDoubleExtra(Constant.EXTRA_LAT, 0.0)
            name = intent.getStringExtra(Constant.EXTRA_NAME)
            address = intent.getStringExtra(Constant.EXTRA_ADDRESS)
            priceLevel = intent.getIntExtra(Constant.EXTRA_PRICE_LEVEL, 0)

            mapLayoutBinding.toolbar!!.toolbar.title = name
            mapLayoutBinding.textViewAddress.text = address
            mapLayoutBinding.textViewPrice.text = StringUtil.dollarBuilder(priceLevel)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        this.googleMap!!.uiSettings.isZoomControlsEnabled = true
        this.googleMap!!.setMinZoomPreference(MIN_ZOOM_PREFERENCE.toFloat())

        val placeLoc = LatLng(lat, lng)

        val markerOptions = MarkerOptions()
        markerOptions.position(placeLoc)
                .title(name)
                .snippet(address)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin))

        this.googleMap!!.addMarker(markerOptions)
        this.googleMap!!.moveCamera(CameraUpdateFactory.newLatLng(placeLoc))
    }

    override fun showNetworkErrorMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.network_error_message)
                .setPositiveButton(R.string.ok) { _, _ -> presenter!!.requestMaps() }
                .setNegativeButton(R.string.cancel) { _, _ -> closeApp() }

        builder.setCancelable(false)
        builder.create()

        builder.show()
    }

    private fun closeApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity()
        } else {
            finish()
        }
    }

    companion object {
        private const val MIN_ZOOM_PREFERENCE = 15
    }
}
