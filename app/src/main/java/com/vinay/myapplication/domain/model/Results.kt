package com.vinay.myapplication.domain.model

import com.example.example.Media
import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("uri"            ) var uri           : String?           = null,
  @SerializedName("id"             ) var id            : Long?             = null,
  @SerializedName("published_date" ) var publishedDate : String?           = null,
  @SerializedName("byline"         ) var byline        : String?           = null,
  @SerializedName("source"         ) var source         : String?          = null,
  @SerializedName("title"          ) var title         : String?           = null,
  @SerializedName("abstract"       ) var abstract      : String?           = null,
  @SerializedName("media"          ) var media         : ArrayList<Media>  = arrayListOf(),
)