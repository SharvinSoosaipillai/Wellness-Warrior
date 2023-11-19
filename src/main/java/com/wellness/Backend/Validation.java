package com.wellness.Backend;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Validation {
    public boolean validatePassword(String username, String password,String confirmPassword, String connectionString){
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("WellnessWarrior-db");
            MongoCollection<Document> collection = database.getCollection("users");

            // Check if the username already exists
            if (doesUsernameExist(username, collection)) {
                return false; // Username already exists
            }

            // nothing is entered
            if (username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0) {
                return false;

            // mismatching passwords
            } else if (!password.equals(confirmPassword)) {
                return false;
            } else {
                return true; // Validation passed
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return false;
        }
    }    

    private boolean doesUsernameExist(String username, MongoCollection<Document> collection) {
        // Query to find a document with the given username
        long count = collection.countDocuments(Filters.eq("username", username));

        // If count is greater than 0, the username already exists
        return count > 0;
    }


}
