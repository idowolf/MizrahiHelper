package com.richkidz.mizrahihelper;

public class BankObject {
    private String url;
    private String image;

    public BankObject(String url, String image, String description) {
        this.url = url;
        this.image = image;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

}
