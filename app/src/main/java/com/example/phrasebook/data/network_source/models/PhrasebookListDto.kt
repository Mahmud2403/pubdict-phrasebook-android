package com.example.phrasebook.data.network_source.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class PhrasebookListDto(
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
        @SerialName("avatar")
        val avatar: String,
        @SerialName("id")
        val id: Int,
        @SerialName("is_published")
        val isPublished: Boolean,
        @SerialName("origin_language")
        val originLanguage: OriginLanguage,
        @SerialName("title")
        val title: String,
        @SerialName("translated_languages")
        val translatedLanguages: List<TranslatedLanguage>
    ) {
        @Keep
        @Serializable
        data class OriginLanguage(
            @SerialName("id")
            val id: Int,
            @SerialName("iso")
            val iso: String,
            @SerialName("title")
            val title: String
        )

        @Keep
        @Serializable
        data class TranslatedLanguage(
            @SerialName("id")
            val id: Int,
            @SerialName("iso")
            val iso: String,
            @SerialName("title")
            val title: String
        )
    }
}