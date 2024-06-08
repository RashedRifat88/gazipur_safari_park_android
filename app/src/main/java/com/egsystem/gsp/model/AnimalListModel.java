package com.egsystem.gsp.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AnimalListModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("result")
    @Expose
    private Result result;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }


    public class Animal {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("date_of_birth")
        @Expose
        private String dateOfBirth;
        @SerializedName("release_date_park")
        @Expose
        private String releaseDatePark;
        @SerializedName("alive")
        @Expose
        private String alive;
        @SerializedName("date_of_death")
        @Expose
        private String dateOfDeath;
        @SerializedName("images")
        @Expose
        private List<Object> images;
        @SerializedName("color")
        @Expose
        private String color;
        @SerializedName("weight")
        @Expose
        private String weight;
        @SerializedName("others")
        @Expose
        private String others;
        @SerializedName("species_id")
        @Expose
        private SpeciesId speciesId;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getReleaseDatePark() {
            return releaseDatePark;
        }

        public void setReleaseDatePark(String releaseDatePark) {
            this.releaseDatePark = releaseDatePark;
        }

        public String getAlive() {
            return alive;
        }

        public void setAlive(String alive) {
            this.alive = alive;
        }

        public String getDateOfDeath() {
            return dateOfDeath;
        }

        public void setDateOfDeath(String dateOfDeath) {
            this.dateOfDeath = dateOfDeath;
        }

        public List<Object> getImages() {
            return images;
        }

        public void setImages(List<Object> images) {
            this.images = images;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getOthers() {
            return others;
        }

        public void setOthers(String others) {
            this.others = others;
        }

        public SpeciesId getSpeciesId() {
            return speciesId;
        }

        public void setSpeciesId(SpeciesId speciesId) {
            this.speciesId = speciesId;
        }

    }


    public class Result {

        @SerializedName("animals")
        @Expose
        private List<Animal> animals;

        public List<Animal> getAnimals() {
            return animals;
        }

        public void setAnimals(List<Animal> animals) {
            this.animals = animals;
        }

    }

    public class SpeciesId {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}