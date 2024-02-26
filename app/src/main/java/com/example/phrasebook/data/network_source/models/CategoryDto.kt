package com.example.phrasebook.data.network_source.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class CategoryDto(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String?,
    @SerialName("previous")
    val previous: String?,
    @SerialName("results")
    val results: List<Result>
) {
    @Keep
    @Serializable
    data class Result(
        @SerialName("category_translations")
        val categoryTranslations: List<CategoryTranslation>,
        @SerialName("count_phrases")
        val countPhrases: Int,
        @SerialName("id")
        val id: Int,
        @SerialName("sort_order")
        val sortOrder: Int
    ) {
        @Keep
        @Serializable
        data class CategoryTranslation(
            @SerialName("id")
            val id: Int,
            @SerialName("language")
            val language: Language,
            @SerialName("name")
            val name: String
        ) {
            @Keep
            @Serializable
            data class Language(
                @SerialName("id")
                val id: Int,
                @SerialName("iso")
                val iso: String,
                @SerialName("title")
                val title: String
            )
        }
    }
}