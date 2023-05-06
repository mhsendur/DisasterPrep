package com.project.disasterprep.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "disasters")
public class Disaster {
    
    @Id
    private String id;
    
    private String disasterType;
    private String disasterCause;
    
    public Disaster() {
        //default constructor with no arguments
    }
    
    public Disaster(String disasterType, String disasterCause) {
        this.disasterType = disasterType;
        this.disasterCause = disasterCause;
    }
    
    public Disaster(String id, String disasterType, String disasterCause) {
        this.id = id;
        this.disasterType = disasterType;
        this.disasterCause = disasterCause;
    }

    //Getters and setters for each attribute
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public String getDisasterCause() {
        return disasterCause;
    }

    public void setDisasterCause(String disasterCause) {
        this.disasterCause = disasterCause;
    }
}

