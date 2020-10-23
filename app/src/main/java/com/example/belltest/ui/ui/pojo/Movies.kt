package com.example.fragmentcommunicate.Pojo

data class Movies(
    val alias: Alias,
    val appType: String,
    val corporateLinks: List<CorporateLink>,
    val dfpIUNumber: Any,
    val kidsAllowedScreens: List<Any>,
    val navigationLinks: List<NavigationLink>,
    val screens: List<Screen>,
    val title: String,
    val type: String
)