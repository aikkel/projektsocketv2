package Server;

import java.util.HashSet;

public class Server {
    /*skal indeholde connection lytter, navnetjekker */

    public class nameChecker{
        //hashset - til navne
        HashSet<String> nc = new HashSet<String>();

        public boolean addName(String name) {
            // Check if the name already exists
            if (nc.contains(name)) {
                System.out.println("Name already exists: " + name);
                return false;
            }
            else
                nc.add(name);
            System.out.println("Name added: " + name);
            return true;
        }
    }
}