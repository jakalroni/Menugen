package com.example.menugen

data class Login(
    var code: Int,
    var identify: String,
    var password: String,
    var allergy : List<String>
)