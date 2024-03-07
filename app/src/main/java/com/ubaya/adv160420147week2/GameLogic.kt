package com.ubaya.adv160420147week2

import kotlin.random.Random

class GameLogic {
    var num1: Int = 0
    var num2: Int = 0
    private var correctAnswer: Int = 0
    private var score: Int = 0

    fun generateRandomNumbers() {
        num1 = Random.nextInt(1, 100)
        num2 = Random.nextInt(1, 100)
        correctAnswer = num1 * num2
    }

    fun checkAnswer(userAnswer: Int): Boolean {
        if (userAnswer == correctAnswer) {
            score ++
            return true
        }
        return false
    }


    fun getQuestion(): String {
        return "What is $num1 * $num2?"
    }

    fun getScore(): Int {
        return score
    }
}
