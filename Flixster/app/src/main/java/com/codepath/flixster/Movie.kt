package com.codepath.flixster

import com.google.gson.annotations.SerializedName

/**
 * The Model for storing a Movie from the Now Playing API
 *
 * SerializedName tags MUST match the JSON response for the
 * object to correctly parse with the gson library.
 */
class Movie {
    //TODO bookImageUrl
    @SerializedName("poster_path")
    var movieImageUrl: String? = null

    //TODO description
    @SerializedName("overview")
    var description: String? = null

    //TODO-STRETCH-GOALS amazonUrl
    @JvmField
    @SerializedName("title")
    var title: String? = null

    var liked: Boolean = false
}