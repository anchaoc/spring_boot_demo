package com.ac;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDateTime;

/**
 * @author anchao
 * @date 2020/1/15 11:16
 */
public class MongoTest {

    private static  MongoClientOptions dev ;
    private static MongoClient mongoClient ;
    private static MongoDatabase database;
    private static MongoCollection<Document> user;

    static {
        dev = MongoClientOptions.builder().build();
        mongoClient = new MongoClient("127.0.0.1", dev);
        database = mongoClient.getDatabase("dev");
    }


    public static void main(String[] args) {
        query();
    }


    private static void add() {
        Document doc = new Document();
        doc.append("bookName", "斗1");
        doc.append("bookPrice", "21.09");
        doc.append("bookShow", "不错1");
        doc.append("bookDate", LocalDateTime.now());
        user = database.getCollection("user");
        user.insertOne(doc);
        mongoClient.close();
    }

    private static void query() {
        user = database.getCollection("user");
        FindIterable<Document> documents = user.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            Document next = iterator.next();
            System.out.println(next);
        }
    }


}
