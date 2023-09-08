package jona.MongoDB;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import jona.Heroes.HeroSpecific;
import jona.Utils.Account;
import jona.Utils.ArrayUtil;
import org.bson.Document;

import java.sql.Date;
import java.util.ArrayList;

public class MongoConnection {
    String url;
    String dbName = "stattracker";
    String collName = "users";
    String username;
    int userCode;

    public MongoConnection(String url, String username, int userCode){
            this.url = url;
            this.username = username;
            this.userCode = userCode;
    }

    public static ArrayList<Account> getAccounts(String url, String db, String colls){
        try (MongoClient client = MongoClients.create(url)){
            MongoCollection<Document> accounts = client.getDatabase(db).getCollection(colls);
            ArrayList<Account> allAccounts = new ArrayList<>();

            MongoCursor<Document> cursor = accounts.find().iterator();
            while (cursor.hasNext()){
                Document doc = cursor.next();
                String json = doc.toJson();
                ObjectMapper mapper = new ObjectMapper();

                try {
                    Account acc = mapper.readValue(json, Account.class);
                    allAccounts.add(acc);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            cursor.close();
            return allAccounts;
        }
    }

    public static void moveFromQueueToTrackedList(String url, String db, String queueColls, String dbColls){
        try (MongoClient client = MongoClients.create(url)) {
            MongoCollection<Document> queueUsers = client.getDatabase(db).getCollection(queueColls);
            MongoCollection<Document> trackedUsers = client.getDatabase(db).getCollection(dbColls);

            FindIterable<Document> documents = queueUsers.find();
            MongoCursor<Document> cursor = documents.iterator();

            while (cursor.hasNext()){
                Document doc = cursor.next();
                trackedUsers.insertOne(doc);
            }
            cursor.close();
            queueUsers.deleteMany(new Document());
        }
    }

    public void createDocuments(String type, ArrayList<HeroSpecific> heroes){
        try (MongoClient client = MongoClients.create(url)){
            MongoCollection<Document> users = client.getDatabase(dbName).getCollection(collName);
            Date time = ArrayUtil.getTodayDate();

            if (users.find(Filters.and(Filters.eq("username", username), Filters.eq("id", userCode))).first() == null){
                Document character = new Document("username", username)
                        .append("id", userCode)
                        .append("updated", time.toString())
                        .append("previous", new Document())
                        .append("current", new Document(time.toString(),
                                new Document("supports", new Document())
                                .append("damage", new Document())
                                .append("tanks", new Document())));

                users.insertOne(character);
            }

            updateDocuments(type, heroes);
        }
    }

    void updateDocuments(String type, ArrayList<HeroSpecific> dataInfo){
        try (MongoClient client = MongoClients.create(url)){
            MongoCollection<Document> users = client.getDatabase(dbName).getCollection(collName);
            Date time = ArrayUtil.getTodayDate();

            // Change Updated date
            users.updateOne(
                    Filters.and(Filters.eq("username", username), Filters.eq("id", userCode)),
                    Updates.set("updated", time.toString()));

            // Validate the current date
            if (users.find(Filters.and(Filters.eq("username", username), Filters.eq("id", userCode))).first().get("current", Document.class).get(time.toString(), Document.class) == null){
                Document prevDoc = users.find(Filters.and(Filters.eq("username", username), Filters.eq("id", userCode))).first().get("current", Document.class);
                prevDoc.append(time.toString(), new Document("supports", new Document())
                        .append("damage", new Document())
                        .append("tanks", new Document()));

                users.updateOne(
                        Filters.and(Filters.eq("username", username), Filters.eq("id", userCode)),
                        Updates.set("current", prevDoc));
            }

            Document prevSupports = users.find(Filters.and(Filters.eq("username", username), Filters.eq("id", userCode))).first().get("current", Document.class).get(time.toString(), Document.class).get(type, Document.class);

            for (HeroSpecific hero : dataInfo){
                if (prevSupports.get(hero.getHeroName(), Document.class) != null){
                    continue;
                }

                prevSupports.append(hero.getHeroName(), new Document("name", hero.getHeroName())
                        .append("time_played", hero.getTime().toString())
                        .append("games_played", hero.getGamesPlayed())
                        .append("games_won", hero.getGamesWon())
                        .append("games_lost", hero.getGamesLost())
                        .append("average", new Document("eliminations", hero.getKills())
                                .append("eliminations_per_life", hero.getElimsPerLife())
                                .append("assists", hero.getAssists())
                                .append("deaths", hero.getDeaths())
                                .append("damage", hero.getHeroDmg())));
            }

            users.updateOne(
                    Filters.and(Filters.eq("username", username), Filters.eq("id", userCode)),
                    Updates.set("current."+time.toString()+"."+type, prevSupports)
            );
        }
    }
}