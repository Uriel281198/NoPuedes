package uaz.developer.com.nopuedes.Models;

/**
 * Created by Uriel on 06/09/2018.
 */

public class ImageModel {

    public String urlImage;
    public String name;

    public ImageModel(String urlImage, String name) {
        this.urlImage = urlImage;
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
