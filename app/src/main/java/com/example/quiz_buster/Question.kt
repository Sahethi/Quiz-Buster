package com.example.quiz_buster

class Question(
    val id: Int,
    val body: String,
    val hasImage: Boolean,
    val image: Int,
    val options: ArrayList<String>,
    val correctOption: Int
) {
}