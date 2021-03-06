package com.openblocks.moduleinterface.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class is basically used to store a file's data with the name on it, nothing special.
 */
public class OpenBlocksFile implements Parcelable {
    public byte[] data;
    public String name;

    public OpenBlocksFile() { }

    public OpenBlocksFile(byte[] data, String name) {
        this.data = data;
        this.name = name;
    }

    protected OpenBlocksFile(Parcel in) {
        data = in.createByteArray();
        name = in.readString();
    }

    public static final Creator<OpenBlocksFile> CREATOR = new Creator<OpenBlocksFile>() {
        @Override
        public OpenBlocksFile createFromParcel(Parcel in) {
            return new OpenBlocksFile(in);
        }

        @Override
        public OpenBlocksFile[] newArray(int size) {
            return new OpenBlocksFile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(data);
        dest.writeString(name);
    }
}
