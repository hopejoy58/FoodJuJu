package com.example.foodjuju.ui.entry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.foodjuju.R

class EntryFragment : Fragment() {

        private lateinit var calendarViewModel: EntryViewModel

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            calendarViewModel =
                ViewModelProviders.of(this).get(EntryViewModel::class.java)
            val root = inflater.inflate(R.layout.fragment_calendar, container, false)
            val textView: TextView = root.findViewById(R.id.text_dashboard)
            calendarViewModel.text.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })
            return root
        }
    }