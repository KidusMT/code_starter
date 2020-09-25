
package com.pixel.app.data.network.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class Data {

    @SerializedName("id")
    @Expose
    private Long id;
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
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("primary_phone_number")
    @Expose
    private String primaryPhoneNumber;
    @SerializedName("alternative_telephone_number")
    @Expose
    private String alternativeTelephoneNumber;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("alternative_email_address")
    @Expose
    private String alternativeEmailAddress;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password_digest")
    @Expose
    private String passwordDigest;
    @SerializedName("reset_password_token")
    @Expose
    private Object resetPasswordToken;
    @SerializedName("reset_password_sent_at")
    @Expose
    private String resetPasswordSentAt;
    @SerializedName("secret_question")
    @Expose
    private String secretQuestion;
    @SerializedName("secret_question_answer")
    @Expose
    private String secretQuestionAnswer;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getAlternativeEmailAddress() {
        return alternativeEmailAddress;
    }

    public void setAlternativeEmailAddress(String alternativeEmailAddress) {
        this.alternativeEmailAddress = alternativeEmailAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }

    public Object getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(Object resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public String getResetPasswordSentAt() {
        return resetPasswordSentAt;
    }

    public void setResetPasswordSentAt(String resetPasswordSentAt) {
        this.resetPasswordSentAt = resetPasswordSentAt;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
