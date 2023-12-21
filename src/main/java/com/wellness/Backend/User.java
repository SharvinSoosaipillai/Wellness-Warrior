package com.wellness.Backend;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.wellness.Constants.Constants;

public class User {


    protected String user;

    public User(String userName){
        this.user = userName;
    }

    //  user information variables 
    protected int heartRate,bloodLevel, humdity, temperature;


    // Gets the users info from the database
    private Document getUserInfoFromDatabase(String field) {
        try (MongoClient mongoClient = MongoClients.create(Constants.connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("WellnessWarrior-db");
            MongoCollection<Document> collection = database.getCollection("users");
            return collection.find(Filters.eq("username", this.user)).projection(Projections.include(field)).first();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Return heartRate
    public int getHeartRate() {
        Document userInfo = getUserInfoFromDatabase("HeartRate");
        this.heartRate = userInfo.getInteger("HeartRate", 0);
        return this.heartRate;
    }

    // return temperature 
    public int getTemperature() {
        Document userInfo = getUserInfoFromDatabase("Temperature");
        this.temperature = userInfo.getInteger("Temperature", 0);
        return this.temperature;
    }

    // return humidity level
    public int getHumidity() {
        Document userInfo = getUserInfoFromDatabase("Humidity");
        this.humdity = userInfo.getInteger("Humidity", 0);
        return this.humdity;
    }

    // return bloodoxygen level
    public int getBloodOxygen() {
        Document userInfo = getUserInfoFromDatabase("BloodOxygenConcentration");
        this.bloodLevel = userInfo.getInteger("BloodOxygenConcentration", 0);
        return this.bloodLevel;
    }

    // return username
    public String getUsername(){
        return this.user;
    }


}
