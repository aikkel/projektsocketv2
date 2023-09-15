package Client;

import java.net.IDN;

public class ClientEntity {
    private int ID;
    private String name;

    public ClientEntity(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
