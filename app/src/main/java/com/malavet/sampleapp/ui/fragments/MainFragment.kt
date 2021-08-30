package com.malavet.sampleapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.malavet.sampleapp.R

class MainFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var b0: Button = requireView().findViewById<Button>(R.id.button0)!!
        b0.setOnClickListener { view ->
            view.findNavController().navigate(R.id.to_carou)
        }
        var b1: Button = requireView().findViewById<Button>(R.id.button1)!!
        b1.setOnClickListener { view ->
            view.findNavController().navigate(R.id.to_http)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }
}