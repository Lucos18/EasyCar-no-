package com.example.easycar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.easycar.BaseApplication
import com.example.easycar.databinding.FragmentCarListBinding
import com.example.easycar.ui.adapter.CarListAdapter
import com.example.easycar.ui.viewmodel.CarViewModel
import com.example.easycar.ui.viewmodel.CarViewModelFactory

class CarListFragment : Fragment() {

    private val viewModel: CarViewModel by activityViewModels {
        CarViewModelFactory(
            (activity?.application as BaseApplication).database.CarDao()
        )
    }
    private var _binding: FragmentCarListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCarListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO check if carlistadapter crashes everything
        /*
        val adapter = CarListAdapter { car ->
            val action = CarListFragment
                .actionForageableListFragmentToForageableDetailFragment(car.id)
            findNavController().navigate(action)
        }
        */
        /*
        viewModel.allCars.observe(this.viewLifecycleOwner) { carSelected ->
            carSelected.let {
                adapter.submitList(it)
            }
        }
        binding.apply {
            carRecyclerViewList.adapter = adapter
        }
        */
    }
}