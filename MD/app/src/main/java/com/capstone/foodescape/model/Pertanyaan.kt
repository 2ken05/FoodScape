package com.capstone.foodescape.model

data class Pertanyaan(
    val text: String,  // The question text
    val options: List<String>?,  // List of options for multiple-choice or single-choice
    val type: Int  // Type of question (single choice, multiple choice, or text input)
) {
    companion object {
        const val TYPE_SINGLE_CHOICE = 1
        const val TYPE_MULTIPLE_CHOICE = 2
        const val TYPE_TEXT_INPUT = 3
    }
}
