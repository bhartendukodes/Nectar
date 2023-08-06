package com.bhartenduKodes.nectar.base


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.utils.lifecycle.LifecycleObserver
import com.bhartenduKodes.nectar.utils.lifecycle.autoCleaned
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Base for all fragments in the project
 */
private typealias FragmentViewBindingInflater<VB> = (
    inflater: LayoutInflater
) -> VB

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: FragmentViewBindingInflater<VB>,
) : Fragment() {

    val TAG = this.javaClass.simpleName

    private var _binding: VB by autoCleaned()
    val binding: VB get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(LifecycleObserver())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(layoutInflater)
        materialAlertDialogBuilder = MaterialAlertDialogBuilder(requireContext())
        return binding.root
    }

    abstract fun initView()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private lateinit var customAlertDialogView: View
    private lateinit var alertDialog: androidx.appcompat.app.AlertDialog
    private lateinit var materialAlertDialogBuilder: MaterialAlertDialogBuilder

    fun showLoading() {
        customAlertDialogView = LayoutInflater.from(requireContext())
            .inflate(R.layout.loading_view, null, false)

        alertDialog = materialAlertDialogBuilder.setView(customAlertDialogView)
            .setCancelable(false)
            .show()

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
    }

    fun hideLoading() {
        if (this::materialAlertDialogBuilder.isInitialized && this::alertDialog.isInitialized)
            alertDialog.dismiss()
    }


}
