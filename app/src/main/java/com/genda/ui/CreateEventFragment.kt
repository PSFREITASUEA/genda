package com.genda.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.genda.databinding.FragmentCreateEventBinding
import java.text.SimpleDateFormat
import java.util.*

class CreateEventFragment : Fragment() {

    private lateinit var binding: FragmentCreateEventBinding

    val initialCalendar = Calendar.getInstance()
    val initialDay = initialCalendar.get(Calendar.DAY_OF_MONTH)
    val initialMonth = initialCalendar.get(Calendar.MONTH)
    val initialYear = initialCalendar.get(Calendar.YEAR)


    val finalCalendar = Calendar.getInstance()
    val finalDay = finalCalendar.get(Calendar.DAY_OF_MONTH)
    val finalMonth = finalCalendar.get(Calendar.MONTH)
    val finalYear = finalCalendar.get(Calendar.YEAR)

    var time: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateEventBinding.inflate(inflater, container, false)

        setupClickListeners()


        return binding.root
    }

    private fun setupClickListeners() {
        binding.textViewEventInitialDate.setOnClickListener {

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { view, year, monthOfYear, dayOfMonth ->

                    time += "$dayOfMonth/$monthOfYear/$year"

                    initialCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    initialCalendar.set(Calendar.MONTH, monthOfYear)
                    initialCalendar.set(Calendar.YEAR, year)

                    binding.textViewEventInitialDate.text =
                        SimpleDateFormat("E, dd MMM yyyy").format(initialCalendar.time).toString()
                },
                initialYear,
                initialMonth,
                initialDay,
            )
            datePickerDialog.show()
        }

        binding.textViewEventInitialTime.setOnClickListener {

            val hour = initialCalendar.get(Calendar.HOUR)
            val minute = initialCalendar.get(Calendar.MINUTE)


            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { view, hour, minute ->
                    time += " - $hour:$minute"
                    binding.textViewEventInitialTime.text = "$hour:$minute"
                    initialCalendar.set(Calendar.HOUR, hour)
                    initialCalendar.set(Calendar.MINUTE, minute)
                },
                hour,
                minute,
                true

            )
            timePickerDialog.show()

        }

        binding.textViewEventFinalDate.setOnClickListener {

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { view, year, monthOfYear, dayOfMonth ->

                    time += "$dayOfMonth/$monthOfYear/$year"

                    finalCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    finalCalendar.set(Calendar.MONTH, monthOfYear)
                    finalCalendar.set(Calendar.YEAR, year)


                    binding.textViewEventFinalDate.text =
                        SimpleDateFormat("E, dd MMM yyyy").format(finalCalendar.time).toString()
                },
                finalYear,
                finalMonth,
                finalDay,
            )
            datePickerDialog.show()
        }


        binding.textViewEventFinalTime.setOnClickListener {

            val hour = finalCalendar.get(Calendar.HOUR)
            val minute = finalCalendar.get(Calendar.MINUTE)


            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { view, hour, minute ->
                    binding.textViewEventInitialTime.text = "$hour:$minute"
                    finalCalendar.set(Calendar.HOUR, hour)
                    finalCalendar.set(Calendar.MINUTE, minute)
                },
                hour,
                minute,
                true

            )
            timePickerDialog.show()

        }
    }
}