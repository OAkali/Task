package com.example.task.data.local

import android.content.Context

class Pref(private val context: Context) {
    private  val pref=context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun onShowed():Boolean{
        return pref.getBoolean(SHOWED_KEY,false)
    }
    fun onBoardingShowed(){
        pref.edit().putBoolean(SHOWED_KEY,true).apply()
    }
    fun saveName(name:String){
        pref.edit().putString(NAME_KEY,name).apply()
    }
    fun getName():String?{
        return  pref.getString(NAME_KEY,"")
    }
    companion object {
        const val PREF_NAME="name"
        const val NAME_KEY="NAME"
        const val SHOWED_KEY="key"
    }
}