package com.example.drop;

public class World {
    private String name;
    private int imageId;

    public World(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return  imageId;
    }

}
