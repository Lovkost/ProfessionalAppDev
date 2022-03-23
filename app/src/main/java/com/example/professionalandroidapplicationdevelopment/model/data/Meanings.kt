package com.example.professionalandroidapplicationdevelopment.model.data

import com.google.gson.annotations.SerializedName

class Meanings(
    @field:SerializedName("meaning")val translation:Translation,
    @field:SerializedName("imageUrl")val imageUrl:String
)