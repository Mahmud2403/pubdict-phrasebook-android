package com.example.phrasebook.data.network_source

import com.example.phrasebook.data.network_source.models.CategoryDto
import com.example.phrasebook.data.network_source.models.PhraseDetailDto
import com.example.phrasebook.data.network_source.models.PhraseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhrasebookApi {
    @GET("phrasebooks/categories/")
    suspend fun getCategories(
        @Query("source_lang_iso") sourceLangIso: String = "eng",
        @Query("target_lang_iso") targetLangIso: String = "rus",
    ): CategoryDto

    @GET("phrases/")
    suspend fun getPhrases(
        @Query("category") categoryId: Int,
        @Query("source_lang_iso") sourceLangIso: String = "rus",
        @Query("target_lang_iso") targetLangIso: String = "lez",
    ): PhraseDto

    @GET("phrases/{id}/")
    suspend fun getDetailPhrase(
        @Path("id") id: Int
    ): PhraseDetailDto
}