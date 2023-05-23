package com.figueroa.test1.ui.car

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.figueroa.test1.R
import com.figueroa.test1.databinding.FragmentCarBinding
import com.figueroa.test1.databinding.FragmentNewCarBinding
import com.figueroa.test1.ui.car.viewmodel.CarViewModel

class CarFragment : Fragment() {

    // VIEW MODEL

    private val carViewModel: CarViewModel by activityViewModels {
        CarViewModel.Factory
    }

    // DATA BINDING

    private lateinit var binding: FragmentCarBinding

    // ON CREATE VIEW ( SET DATA BINDING )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ON VIEW CREATED ( SET VIEW MODEL )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = carViewModel
    }

}