package com.example.phrasebook.data.network_source.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class PhraseDto(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String?
    ,
    @SerialName("previous")
    val previous: String?,
    @SerialName("results")
    val results: List<Result>
) {
    @Keep
    @Serializable
    data class Result(
        @SerialName("category_id")
        val categoryId: Int,
        @SerialName("id")
        val id: Int,
        @SerialName("sort_order")
        val sortOrder: Int,
        @SerialName("translations")
        val translations: List<Translation>
    ) {
        @Keep
        @Serializable
        data class Translation(
            @SerialName("id")
            val id: Int,
            @SerialName("language")
            val language: Language,
            @SerialName("phonetics_en")
            val phoneticsEn: String,
            @SerialName("phonetics_ipa")
            val phoneticsIpa: String,
            @SerialName("translation")
            val translation: String
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