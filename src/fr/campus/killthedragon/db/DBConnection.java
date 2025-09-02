package fr.campus.killthedragon.db;

import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.character.Mage;
import fr.campus.killthedragon.character.Warrior;

import java.sql.*;
public abstract class DBConnection {
    protected final String DB_URL;
    protected final String USER;
    protected final String PASS;

    public DBConnection(){
       DB_URL = "jdbc:mysql://localhost/kill_the_dragon";
       USER = "user";
       PASS = "password";
    }


}
