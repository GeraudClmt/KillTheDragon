package fr.campus.killthedragon.db;

import fr.campus.killthedragon.character.Character;
import fr.campus.killthedragon.character.Mage;
import fr.campus.killthedragon.character.Warrior;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterDB extends DBConnection{

    //Return List
    public List<Character> getHeroes(){
        List<Character> listOfHeros = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt = connection.createStatement();
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM `Character`");

            while (rs2.next()){
                if(rs2.getString("Type").equals("Warrior")){
                    listOfHeros.add(new Warrior(rs2.getString("Name"), rs2.getInt("LifePoints"), rs2.getInt("Strength")));
                }else {
                    listOfHeros.add(new Mage(rs2.getString("Name"), rs2.getInt("LifePoints"), rs2.getInt("Strength")));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfHeros;
    }
    public Character createHero(Character player){
        String sqlRequest = "INSERT into  `Character` (Type, Name, Strength, LifePoints) VALUES (?, ?, ?, ?)";
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);) {
            PreparedStatement ps = connection.prepareStatement(sqlRequest);
            ps.setString(1, player.getType());
            ps.setString(2, player.getName());
            ps.setInt(3, player.getAttack());
            ps.setInt(4, player.getHealth());

            ps.executeUpdate();


        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Name already exists");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return getCharacter(player.getName());
    }

    public Character editHero(Character player, String newName){
        String sqlRequest = "UPDATE `Character` SET Type = ?, Name = ?, Strength = ?, LifePoints = ? WHERE Name = ?  ";
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);) {
            PreparedStatement ps = connection.prepareStatement(sqlRequest);
            ps.setString(1, player.getType());
            ps.setString(2, newName);
            ps.setInt(3, player.getAttack());
            ps.setInt(4, player.getHealth());
            ps.setString(5, player.getName());

            ps.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return getCharacter(newName);
    }

    public void changeLifePoints(Character player, int newLifePoints){
        String sqlRequest = "UPDATE `Character` SET LifePoints = ? WHERE Name = ?";
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);) {
            PreparedStatement ps = connection.prepareStatement(sqlRequest);
            ps.setInt(1, newLifePoints);
            ps.setString(2, player.getName());

            int result = ps.executeUpdate();
            if(result == 0){
                System.out.println( "No lines have been modified" );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Character getCharacter(String name){
        String request = "SELECT * FROM `Character` WHERE Name = ?";
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);) {
            PreparedStatement ps = connection.prepareStatement(request);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return switch (rs.getString("Type")) {
                    case ("Mage") -> new Mage(rs.getString("Name"), rs.getInt("LifePoints"), rs.getInt("Strength"));
                    case ("Warrior") ->
                            new Warrior(rs.getString("Name"), rs.getInt("LifePoints"), rs.getInt("Strength"));
                    default -> null;
                };
            }else {
                System.out.println("No characters found with the name : " + name);
                return null;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
