package com.figueroa.test1.ui.car.resumeCars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.figueroa.test1.R
import com.figueroa.test1.data.models.CarModel
import com.figueroa.test1.databinding.FragmentResumeCarsBinding
import com.figueroa.test1.ui.car.resumeCars.recyclerview.CarRecyclerViewAdapter
import com.figueroa.test1.ui.car.viewmodel.CarViewModel


class ResumeCars : Fragment() {

    // VIEW MODEL

    private val carViewModel: CarViewModel by activityViewModels {
        CarViewModel.Factory
    }

    // DATA BINDING

    private lateinit var binding: FragmentResumeCarsBinding

    // RECYCLER VIEW

    private lateinit var adapter: CarRecyclerViewAdapter

    // ON CREATE VIEW

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResumeCarsBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ON VIEW CREATED (SET RECYCLER VIEW)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.addCarButton.setOnClickListener{
            carViewModel.clearData()
            it.findNavController().navigate(R.id.action_resumeCars_to_newCarFragment)
        }
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = CarRecyclerViewAdapter { selectedCar ->
            showSelectedItem(selectedCar)
        }

        binding.recyclerView.adapter = adapter
        displayCars()
    }

    private fun displayCars() {
        adapter.setData(carViewModel.getCars())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(selectedCar: CarModel) {
        carViewModel.setSelectedCar(selectedCar)
        findNavController().navigate(R.id.action_resumeCars_to_carFragment)
    }
}