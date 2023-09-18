package Server;

import java.util.HashSet;

public class Server {
    /*skal indeholde connection lytter, navnetjekker, navnefjerner */
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
    public boolean removeNameFromSession(String name) {
        if (nc.contains(name)) {
            nc.remove(name);
            System.out.println("Name removed from the current session: " + name);
            return true;
        } else {
            System.out.println("Name not found in the current session: " + name);
            return false;
        }
    }
}