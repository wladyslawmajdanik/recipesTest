package schibsted.recipestest.model.recipes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Recipes extends RealmObject implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("basicPortionNumber")
    @Expose
    private Integer basicPortionNumber;
    @SerializedName("preparationTime")
    @Expose
    private Integer preparationTime;
    @SerializedName("numberOfComments")
    @Expose
    private Integer numberOfComments;
    @SerializedName("numberOfLikes")
    @Expose
    private Integer numberOfLikes;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("embedTitle")
    @Expose
    private String embedTitle;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("menyExported")
    @Expose
    private boolean menyExported;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("ingredients")
    @Expose
    private RealmList<Ingredient> ingredients = new RealmList<>();
    @SerializedName("tags")
    @Expose
    private RealmList<Tag> tags = new RealmList<>();
    @SerializedName("steps")
    @Expose
    private RealmList<Step> steps = new RealmList<>();
    @SerializedName("images")
    @Expose
    private RealmList<Image> images = new RealmList<>();
    @SerializedName("links")
    @Expose
    private String links;
    public final static Creator<Recipes> CREATOR = new Creator<Recipes>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Recipes createFromParcel(Parcel in) {
            return new Recipes(in);
        }

        public Recipes[] newArray(int size) {
            return (new Recipes[size]);
        }

    };


    protected Recipes(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.basicPortionNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.preparationTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.numberOfComments = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.numberOfLikes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.publishedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.embedTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.canonicalUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.menyExported = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        in.readList(this.ingredients, (Ingredient.class.getClassLoader()));
        in.readList(this.tags, (Tag.class.getClassLoader()));
        in.readList(this.steps, (Step.class.getClassLoader()));
        in.readList(this.images, (Image.class.getClassLoader()));
        this.links = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Recipes() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBasicPortionNumber() {
        return basicPortionNumber;
    }

    public void setBasicPortionNumber(Integer basicPortionNumber) {
        this.basicPortionNumber = basicPortionNumber;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public Integer getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Integer numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmbedTitle() {
        return embedTitle;
    }

    public void setEmbedTitle(String embedTitle) {
        this.embedTitle = embedTitle;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getMenyExported() {
        return menyExported;
    }

    public void setMenyExported(Boolean menyExported) {
        this.menyExported = menyExported;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RealmList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(RealmList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public RealmList<Tag> getTags() {
        return tags;
    }

    public void setTags(RealmList<Tag> tags) {
        this.tags = tags;
    }

    public RealmList<Step> getSteps() {
        return steps;
    }

    public void setSteps(RealmList<Step> steps) {
        this.steps = steps;
    }

    public RealmList<Image> getImages() {
        return images;
    }

    public void setImages(RealmList<Image> images) {
        this.images = images;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(basicPortionNumber);
        dest.writeValue(preparationTime);
        dest.writeValue(numberOfComments);
        dest.writeValue(numberOfLikes);
        dest.writeValue(publishedAt);
        dest.writeValue(status);
        dest.writeValue(updatedAt);
        dest.writeValue(embedTitle);
        dest.writeValue(canonicalUrl);
        dest.writeValue(id);
        dest.writeValue(menyExported);
        dest.writeValue(user);
        dest.writeList(ingredients);
        dest.writeList(tags);
        dest.writeList(steps);
        dest.writeList(images);
        dest.writeValue(links);
    }

    public int describeContents() {
        return 0;
    }

}
