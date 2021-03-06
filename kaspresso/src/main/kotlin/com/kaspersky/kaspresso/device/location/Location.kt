package com.kaspersky.kaspresso.device.location

/**
 * The interface to work with device's location.
 */
interface Location {

    /**
     * Enables GPS on the device.
     *
     * Required Permissions: INTERNET
     */
    fun enableGps()

    /**
     * Disables GPS on the device.
     *
     * Required Permissions: INTERNET
     */
    fun disableGps()

    /**
     * Sets current location.
     *
     * Required Permissions: INTERNET
     */
    fun setLocation(lat: Double, lon: Double)
}
