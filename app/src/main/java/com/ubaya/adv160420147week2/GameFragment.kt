package com.ubaya.adv160420147week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.adv160420147week2.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var gameLogic: GameLogic

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val playerName =
                GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's Turn"
        }

        binding.btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
        binding.btnTest.setOnClickListener {
            val action = GameFragmentDirections.actionGameFragmentTotestFragment()
            Navigation.findNavController(it).navigate(action)
        }

        gameLogic = GameLogic()
        displayQuestion()

        binding.btnSubmit.setOnClickListener {
            val userAnswer = binding.inputAnswer.text.toString().toIntOrNull()
            if (userAnswer != null) {
                val isCorrect = gameLogic.checkAnswer(userAnswer)
                if (isCorrect) {
                    gameLogic.generateRandomNumbers()
                    val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
                    val action = GameFragmentDirections.actionGameFragmentSelf(playerName)
                    Navigation.findNavController(it).navigate(action)
                    displayQuestion()
                } else {
                    val action = GameFragmentDirections.actionGameFragmentToResultFragment(playerScore = 0)
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }

    private fun displayQuestion() {
        gameLogic.generateRandomNumbers()
        binding.txtNumber1.text = gameLogic.num1.toString()
        binding.txtNumber2.text = gameLogic.num2.toString()
    }
}
