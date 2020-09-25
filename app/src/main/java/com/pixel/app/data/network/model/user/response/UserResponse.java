
package com.pixel.app.data.network.model.user.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pixel.app.data.network.model.user.Data;

import java.util.List;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class UserResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<Data> datum;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Data> getDatum() {
        return datum;
    }

    public void setDatum(List<Data> datum) {
        this.datum = datum;
    }
}
