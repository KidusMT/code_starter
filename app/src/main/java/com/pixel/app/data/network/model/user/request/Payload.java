
package com.pixel.app.data.network.model.user.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class Payload {

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private String middleName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("alternative_email_address")
    @Expose
    private String alternativeEmailAddress;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("primary_phone_number")
    @Expose
    private String primaryPhoneNumber;
    @SerializedName("alternative_telephone_number")
    @Expose
    private String alternativeTelephoneNumber;
    @SerializedName("photo")
    @Expose
    private String photo;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("secret_question")
    @Expose
    private String secretQuestion;

    @SerializedName("secret_question_answer")
    @Expose
    private String secretQuestionAnswer;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretQuestionAnswer() {
        return secretQuestionAnswer;
    }

    public void setSecretQuestionAnswer(String secretQuestionAnswer) {
        this.secretQuestionAnswer = secretQuestionAnswer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAlternativeEmailAddress() {
        return alternativeEmailAddress;
    }

    public void setAlternativeEmailAddress(String alternativeEmailAddress) {
        this.alternativeEmailAddress = alternativeEmailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    public String getAlternativeTelephoneNumber() {
        return alternativeTelephoneNumber;
    }

    public void setAlternativeTelephoneNumber(String alternativeTelephoneNumber) {
        this.alternativeTelephoneNumber = alternativeTelephoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
