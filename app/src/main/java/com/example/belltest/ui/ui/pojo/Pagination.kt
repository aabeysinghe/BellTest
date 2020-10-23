package com.example.fragmentcommunicate.Pojo

data class Pagination(
    val alias: Any,
    val currentPage: Int,
    val dataType: String,
    val facets: List<Any>,
    val nextPage: Boolean,
    val previousPage: Boolean,
    val size: Int,
    val totalNumFound: Int,
    val totalPages: Int,
    val type: String
)