package com.somnus.toolbar.androidcollapsingtoolbarlayout.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @date： 2016/4/15. @FileName: @author: Somnus @Description:
 */
public class ParcelableBean implements Parcelable {
    public static final String KEY = "key";
    private String name;
    private int age;
    private boolean flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //写入接口函数，打包
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeByte(flag ? (byte) 1 : (byte) 0);
    }

    public ParcelableBean() {
    }

    protected ParcelableBean(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
        this.flag = in.readByte() != 0;
    }

    public static final Parcelable.Creator<ParcelableBean> CREATOR = new Parcelable.Creator<ParcelableBean>() {
        @Override
        public ParcelableBean createFromParcel(Parcel source) {
            return new ParcelableBean(source);
        }

        @Override
        public ParcelableBean[] newArray(int size) {
            return new ParcelableBean[size];
        }
    };
}
