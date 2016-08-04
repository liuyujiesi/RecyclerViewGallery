package com.example.recycleviewgallery;

/**
 * Created by Administrator on 2016/8/3.
 */
public class ImageBean {
    int imageId;
    String description;

    public ImageBean(int id, String des) {
        imageId = id;
        description = des;
    }

    @Override
    public String toString() {
        return "ImageBean{" +
                "imageId='" + imageId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
