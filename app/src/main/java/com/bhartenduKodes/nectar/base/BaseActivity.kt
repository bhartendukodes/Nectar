package com.bhartenduKodes.nectar.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.utils.lifecycle.LifecycleObserver
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Base for all fragments in the project
 */
private typealias ActivityViewBindingInflater<VB> = (
    inflater: LayoutInflater
) -> VB

abstract class BaseActivity<VB : ViewBinding>(
    private val bindingInflater: ActivityViewBindingInflater<VB>,
) : AppCompatActivity() {

    val TAG = this.javaClass.simpleName

    private val _binding: VB by lazy {
        bindingInflater.invoke(layoutInflater)
    }

    val binding: VB get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(LifecycleObserver())
        setContentView(binding.root)
        materialAlertDialogBuilder = MaterialAlertDialogBuilder(this)
        initView()
    }

    abstract fun initView()

    private lateinit var customAlertDialogView: View
    private lateinit var alertDialog: androidx.appcompat.app.AlertDialog
    private lateinit var materialAlertDialogBuilder: MaterialAlertDialogBuilder

    fun showLoading() {
        customAlertDialogView = LayoutInflater.from(this)
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
