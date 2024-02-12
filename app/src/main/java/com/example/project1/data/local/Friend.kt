package com.example.project1.data.local

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Friend(
    @Expose
    @SerializedName("id")
    val id: Int?,
    @Expose
    @SerializedName("user_id")
    val userId: Int?,
    @Expose
    @SerializedName("nama")
    val name: String?,
    @Expose
    @SerializedName("sekolah_id")
    val schoolId: String?,
    @Expose
    @SerializedName("nomor_telepon")
    val phoneNumber: String?,
    @Expose
    @SerializedName("api_token")
    val apiToken: String?,
    @Expose
    @SerializedName("foto")
    val photo: String?,
    @Expose
    @SerializedName("nama_sekolah")
    val schoolName: String?,
    @Expose
    @SerializedName("device_token")
    val deviceToken: String?,
    @Expose
    @SerializedName("created_at")
    val createdAt: String?,
    @Expose
    @SerializedName("updated_at")
    val updatedAt: String?,
    @Expose
    @SerializedName("like_by_you")
    val likeByYou: Boolean?,
) : Parcelable