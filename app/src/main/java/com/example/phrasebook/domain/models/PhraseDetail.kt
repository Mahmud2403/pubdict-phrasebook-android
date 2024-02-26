package com.example.phrasebook.domain.models

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class PhraseDetail(
    val categoryId: Int,
    val id: Int,
    val sortOrder: Int,
    val translations: List<Translation>
) {
    data class Translation(
        val id: Int,
        val language: Language,
        val phoneticsEn: String?,
        val phoneticsIpa: String?,
        val translation: String
    ) {
        data class Language(
            val id: Int,
            val iso: String,
            val title: String
        )
    }

    companion object {
        val mockData = PhraseDetail(
            categoryId = 250,
            id = 49,
            sortOrder = 0,
            translations = listOf(
                Translation(
                    id = 1603,
                    translation = "Nasıl sipariş verebilirim?",
                    language = Translation.Language(
                        id = 10,
                        title = "Türkçe",
                        iso = "tur"
                    ),
                    phoneticsEn = null,
                    phoneticsIpa = null,
                ),
                Translation(
                    id = 1602,
                    translation = "Ин мал(метягь) гьикӀа заказ гун?",
                    language = Translation.Language(
                        id = 4,
                        title = "лезгинский",
                        iso = "lez"
                    ),
                    phoneticsEn = "in mal(metah) hiⱪa zakaz gun?",
                    phoneticsIpa = "in mal(metʰah) hik'a zakʰaz gun?",
                ),
                Translation(
                    id = 1601,
                    translation = "Как я могу сделать заказ?",
                    language = Translation.Language(
                        id = 10,
                        title = "русский",
                        iso = "rus"
                    ),
                    phoneticsEn = null,
                    phoneticsIpa = null,
                ),
                Translation(
                    id = 1600,
                    translation = "How can I place an order?",
                    language = Translation.Language(
                        id = 11,
                        title = "English",
                        iso = "eng"
                    ),
                    phoneticsEn = null,
                    phoneticsIpa = null,
                ),
            )
        )
    }
}