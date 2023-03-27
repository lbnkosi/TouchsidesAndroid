package me.lbnkosi.touchsides

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import me.lbnkosi.touchsides.databinding.ActivityMainBinding
import me.lbnkosi.touchsides.domain.model.Result

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: TouchsidesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        configureObservables()
        binding.analyseButton.setOnClickListener {
            binding.progressBar.isVisible = true
            viewModel.fetchResults(binding.linkEditText.text.toString())
        }
    }

    private fun configureObservables() {
        viewModel.result.observe(this) {
            binding.progressBar.isVisible = false
            binding.results1.text = "Most frequent word: " + it?.result?.mostFrequentWord + " occurred " + it?.result?.mostFrequentWordCount + " times"
            binding.results2.text = "Most frequent 7 character word: " + it?.result?.mostFrequent7CharWord + " occurred " + it?.result?.mostFrequent7CharWordCount + " times"
            binding.results3.text = "Highest scoring word: " + it?.result?.highestScoringWord + " with a score of " + it?.result?.highestScoringWordScore
        }
    }

}