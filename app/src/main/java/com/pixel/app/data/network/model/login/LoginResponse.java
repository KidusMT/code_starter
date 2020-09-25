
package com.pixel.app.data.network.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class LoginResponse {

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("jwt")
    @Expose
    private String jwt;

    @SerializedName("errors")
    @Expose
    private List<String> errors = null;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
