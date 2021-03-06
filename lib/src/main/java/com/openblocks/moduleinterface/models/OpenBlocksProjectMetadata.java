package com.openblocks.moduleinterface.models;

import android.os.Parcel;
import android.os.Parcelable;

public class OpenBlocksProjectMetadata implements Parcelable {
    String name;
    String package_name;
    String version_name;
    int version_code;

    public OpenBlocksProjectMetadata(String name, String package_name, String version_name, int version_code) {
        this.name = name;
        this.package_name = package_name;
        this.version_name = version_name;
        this.version_code = version_code;
    }

    protected OpenBlocksProjectMetadata(Parcel in) {
        name = in.readString();
        package_name = in.readString();
        version_name = in.readString();
        version_code = in.readInt();
    }

    public static final Creator<OpenBlocksProjectMetadata> CREATOR = new Creator<OpenBlocksProjectMetadata>() {
        @Override
        public OpenBlocksProjectMetadata createFromParcel(Parcel in) {
            return new OpenBlocksProjectMetadata(in);
        }

        @Override
        public OpenBlocksProjectMetadata[] newArray(int size) {
            return new OpenBlocksProjectMetadata[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return package_name;
    }

    public String getVersionName() {
        return version_name;
    }

    public int getVersionCode() {
        return version_code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(package_name);
        dest.writeString(version_name);
        dest.writeInt(version_code);
    }
}
