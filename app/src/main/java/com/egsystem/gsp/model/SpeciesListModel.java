package com.egsystem.gsp.model;


import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SpeciesListModel {

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


    public class Result {

        @SerializedName("animal")
        @Expose
        private Object animal;
        @SerializedName("alive")
        @Expose
        private List<String> alive;
        @SerializedName("species")
        @Expose
        private List<Species> species;

        public Object getAnimal() {
            return animal;
        }

        public void setAnimal(Object animal) {
            this.animal = animal;
        }

        public List<String> getAlive() {
            return alive;
        }

        public void setAlive(List<String> alive) {
            this.alive = alive;
        }

        public List<Species> getSpecies() {
            return species;
        }

        public void setSpecies(List<Species> species) {
            this.species = species;
        }

    }


    public class Species {

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