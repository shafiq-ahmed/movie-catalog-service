package io.javabrains.moviecatalogservice.entity;

import java.util.List;

public class RatingWrapper {
    private List<Rating> ratingList;

    public RatingWrapper() {
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
