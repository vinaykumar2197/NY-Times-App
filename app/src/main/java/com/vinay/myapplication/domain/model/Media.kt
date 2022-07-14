package com.example.example

import com.google.gson.annotations.SerializedName


data class Media (

  @SerializedName("type"                     ) var type                   : String?                   = null,
  @SerializedName("subtype"                  ) var subtype                : String?                   = null,
  @SerializedName("caption"                  ) var caption                : String?                   = null,
  @SerializedName("copyright"                ) var copyright              : String?                   = null,
  @SerializedName("approved_for_syndication" ) var approvedForSyndication : Int?                      = null,
  @SerializedName("media-metadata"           ) var mediaMetadata          : ArrayList<MediaMetadata>? = null

)