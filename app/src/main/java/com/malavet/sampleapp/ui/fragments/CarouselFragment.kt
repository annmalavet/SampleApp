package com.malavet.sampleapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.malavet.sampleapp.ApplicationGraph
import com.malavet.sampleapp.R
import com.malavet.sampleapp.databinding.CarouselFragmentBinding
import com.malavet.sampleapp.ui.adapters.CarouselAdapter
import com.malavet.sampleapp.ui.MainViewModel

class CarouselFragment : Fragment() {

    private var cModelAdapter: CarouselAdapter? = null
    private var _binding: CarouselFragmentBinding? = null

    private val viewModel: MainViewModel by lazy {
        val activity = requireNotNull(this.activity) {
        }
        ViewModelProvider(this, ApplicationGraph.MainViewModelFactory(activity.application))
            .get(MainViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        val binding: CarouselFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.carousel_fragment,
                container,
                false
        )

        cModelAdapter = CarouselAdapter()
        val car: Carousel = binding.root.findViewById<Carousel>(R.id.carouseloo).apply {
           setAdapter(cModelAdapter)
        }
        _binding = CarouselFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}







