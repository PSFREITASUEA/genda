package com.genda.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.genda.databinding.FragmentCreateEventBinding
import com.genda.ui.createevent.CreateEventViewModel
import java.util.*

class CreateEventFragment : Fragment() {

    private lateinit var binding: FragmentCreateEventBinding
    private val viewModel: CreateEventViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateEventBinding.inflate(inflater, container, false)

        setupClickListeners()
        setupViews()


        return binding.root
    }

    private fun setupViews() {
        binding.textViewEventInitialDate.text =
            viewModel.getFormattedEventDate(viewModel.getInitialEventTime())
        binding.textViewEventInitialTime.text =
            viewModel.getFormattedEventTime(viewModel.getInitialEventTime())

        binding.textViewEventFinalDate.text =
            viewModel.getFormattedEventDate(viewModel.getFinalEventTime())
        binding.textViewEventInitialTime.text =
            viewModel.getFormattedEventTime(viewModel.getFinalEventTime())
    }

    private fun setupClickListeners() {
        binding.textViewEventInitialDate.setOnClickListener {

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { view, year, monthOfYear, dayOfMonth ->


                    viewModel.setInitialEventDate(
                        dayOfMonth = dayOfMonth,
                        monthOfYear = monthOfYear,
                        year = year
                    )

                    binding.textViewEventInitialDate.text =
                        viewModel.getFormattedEventDate(viewModel.getInitialEventTime())
                },
                viewModel.initialEventCalendar.get(Calendar.YEAR),
                viewModel.initialEventCalendar.get(Calendar.MONTH),
                viewModel.initialEventCalendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }

        binding.textViewEventInitialTime.setOnClickListener {

            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { view, hour, minute ->
                    viewModel.setInitialEventTime(
                        hour = hour,
                        minute = minute
                    )
                    binding.textViewEventInitialTime.text =
                        viewModel.getFormattedEventTime(viewModel.getInitialEventTime())


                },
                viewModel.initialEventCalendar.get(Calendar.HOUR),
                viewModel.initialEventCalendar.get(Calendar.MINUTE),
                true

            )
            timePickerDialog.show()

        }

        binding.textViewEventFinalDate.setOnClickListener {

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { view, year, monthOfYear, dayOfMonth ->

                    viewModel.setFinalEventDate(
                        dayOfMonth = dayOfMonth,
                        monthOfYear = monthOfYear,
                        year = year
                    )

                    binding.textViewEventFinalDate.text =
                        viewModel.getFormattedEventDate(viewModel.getFinalEventTime())
                },
                viewModel.finalEventCalendar.get(Calendar.YEAR),
                viewModel.finalEventCalendar.get(Calendar.MONTH),
                viewModel.finalEventCalendar.get(Calendar.DAY_OF_MONTH),
            )
            datePickerDialog.show()
        }


        binding.textViewEventFinalTime.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { view, hour, minute ->
                    viewModel.setFinalEventTime(
                        hour = hour,
                        minute = minute
                    )
                    binding.textViewEventFinalTime.text =
                        viewModel.getFormattedEventTime(viewModel.getFinalEventTime())
                },
                viewModel.finalEventCalendar.get(Calendar.HOUR),
                viewModel.finalEventCalendar.get(Calendar.MINUTE),
                true

            )
            timePickerDialog.show()

        }
    }
}