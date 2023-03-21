package se.nt1dc.deliveryservice.service

import org.springframework.stereotype.Service
import se.nt1dc.deliveryservice.dto.ItemShippingRequest
import kotlin.math.pow
import kotlin.math.sqrt

@Service
class ShippingCalculationService {
    fun calculateItemListShippingSum(items: List<ItemShippingRequest>): Double {
        return items.stream().mapToDouble { calculateItemShipping(it) }.sum()
    }

    fun calculateItemShipping(itemShippingRequest: ItemShippingRequest): Double {
        val distance = calculateDistance(
            itemShippingRequest.from.latitude,
            itemShippingRequest.from.longitude,
            itemShippingRequest.to.latitude,
            itemShippingRequest.to.longitude
        )

        return distance * itemShippingRequest.weight * 0.322
    }

    fun calculateDistance(x1: Long, y1: Long, x2: Long, y2: Long): Double {
        return sqrt(
            (x1 - x2).toDouble().pow(2) + (y1 - y2).toDouble().pow(2)
        )
    }
}