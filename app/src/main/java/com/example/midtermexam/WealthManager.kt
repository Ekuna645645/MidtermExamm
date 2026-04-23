package com.example.midtermexam

class WealthManager {
    companion object {
        const val K = (9.0 + 10.0) / 14.0 // 1.357... which is approx 1.4 as per requirement

        fun calculateFinalSavings(income: Double, expenses: Double): Double {
            return (income - expenses) * K
        }
    }
}
