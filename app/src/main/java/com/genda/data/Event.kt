package com.genda.data

data class Event(
    var title: String,
    var description: String,
    var initialDate: Long,
    var finalDate: Long,
    var participants: MutableList<Participant>
)