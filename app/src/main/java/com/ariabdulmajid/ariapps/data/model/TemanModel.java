package com.ariabdulmajid.ariapps.data.model;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

@Entity(tableName = "Teman")
public class TemanModel implements Parcelable {

    @PrimaryKey
    @NonNull
    private String nim;

    private String nama, kelas, telp, email, ig;

    public TemanModel(String nama, String nim, String kelas, String telp, String email, String ig) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.telp = telp;
        this.email = email;
        this.ig = ig;
    }

    protected TemanModel(Parcel in) {
        nama = in.readString();
        nim = in.readString();
        kelas = in.readString();
        telp = in.readString();
        email = in.readString();
        ig = in.readString();
    }

    public static final Creator<TemanModel> CREATOR = new Creator<TemanModel>() {
        @Override
        public TemanModel createFromParcel(Parcel in) {
            return new TemanModel(in);
        }

        @Override
        public TemanModel[] newArray(int size) {
            return new TemanModel[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getKelas() {
        return kelas;
    }

    public String getTelp() {
        return telp;
    }

    public String getEmail() {
        return email;
    }

    public String getIg() {
        return ig;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.nim);
        dest.writeString(this.kelas);
        dest.writeString(this.telp);
        dest.writeString(this.email);
        dest.writeString(this.ig);
    }
}
