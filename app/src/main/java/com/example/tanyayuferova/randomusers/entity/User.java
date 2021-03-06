package com.example.tanyayuferova.randomusers.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.tanyayuferova.randomusers.utils.StringUtils;

/**
 * User entity
 * Created by Tanya Yuferova on 5/22/2017.
 */

public class User implements Parcelable {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String nationality;
    private String phone;
    private Location location = new Location();
    private String photoLarge;
    private String photoMedium;
    private String photoThumbnail;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Parcel in) {
        String[] data = new String[9];
        in.readStringArray(data);
        firstName = data[0];
        lastName = data[1];
        email = data[2];
        gender = data[3];
        nationality = data[4];
        phone = data[5];
        photoLarge = data[6];
        photoMedium = data[7];
        photoThumbnail = data[8];

        location = in.readParcelable(Location.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                firstName,
                lastName,
                email,
                gender,
                nationality,
                phone,
                photoLarge,
                photoMedium,
                photoThumbnail });
        dest.writeParcelable(location, flags);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFirstName() {
        return StringUtils.firstSymbolToUpperCase(firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return StringUtils.firstSymbolToUpperCase(lastName);
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

    public String getPhotoLarge() {
        return photoLarge;
    }

    public void setPhotoLarge(String photoLarge) {
        this.photoLarge = photoLarge;
    }

    public String getPhotoMedium() {
        return photoMedium;
    }

    public void setPhotoMedium(String photoMedium) {
        this.photoMedium = photoMedium;
    }

    public String getPhotoThumbnail() {
        return photoThumbnail;
    }

    public void setPhotoThumbnail(String photoThumbnail) {
        this.photoThumbnail = photoThumbnail;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
