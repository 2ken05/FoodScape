package com.capstone.foodescape.model

import android.os.Parcel
import android.os.Parcelable

data class Category(
    val Nama_Tempat: String,
    val Kategori_Tempat: String,
    val Kategori_Makanan: String,
    val Alamat: String,
    val Review: String,
    val imageResId: Int = 0,
    val ImageUrl: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Nama_Tempat)
        parcel.writeString(Kategori_Tempat)
        parcel.writeString(Kategori_Makanan)
        parcel.writeString(Alamat)
        parcel.writeString(Review)
        parcel.writeInt(imageResId)
        parcel.writeString(ImageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }
}
