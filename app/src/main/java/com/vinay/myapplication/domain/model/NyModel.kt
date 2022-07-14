package com.example.example

import com.google.gson.annotations.SerializedName
import com.vinay.myapplication.domain.model.Results


data class NyModel (

  @SerializedName("status"      ) var status     : String?            = null,
  @SerializedName("results"     ) var results    : ArrayList<Results> = arrayListOf()

)