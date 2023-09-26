package Server;

import java.util.HashSet;

/*
public class Server {
//skal indeholde connection lytter, navnetjekker, navnefjerner

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
*/

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
//todo retuner noget der kan måles på, så logincontroller kan skrive tilbage med success eller fejl
public class Server {
    private List<String> connectedNames = new CopyOnWriteArrayList<>();

    public boolean addName(String name) {
        if (!connectedNames.contains(name)) {
            connectedNames.add(name);
            return true; // Name added successfully
        } else {
            return false; // User with the same name already exists
        }
    }

    public void removeName(String name) {
        connectedNames.remove(name);
    }

    public List<String> getConnectedNames() {
        return connectedNames;
    }
}