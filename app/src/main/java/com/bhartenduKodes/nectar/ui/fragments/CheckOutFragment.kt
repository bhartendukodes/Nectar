package com.bhartenduKodes.nectar.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.databinding.FragmentCheckOutBinding
import com.bhartenduKodes.nectar.utils.extensions.click
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CheckOutFragment : BottomSheetDialogFragment() {

    private val navArgs:CheckOutFragmentArgs by navArgs()

    private var binding: FragmentCheckOutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LinearLayoutCompat? {
        binding = FragmentCheckOutBinding.inflate(inflater, container, false)
        binding!!.root.setBackgroundResource(R.drawable.bg_bottom_card)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        val amount = navArgs.amount
        binding?.tvCost?.text = "$ ${amount}"

        binding?.rootPlaceOrder?.click {
            val action = CheckOutFragmentDirections.actionCheckOutFragmentToOrderAcceptedFragment()
            findNavController().navigate(action)
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.GONE
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialog
    }

}