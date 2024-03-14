package com.example.joyfin.model

import com.google.gson.annotations.SerializedName


data class UserData(
    @SerializedName("user_data") val userData: UserDataClass? = null,
    @SerializedName("smart_saver_transactions") val smartSaverTransactions: List<SmartSaverTransaction>? = null
)

data class SmartSaverTransaction(
    @SerializedName("amount") val amount: Long = 0,
    @SerializedName("type") val type: String = "",
    @SerializedName("narration") val narration: String = "",
    @SerializedName("date_created") val dateCreated: String = ""
)

data class UserDataClass(
    @SerializedName("id") val id: String = "",
    @SerializedName("email") val email: String = "",
    @SerializedName("first_name") val firstName: String = "",
    @SerializedName("last_name") val lastName: String = "",
    @SerializedName("tier") val tier: String = "",
    @SerializedName("phone_number") val phoneNumber: String = "",
    @SerializedName("smart_saver_balance") val smartSaverBalance: Long = 0,
    @SerializedName("green_saver_balance") val greenSaverBalance: Long = 0,
    @SerializedName("fixed_deposit_balance") val fixedDepositBalance: Long = 0,
    @SerializedName("email_verified") val emailVerified: String = "",
    @SerializedName("phone_verified") val phoneVerified: String = ""
)