package com.example.phrasebook.data.network_source.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep
import com.example.phrasebook.domain.models.PhraseDetail

@Keep
@Serializable
data class PhraseDetailDto(
    @SerialName("category_id")
    val categoryId: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("sort_order")
    val sortOrder: Int,
    @SerialName("translations")
    val translations: List<TranslationDto>
) {
    @Keep
    @Serializable
    data class TranslationDto(
        @SerialName("id")
        val id: Int,
        @SerialName("language")
        val language: LanguageDto,
        @SerialName("phonetics_en")
        val phoneticsEn: String?,
        @SerialName("phonetics_ipa")
        val phoneticsIpa: String?,
        @SerialName("translation")
        val translation: String
    ) {
        @Keep
        @Serializable
        data class LanguageDto(
            @SerialName("id")
            val id: Int,
            @SerialName("iso")
            val iso: String,
            @SerialName("title")
            val title: String
        )
    }
}

fun PhraseDetailDto.toDetail() = PhraseDetail(
    categoryId = categoryId,
    id = id,
    sortOrder = sortOrder,
    translations = translations.map { it.toTranslation() }
)

fun PhraseDetailDto.TranslationDto.toTranslation() = PhraseDetail.Translation(
    id = id,
    language = language.toLanguage(),
    phoneticsEn = phoneticsEn,
    phoneticsIpa = phoneticsIpa,
    translation = translation,
)

fun PhraseDetailDto.TranslationDto.LanguageDto.toLanguage() = PhraseDetail.Translation.Language(
    id = id,
    iso = iso,
    title = title,
)