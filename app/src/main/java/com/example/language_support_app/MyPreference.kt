package com.example.language_support_app

import android.content.Context


const val PREFERENCE_NAME = "SharedPreferenceExample"
const val PREFERENCE_LANGUAGE = "Language"

class MyPreference(context: Context) {


    private val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun getLoginCount(): String? {
        return preference.getString(PREFERENCE_LANGUAGE, "en")
    }

    fun setLoginCount(Language: String) {
        val editor = preference.edit()
        editor.putString(PREFERENCE_LANGUAGE, Language)
        editor.apply()
    }

}