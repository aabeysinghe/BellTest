package com.example.fragmentcommunicate.Pojo

import com.google.gson.annotations.SerializedName

data class MovieCollection(
    val alias: Alias,
    val aliases: List<String>,
    val alternativeTitleLink: Any,
    val axisCollectionId: Any,
    val collectionType: String,
    val collectionTypeAttribute: CollectionTypeAttribute,
    val displayCollectionCount: Boolean,
    val displayRotatorTitle: Boolean,
    val imageType: String,
    val itemCount: Int,
    val linearCollectionId: Any,
    val maxItems: Int,
    val mixedCollectionAlias: Any,
    val promoTeaserMobileImageType: String,
    val style: String,
    val summary: Any,
    val title: String,
    val type: String,
    val upsellPackage: Any,
    val videoStreams: List<Any>
)