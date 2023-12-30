package com.wellness.Backend;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.wellness.Constants.Constants;
import static com.mongodb.client.model.Filters.eq;

public class User {


    protected String user;

    public User(String userName){
        this.user = userName;
    }

    //  user information variables 
    protected int heartRate,bloodLevel, humidity, temperature;


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
        this.humidity = userInfo.getInteger("Humidity", 0);
        return this.humidity;
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
    private void updateUserData(String field, int value) {
        try (MongoClient mongoClient = MongoClients.create(Constants.connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("WellnessWarrior-db");
            MongoCollection<Document> collection = database.getCollection("users");
            
            // Update the document in the collection
            collection.updateOne(eq("username", this.user), new Document("$set", new Document(field, value)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Set humidity level in the database
    public void setHumidity(int humidity) {
        updateUserData("Humidity", humidity);
        this.humidity = humidity; 
    }

    // Set temperature in the database
    public void setTemperature(int temperature) {
        updateUserData("Temperature", temperature);
        this.temperature = temperature; 
    }

    // Set heart rate in the database
    public void setHeartRate(int heartRate) {
        updateUserData("HeartRate", heartRate);
        this.heartRate = heartRate; 
    }

    // Set blood oxygen level in the database
    public void setBloodOxygen(int bloodOxygen) {
        updateUserData("BloodOxygenConcentration", bloodOxygen);
        this.bloodLevel = bloodOxygen; // Update the local variable if needed
    }




}
