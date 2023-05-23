package com.example.test2.ui.car

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.test2.R
import com.example.test2.databinding.FragmentDetailCarBinding
import com.example.test2.ui.car.viewmodel.CarViewModel

class DetailCarFragment : Fragment() {

    // VIEW MODEL

    private val carViewModel: CarViewModel by activityViewModels {
        CarViewModel.Factory
    }

    // DATA BINDING

    private lateinit var binding: FragmentDetailCarBinding


    // ON CREATE VIEW (SETEAR EL DATA BINDING)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailCarBinding.inflate(inflater,container, false)
        return binding.root
    }

    // ON VIEW CREATED

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()

    }

    private fun setViewModel() {
        binding.viewmodel = carViewModel
    }

}