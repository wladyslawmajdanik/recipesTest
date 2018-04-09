package schibsted.recipestest.model.recipes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;

public class Step extends RealmObject implements Serializable, Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("description")
    @Expose
    private String description;

    public final static Creator<Step> CREATOR = new Creator<Step>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Step createFromParcel(Parcel in) {
            return new Step(in);
        }

        public Step[] newArray(int size) {
            return (new Step[size]);
        }

    };


    protected Step(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));

        this.description = ((String) in.readValue((String.class.getClassLoader())));

    }

    public Step() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(description);

    }

    public int describeContents() {
        return 0;
    }

}
