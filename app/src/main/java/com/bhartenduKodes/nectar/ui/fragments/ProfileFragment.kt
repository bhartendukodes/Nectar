package com.bhartenduKodes.nectar.ui.fragments

import android.content.Intent
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentProfileBinding
import com.bhartenduKodes.nectar.ui.activity.AuthenticationActivity
import com.bhartenduKodes.nectar.ui.adapters.SettingAdapter
import com.bhartenduKodes.nectar.ui.viewmodels.HomeViewModel
import com.bhartenduKodes.nectar.utils.extensions.click
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val settingAdapter by lazy {
        SettingAdapter()
    }

    private val settingViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java];
    }

    private val auth = FirebaseAuth.getInstance()


    override fun initView() {
        observer()
        getData()
        init()
        onClick()
    }

    private fun onClick() {
        binding.mbLogOut.click {
            AuthUI.getInstance()
                .signOut(requireContext())
                .addOnCompleteListener { // user is now signed out
                    val intent = Intent(requireContext(), AuthenticationActivity::class.java)
                    startActivity(intent)
                    ActivityCompat.finishAffinity(requireActivity())
                }
        }
    }

    private fun getData() {
        settingViewModel.settingData()

        auth.currentUser?.let {
            binding.apply {
                tvName.text = it.displayName
                tvEmail.text = it.email
                ivProfile.load(it.photoUrl)
            }
        }
    }

    private fun observer() {
        settingViewModel.settingMenu.observe(viewLifecycleOwner) { it ->
            binding.apply {
                settingAdapter.submitList(it)
            }
        }
    }


    private fun init() {
        binding.apply {
            rvSettingList.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = settingAdapter
            }
        }
    }

}