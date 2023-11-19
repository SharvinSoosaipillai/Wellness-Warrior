package com.wellness;


import com.wellness.GUIS.Login;


import javax.swing.SwingUtilities;
/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override

            public void run(){
                Login main = new Login();
            }

        });
        

        // All MongoDB Stuff is over here

        // Connect to the MongoDB Atlas cluster
        // try (MongoClient mongoClient = MongoClients.create(connectionString)) {
        //     // Access the database and collection
        //     MongoDatabase database = mongoClient.getDatabase("WellnessWarrior-db");
        //     MongoCollection<Document> collection = database.getCollection("users");

        //     // Create a document to insert
        //     Document document = new Document("name", "bigmantheboidudas")
        //             .append("age", 19)
        //             .append("city", "Test City 3");

        //     // Insert the document into the collection
        //     collection.insertOne(document);

        //     System.out.println("Document inserted successfully.");
        // } catch (Exception e) {
        //     System.err.println("Error: " + e.getMessage());
        // }


    }
}
