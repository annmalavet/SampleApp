package com.malavet.sampleapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malavet.sampleapp.ApplicationGraph
import com.malavet.sampleapp.R
import com.malavet.sampleapp.databinding.HttpFragmentBinding
import com.malavet.sampleapp.ui.MainViewModel
import com.malavet.sampleapp.ui.adapters.PhotoListAdapter

class HttpFragment : Fragment() {

    private var viewModelAdapter: PhotoListAdapter? = null

    private val viewModel: MainViewModel by lazy {
        val activity = requireNotNull(this.activity) {
        }
        ViewModelProvider(this, ApplicationGraph.MainViewModelFactory(activity.application))
                .get(MainViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.repository.returnAll().observe(viewLifecycleOwner,
                { s ->
                    s?.apply {
                        viewModelAdapter?.photoList = s
                    }
                }
        )
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        val binding: HttpFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.http_fragment,
                container,
                false
        )

        viewModelAdapter = PhotoListAdapter()

        binding.viewModel = viewModel

        binding.setLifecycleOwner(viewLifecycleOwner)

        val recyclerView: RecyclerView = binding.root.findViewById<RecyclerView>(R.id.photo_list).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = viewModelAdapter

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

}







