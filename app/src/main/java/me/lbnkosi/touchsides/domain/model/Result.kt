package me.lbnkosi.touchsides.domain.model

data class Result(
    val mostFrequent7CharWordCount: Int = 0,
    val highestScoringWord: String = "",
    val mostFrequent7CharWord: String = "",
    val mostFrequentWord: String = "",
    val mostFrequentWordCount: Int = 0,
    val highestScoringWordScore: Int = 0,
    val link: String = "",
    val averageScore: Double = 0.0
)