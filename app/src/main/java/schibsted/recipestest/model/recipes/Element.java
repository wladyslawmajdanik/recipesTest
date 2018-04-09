package schibsted.recipestest.model.recipes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;

public class Element extends RealmObject implements Serializable, Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("hint")
    @Expose
    private String hint;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unitName")
    @Expose
    private String unitName;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("menyCategory")
    @Expose
    private MenyCategory menyCategory;
    public final static Creator<Element> CREATOR = new Creator<Element>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Element createFromParcel(Parcel in) {
            return new Element(in);
        }

        public Element[] newArray(int size) {
            return (new Element[size]);
        }

    };

    protected Element(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.amount = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.hint = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.unitName = ((String) in.readValue((String.class.getClassLoader())));
        this.symbol = ((String) in.readValue((String.class.getClassLoader())));
        this.menyCategory = ((MenyCategory) in.readValue((MenyCategory.class.getClassLoader())));
    }

    public Element() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public MenyCategory getMenyCategory() {
        return menyCategory;
    }

    public void setMenyCategory(MenyCategory menyCategory) {
        this.menyCategory = menyCategory;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(amount);
        dest.writeValue(hint);
        dest.writeValue(name);
        dest.writeValue(unitName);
        dest.writeValue(symbol);
        dest.writeValue(menyCategory);
    }

    public int describeContents() {
        return 0;
    }

}
