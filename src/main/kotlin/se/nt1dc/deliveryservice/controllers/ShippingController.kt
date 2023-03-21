package se.nt1dc.deliveryservice.controllers

import jakarta.validation.constraints.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import se.nt1dc.deliveryservice.dto.ItemShippingReq
import se.nt1dc.deliveryservice.service.ShippingCalculationService

@RestController
class ShippingController(var shippingCalculationService: ShippingCalculationService) {
    @PostMapping("/calculate")
    fun calculateShipping(@RequestBody @NotNull itemShippingReq: ItemShippingReq?): Double {
        println(itemShippingReq)
        return shippingCalculationService.calculateItemListShippingSum(itemShippingReq!!.items!!)
    }
}