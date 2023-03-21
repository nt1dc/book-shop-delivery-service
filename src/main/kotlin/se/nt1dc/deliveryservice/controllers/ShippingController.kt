package se.nt1dc.deliveryservice.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import se.nt1dc.deliveryservice.dto.ItemShippingRequest
import se.nt1dc.deliveryservice.service.ShippingCalculationService

@RestController
@RequestMapping()
class ShippingController(var shippingCalculationService: ShippingCalculationService) {
    @GetMapping("/calculate")
    fun calculateShipping(itemShippingList: List<ItemShippingRequest>): Double {
        return shippingCalculationService.calculateItemListShippingSum(itemShippingList)
    }
}