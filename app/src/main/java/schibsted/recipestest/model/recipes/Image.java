package schibsted.recipestest.model.recipes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;

public class Image extends RealmObject implements Serializable, Parcelable {

    @SerializedName("imboId")
    @Expose
    private String imboId;
    @SerializedName("url")
    @Expose
    private String url = "";
    public final static Creator<Image> CREATOR = new Creator<Image>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        public Image[] newArray(int size) {
            return (new Image[size]);
        }

    };


    protected Image(Parcel in) {
        this.imboId = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Image() {
    }

    public String getImboId() {
        return imboId;
    }

    public void setImboId(String imboId) {
        this.imboId = imboId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(imboId);
        dest.writeValue(url);
    }

    public int describeContents() {
        return 0;
    }

}
