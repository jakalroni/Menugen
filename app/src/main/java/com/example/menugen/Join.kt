package com.example.menugen

data class Join(
    var identify: String,
    var password: String,
    var name: String,
    var email: String,
    var sex: Int=1,
    var age: Int=1,
    var height: Int=1,
    var weight: Int=1
)
