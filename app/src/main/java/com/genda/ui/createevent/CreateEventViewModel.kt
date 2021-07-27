package com.genda.ui.createevent

import androidx.lifecycle.ViewModel
import com.genda.data.Event
import java.text.SimpleDateFormat
import java.util.*

class CreateEventViewModel : ViewModel() {

    val initialEventCalendar: Calendar = Calendar.getInstance()
    val finalEventCalendar: Calendar = Calendar.getInstance()
    var eventTitle: String = ""
    var eventDescription: String = ""
    lateinit var event: Event


    fun saveEvent(
        eventTitle: String,
        eventDescription: String,
    ) {
        event = Event(
            title = eventTitle,
            description = eventDescription,
            initialDate = initialEventCalendar.timeInMillis,
            finalDate = finalEventCalendar.timeInMillis,
            participants = mutableListOf()
        )

    }

    fun setInitialEventDate(dayOfMonth: Int, monthOfYear: Int, year: Int) {
        initialEventCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        initialEventCalendar.set(Calendar.MONTH, monthOfYear)
        initialEventCalendar.set(Calendar.YEAR, year)
    }

    fun getInitialEventTime(): Date {
        return initialEventCalendar.time
    }

    fun setInitialEventTime(hour: Int, minute: Int) {
        initialEventCalendar.set(Calendar.HOUR, hour)
        initialEventCalendar.set(Calendar.MINUTE, minute)
    }

    fun setFinalEventDate(dayOfMonth: Int, monthOfYear: Int, year: Int) {
        finalEventCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        finalEventCalendar.set(Calendar.MONTH, monthOfYear)
        finalEventCalendar.set(Calendar.YEAR, year)
    }

    fun getFinalEventTime(): Date {
        return finalEventCalendar.time
    }

    fun setFinalEventTime(hour: Int, minute: Int) {
        finalEventCalendar.set(Calendar.HOUR, hour)
        finalEventCalendar.set(Calendar.MINUTE, minute)
    }

    fun getFormattedEventDate(eventTimeDate: Date): String {
        return SimpleDateFormat("E, dd MMM yyyy").format(eventTimeDate).toString()
    }

    fun getFormattedEventTime(eventTimeDate: Date): String {
        var hour = ""
        var minute = ""

        hour = if (eventTimeDate.hours <= 9) {
            "0${eventTimeDate.hours}"
        } else {
            eventTimeDate.hours.toString()
        }

        minute = if (eventTimeDate.minutes <= 10) {
            "0${eventTimeDate.minutes}"
        } else {
            eventTimeDate.minutes.toString()
        }

        return "$hour:$minute"
    }

}