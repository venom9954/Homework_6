package com.example.homework_6;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes implements Parcelable {
    private String noteName;
    private String noteDescription;
    private String noteDate;

    protected Notes(Parcel in) {
        noteName = in.readString();
        noteDescription = in.readString();
        noteDate = in.readString();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public Notes(String nameNote, String noteDescription, String noteDate) {
        this.noteName = nameNote;
        this.noteDescription = noteDescription;
        this.noteDate = noteDate;
    }

    public String getNameNote() {
        return noteName;
    }
    public void setNameNote(String nameNote) {
        this.noteName = nameNote;
    }
    public String getNoteDescription() {
        return noteDescription;
    }
    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }
    public String getNoteDate() {
        return noteDate;
    }
    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(noteName);
        parcel.writeString(noteDescription);
        parcel.writeString(noteDate);
    }
}
