package com.example.test2.ui.car.newCar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.test2.R
import com.example.test2.databinding.FragmentNewCarBinding
import com.example.test2.ui.car.viewmodel.CarViewModel

class NewCarFragment : Fragment() {

    // VIEW MODEL

    private val carViewModel: CarViewModel by activityViewModels{
        CarViewModel.Factory
    }

    // DATA BINDING

    private lateinit var binding: FragmentNewCarBinding

    // ON CREATE VIEW ( CONFIG DATA BINDING )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentNewCarBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ON VIEW CREATED

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // SETEAR EL VIEW MODEL QUE USARA LA VISTA
        setViewModel()

        // OBSERVAR EL STATUS
        oberserveStatus()
    }

    private fun oberserveStatus() {
        carViewModel.statu.observe(viewLifecycleOwner){status ->

            when{
                // CUANDO LA INFORMACION ESTE ERRONEA
                status.equals(CarViewModel.WRONG_INFORMATION) -> {
                    carViewModel.clearStatus()
                }


                // CUANDO LA INFORMACION ESTE CORRECTA
                status.equals(CarViewModel.CAR_CREATED)->{
                    carViewModel.clearStatus()
                    findNavController().popBackStack()
                }

            }

        }
    }

    private fun setViewModel() {
        binding.viewmodel = carViewModel
    }
}