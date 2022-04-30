package com.nuvento_test.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.nuvento_test.MainActivity
import com.nuvento_test.R


abstract class ViewBindingFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!
    protected abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(_binding == null){
            _binding = getViewBinding(inflater, container)
        }
        return binding.root
    }

    fun applicationContext(): Context = requireActivity().applicationContext

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    fun snackBarLayout(message: String) {
        val snack =
            Snackbar.make(requireActivity().window.decorView, message, Snackbar.LENGTH_LONG) // replace root view with your view Id
        snack.setAction(requireActivity().getText(R.string.settings)) {
            requireActivity().startActivity(Intent(Settings.ACTION_SETTINGS))
        }
        snack.show()
    }
}
