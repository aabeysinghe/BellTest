package com.example.fragmentcommunicate.Pojo

data class MovieSummary(
    val alias: Alias,
    val aliases: List<String>,
    val alternativeTitleLink: Any,
    val axisCollectionId: Int,
    val collectionType: String,
    val collectionTypeAttribute: CollectionTypeAttribute,
    val content: List<Content>,
    val displayCollectionCount: Boolean,
    val displayRotatorTitle: Boolean,
    val imageType: String,
    val itemCount: Int,
    val linearCollectionId: Any,
    val maxItems: Int,
    val mixedCollectionAlias: Any,
    val pagination: Pagination,
    val promoTeaserMobileImageType: Any,
    val style: String,
    val summary: Any,
    val title: String,
    val type: String,
    val upsellButtonCopy: Any,
    val upsellLogo: Any,
    val upsellPackage: Any,
    val upsellSummary: Any,
    val videoStreams: List<Any>
)