package com.example.ekzhu.booklistingapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ekzhu on 12.07.2017.
 */

public class Book implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    private String mTitle;
    private String mAuthor;
    private String mImageUrl;
    private String mBookUrl;

    /**
     * Constructs a new {@link Book} object.
     *
     * @param title    is the title of the book
     * @param author   is the author of the book
     * @param imageUrl is the image URL of the book
     * @param bookUrl  is the URL of the book
     */
    public Book(String title, String author, String imageUrl, String bookUrl) {
        mTitle = title;
        mAuthor = author;
        mImageUrl = imageUrl;
        mBookUrl = bookUrl;
    }

    protected Book(Parcel in) {
        mTitle = in.readString();
        mAuthor = in.readString();
        mImageUrl = in.readString();
        mBookUrl = in.readString();
    }

    // Getters
    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getBookUrl() {
        return mBookUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mAuthor);
        dest.writeString(mImageUrl);
        dest.writeString(mBookUrl);
    }

}
