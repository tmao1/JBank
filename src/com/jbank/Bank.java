package com.jbank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by localadmin on 7/28/16.
 */
public class Bank {
    private String id;
    private String name;
    private ArrayList<Client> clients;

    public Bank(String name) {
        this.name = name;
        this.id = String.valueOf(UUID.randomUUID());
        this.clients = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addClient(String clientName)
    {
        this.clients.add(new Client(clientName));
    }

    public void removeClient(String id){

        ArrayList<Client> c = this.getClients().stream()
                .parallel()
                .filter(client -> client.getId().equals(id))
                .collect(Collectors.toCollection(ArrayList::new));
        c.get(0).setActive(false);
        c.get(0).getAccounts().forEach(account -> account.setClosed());
    }
}
