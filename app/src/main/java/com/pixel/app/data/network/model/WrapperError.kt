@file:Suppress("unused")

package com.pixel.app.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WrapperError : RuntimeException {

    @Expose
    @SerializedName("status_code")
    var statusCode: Long? = null

    @Expose
    @SerializedName("message")
    override var message: String? = null

    constructor(statusCode: Long?, message: String) {
        this.statusCode = statusCode
        this.message = message
    }

    constructor(statusCode: Long?) {
        this.statusCode = statusCode
    }
}
