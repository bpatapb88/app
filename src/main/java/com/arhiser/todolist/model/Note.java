package com.arhiser.todolist.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name_item")
    public String name_item;

    @ColumnInfo(name = "timestamp")
    public long timestamp;

    @ColumnInfo(name = "done")
    public boolean done;

    @ColumnInfo(name = "style")
    public String style;

    @ColumnInfo(name = "image")
    public String image;

    public Note() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (uid != note.uid) return false;
        if (timestamp != note.timestamp) return false;
        if (done != note.done) return false;
        if (style != note.style) return false;
        if (image != note.image) return false;
        return name_item != null ? name_item.equals(note.name_item) : note.name_item == null;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (name_item != null ? name_item.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (done ? 1 : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    protected Note(Parcel in) {
        uid = in.readInt();
        name_item = in.readString();
        style = in.readString();
        image = in.readString();
        timestamp = in.readLong();
        done = in.readByte() != 0;


    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeString(name_item);
        dest.writeString(style);
        dest.writeString(image);
        dest.writeLong(timestamp);
        dest.writeByte((byte) (done ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
