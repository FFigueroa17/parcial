package com.figueroa.test1.ui.car.newCar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.figueroa.test1.R
import com.figueroa.test1.databinding.FragmentNewCarBinding
import com.figueroa.test1.ui.car.viewmodel.CarViewModel

class NewCarFragment : Fragment() {

    // VIEW MODEL

    private val carViewModel: CarViewModel by activityViewModels {
        CarViewModel.Factory
    }

    // DATA BINDING

    private lateinit var binding: FragmentNewCarBinding

    // ON CREATE VIEW (SET DATA BINDING)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewCarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    // SET VIEW MODELL

    private fun setViewModel() {
        binding.viewmodel = carViewModel
    }

    // OBSERVE STATUS

    private fun observeStatus() {
        carViewModel.status.observe(viewLifecycleOwner){ status ->
            when{
                status.equals(CarViewModel.WRONG_INFORMATION) -> {
                    carViewModel.clearStatus()
                }
                status.equals(CarViewModel.CAR_CREATED) -> {
                    carViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}