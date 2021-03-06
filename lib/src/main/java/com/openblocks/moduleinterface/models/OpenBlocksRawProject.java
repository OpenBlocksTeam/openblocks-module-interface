package com.openblocks.moduleinterface.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class OpenBlocksRawProject implements Parcelable {

    public String ID;
    public ArrayList<OpenBlocksFile> files;

    public OpenBlocksRawProject() { }

    public OpenBlocksRawProject(String ID, ArrayList<OpenBlocksFile> files) {
        this.ID = ID;
        this.files = files;
    }

    protected OpenBlocksRawProject(Parcel in) {
        ID = in.readString();
        files = in.createTypedArrayList(OpenBlocksFile.CREATOR);
    }

    public static final Creator<OpenBlocksRawProject> CREATOR = new Creator<OpenBlocksRawProject>() {
        @Override
        public OpenBlocksRawProject createFromParcel(Parcel in) {
            return new OpenBlocksRawProject(in);
        }

        @Override
        public OpenBlocksRawProject[] newArray(int size) {
            return new OpenBlocksRawProject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ID);
        dest.writeTypedList(files);
    }
}
