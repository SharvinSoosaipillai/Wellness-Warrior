// package com.wellness.Backend;

// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;
// import com.wellness.Constants.Constants;

// public class Get_Mongodb_info {
//     public String getUserName(){

//     }

//     private <Document> mongoDBCollection(){
//         try (MongoClient mongoClient = MongoClients.create(Constants.connectionString)) {
//             // Access the database and collection
//         MongoDatabase database = mongoClient.getDatabase("WellnessWarrior-db");
//         MongoCollection<Document> collection = database.getCollection("users");

//             // Check if the username already exists
        
//         } catch (Exception e) {
//             e.printStackTrace(); // Handle the exception according to your needs
//             return false;
//         }
//     }
// }
