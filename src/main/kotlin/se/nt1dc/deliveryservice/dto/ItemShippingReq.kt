package se.nt1dc.deliveryservice.dto

data class ItemShippingReq(
    var items: MutableList<ItemShippingDto>? = mutableListOf()
)