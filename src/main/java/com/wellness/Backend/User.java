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

    protected int HeartRate,bloodLevel, humdity, temperature;


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

    public int getHeartRate() {
        Document userInfo = getUserInfoFromDatabase("HeartRate");
        return (userInfo != null) ? userInfo.getInteger("HeartRate", 0) : 0;
    }


    public int getTemperature() {
        Document userInfo = getUserInfoFromDatabase("Temperature");
        return (userInfo != null) ? userInfo.getInteger("Temperature", 0) : 0;
    }

    public int getHumidity() {
        Document userInfo = getUserInfoFromDatabase("Humidity");
        return (userInfo != null) ? userInfo.getInteger("Humidity", 0) : 0;
    }


    public int getBloodOxygen() {
        Document userInfo = getUserInfoFromDatabase("BloodOxygenConcentration");
        return (userInfo != null) ? userInfo.getInteger("BloodOxygenConcentration", 0) : 0;
    }


    public String getUsername(){
        return this.user;
    }


}
