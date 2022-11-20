package mimika.maxim

import kotlin.math.roundToInt

object Time {
    private var hours: Int = 0
    private var minutes: Int = 0
    private var minRotation: Int = 0
    private var hoursRotation: Int = 0

    fun hoursInc(inc: Int = 1) {
        var tHours = hours
        tHours += inc
        if (tHours > 23)
            tHours -= 24
        hours = tHours
        rotationUpdate()
    }

    fun minutesInc(inc: Int = 1) {
        var tMinutes = minutes
        tMinutes += inc
        if (tMinutes > 59) {
            tMinutes -= 60
            hoursInc()
        }
        minutes = tMinutes
        rotationUpdate()
    }

    fun hoursDec(dec: Int = 1) {
        var tHours = hours
        tHours -= dec
        if (tHours < 0)
            tHours += 24
        hours = tHours
        rotationUpdate()
    }

    fun minutesDec(dec: Int = 1) {
        var tMinutes = minutes
        tMinutes -= dec
        if (tMinutes < 0) {
            tMinutes += 60
            hoursDec()
        }
        minutes = tMinutes
        rotationUpdate()
    }

    fun getHours() = hours.toString()

    fun getMin() = if (minutes < 10) "0$minutes" else minutes.toString()

    fun getMinRotation() = 180 + minRotation.toFloat()

    fun getHoursRotation() = 180 + hoursRotation.toFloat()

    private fun rotationUpdate() {
        minRotation()
        hourRotation()
    }

    private fun minRotation() {
        minRotation = 6 * minutes
    }

    private fun hourRotation() {
        hoursRotation = (30 * hours) + (0.5 * minutes).roundToInt()
    }
}