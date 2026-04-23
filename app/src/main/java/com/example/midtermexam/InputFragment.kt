package com.example.midtermexam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.midtermexam.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set default values as requested
        // Income: $3000
        // Expenses: 12 + 900 + 250 + 13 + 150 + 1000 + 200 = 2525
        binding.esLiEtIncome.setText("3000.0")
        binding.esLiEtExpenses.setText("2525.0")

        binding.esLiBtnSave.setOnClickListener {
            val income = binding.esLiEtIncome.text.toString().toDoubleOrNull() ?: 0.0
            val expenses = binding.esLiEtExpenses.text.toString().toDoubleOrNull() ?: 0.0

            setFragmentResult("requestKey", bundleOf("income" to income, "expenses" to expenses))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
