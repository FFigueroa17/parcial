package com.example.test2.ui.car.resumeCars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.R
import com.example.test2.data.model.CarModel
import com.example.test2.databinding.FragmentResumeCarBinding
import com.example.test2.ui.car.resumeCars.recyclerview.CarRecyclerAdapter
import com.example.test2.ui.car.viewmodel.CarViewModel


class ResumeCarFragment : Fragment() {

    // VIEW MODEL

    private val carViewModel: CarViewModel by activityViewModels{
        CarViewModel.Factory
    }

    // DATA BINDING

    private lateinit var binding: FragmentResumeCarBinding

    // ADAPTER

    private lateinit var adapter: CarRecyclerAdapter

    // ON CREATE VIEW

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResumeCarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.carAddButton.setOnClickListener {
            carViewModel.clearData()
            it.findNavController().navigate(R.id.action_resumeCarFragment_to_newCarFragment)
        }
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = CarRecyclerAdapter {selectedCar ->
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
        findNavController().navigate(R.id.action_resumeCarFragment_to_detailCarFragment)
    }

}