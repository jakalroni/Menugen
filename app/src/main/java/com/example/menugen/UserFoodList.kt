package com.example.menugen

import android.content.Context
import android.content.SharedPreferences

object UserFoodList {
    private val MY_ACCOUNT : String = "account"

    fun setUserList(context: Context, input: String) {
        val prefs : SharedPreferences = context.getSharedPreferences(UserFoodList.MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString("MY_ID", input)
        editor.commit()
    }

    fun getUserList(context: Context): String {
        val prefs : SharedPreferences = context.getSharedPreferences(UserFoodList.MY_ACCOUNT, Context.MODE_PRIVATE)
        return prefs.getString("MY_ID", "").toString()
    }
}