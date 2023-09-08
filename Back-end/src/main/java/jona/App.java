package jona;

import jona.MongoDB.MongoConnection;
import jona.Selenium.Runner;
import jona.Utils.Account;

import java.util.ArrayList;

public class App
{
    static String url = "mongodb+srv://Jawaada:NenhwiO09jUh7AGq@stattracker.wrl0hcz.mongodb.net/stattracker?retryWrites=true&w=majority";

    public static void main( String[] args )
    {
        ArrayList<Account> queueAccountsList = MongoConnection.getAccounts(url, "stattracker", "qlists");
        ArrayList<Account> trackedAccountsList = MongoConnection.getAccounts(url, "stattracker", "trackedUsers");

        if (trackedAccountsList.size() > 0){
            for (Account acc : trackedAccountsList){
                if (acc == null)
                    continue;
                new Runner(acc.getUsername(), acc.getUserCode(), acc.getPlatform(), acc.getMode(), url);
            }
        }

        if (queueAccountsList.size() > 0){
            for (Account acc : queueAccountsList){
                if (acc == null)
                    continue;
                new Runner(acc.getUsername(), acc.getUserCode(), acc.getPlatform(), acc.getMode(), url);
            }
            MongoConnection.moveFromQueueToTrackedList(url, "stattracker", "qlists", "trackedUsers");
        }
    }
}