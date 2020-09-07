package edu.samir.pizza2nice.model;

import java.security.SecureRandom;
import java.util.UUID;

public class LocalUniqueId {

    private final UUID uuid = UUID.randomUUID();
    private String uid;

    public static LocalUniqueId randomUniqueId() {
        return new LocalUniqueId();
    }

    public LocalUniqueId(String id){
        new LocalUniqueId();
        uid = id;
    }

    private LocalUniqueId(){
        extractUId();
    }
    private String extractUId(){
        uid = uuid.toString();
        String[] divided = uid.split("-");
        return uid = divided[0];
    }

    public boolean equals(LocalUniqueId uid){
        return this.uid.equals(uid);
    }

    @Override
    public String toString(){
        return uid;
    }
}
