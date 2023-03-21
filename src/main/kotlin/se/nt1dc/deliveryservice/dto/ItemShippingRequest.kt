package se.nt1dc.deliveryservice.dto

data class ItemShippingRequest(
    var from: LocationDto,
    var to: LocationDto,
    val length: Int,
    val width: Int,
    val height: Int,
    val weight: Int
)