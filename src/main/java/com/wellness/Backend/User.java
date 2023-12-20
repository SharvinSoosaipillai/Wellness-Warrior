package com.wellness.Backend;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.wellness.Constants.Constants;

public class User {


    protected String user;

    public User(String userName){
        this.user = userName;
    }

    protected int HeartRate,bloodLevel, humdity, temperature;

    public int getHeartRate(){
        try (MongoClient mongoClient = MongoClients.create(Constants.connectionString)) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("WellnessWarrior-db");
            MongoCollection<Document> collection = database.getCollection("users");
            Document userInfo = collection.find(Filters.eq("username", this.user)).first();

            
            return (userInfo.getInteger("HeartRate"));
        } catch (Exception e) {
            e.printStackTrace(); 
            return 0;
        }
    
    }


    public int getBloodOxygen(){
        try (MongoClient mongoClient = MongoClients.create(Constants.connectionString)) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("WellnessWarrior-db");
            MongoCollection<Document> collection = database.getCollection("users");
            Document userInfo = collection.find(Filters.eq("username", this.user)).first();



            return (userInfo.getInteger("BloodOxygenConcentration"));
        } catch (Exception e) {
            e.printStackTrace(); 
            return 0;
        }
    
    }


    public int getTemperature(){
        try (MongoClient mongoClient = MongoClients.create(Constants.connectionString)) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("WellnessWarrior-db");
            MongoCollection<Document> collection = database.getCollection("users");
            Document userInfo = collection.find(Filters.eq("username", this.user)).first();

            return (userInfo.getInteger("Temperature"));
        } catch (Exception e) {
            e.printStackTrace(); 
            return 0;
        }
    
    }


    public int getHumidity(){
        try (MongoClient mongoClient = MongoClients.create(Constants.connectionString)) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("WellnessWarrior-db");
            MongoCollection<Document> collection = database.getCollection("users");
            Document userInfo = collection.find(Filters.eq("username", this.user)).first();
            
            
            return (userInfo.getInteger("Humidity"));
        } catch (Exception e) {
            e.printStackTrace(); 
            return 0;
        }
    
    }

    public String getUsername(){
        return this.user;
    }


}
