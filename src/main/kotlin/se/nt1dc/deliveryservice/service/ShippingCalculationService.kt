package se.nt1dc.deliveryservice.service

import org.springframework.stereotype.Service
import se.nt1dc.deliveryservice.dto.ItemShippingDto
import kotlin.math.pow
import kotlin.math.sqrt

@Service
class ShippingCalculationService {
    fun calculateItemListShippingSum(items: List<ItemShippingDto>): Double {
        return items.stream().mapToDouble { calculateItemShipping(it) }.sum()
    }

    fun calculateItemShipping(itemShippingDto: ItemShippingDto): Double {
        val distance = calculateDistance(
            itemShippingDto.from.latitude,
            itemShippingDto.from.longitude,
            itemShippingDto.to.latitude,
            itemShippingDto.to.longitude
        )

        return Math.round((distance * itemShippingDto.weight * 0.322) * 100.0) / 100.0
    }

    fun calculateDistance(x1: Double, y1: Double, x2: Double, y2: Double): Double {
        return sqrt(
            (x1 - x2).toDouble().pow(2) + (y1 - y2).toDouble().pow(2)
        )
    }
}