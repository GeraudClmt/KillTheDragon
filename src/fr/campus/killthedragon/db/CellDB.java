package fr.campus.killthedragon.db;


import fr.campus.killthedragon.enemy.Enemy;
import fr.campus.killthedragon.equipement.deffensive.Cape;
import fr.campus.killthedragon.equipement.deffensive.Shield;
import fr.campus.killthedragon.equipement.health.BigPotion;
import fr.campus.killthedragon.equipement.health.SmallPotion;
import fr.campus.killthedragon.equipement.offensive.Club;
import fr.campus.killthedragon.equipement.offensive.FireBall;
import fr.campus.killthedragon.equipement.offensive.Flash;
import fr.campus.killthedragon.equipement.offensive.Sword;
import fr.campus.killthedragon.game.Board;
import fr.campus.killthedragon.game.Cell;

import java.sql.*;

public class CellDB extends DBConnection {

    public Board getBoardOfPlayer(String playerName) {
        Board boardDb = new Board(64, 0, 0);
        String request = "SELECT Cell.* FROM Cell JOIN Board ON Cell.board_id = Board.id JOIN `Character` ON Board.character_id = `Character`.id WHERE `Character`.name = ?;";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);) {
            PreparedStatement ps = connection.prepareStatement(request);
            ps.setString(1, playerName);

            ResultSet rs2 = ps.executeQuery();

            while (rs2.next()) {
                System.out.println("-------------------------------------------");
                System.out.println("Id= " + rs2.getInt("Number"));
                System.out.println("Type= " + rs2.getString("Content"));

                Cell cellOfData = null;

                switch (rs2.getString("Content")) {
                    case "Enemy":
                        cellOfData = new Enemy();
                        break;
                    case "Cape":
                        cellOfData = new Cape();
                        break;
                    case "Shield":
                        cellOfData = new Shield();
                        break;
                    case "BigPotion":
                        cellOfData = new BigPotion();
                        break;
                    case "SmallPotion":
                        cellOfData = new SmallPotion();
                        break;
                    case "Club":
                        cellOfData = new Club();
                        break;
                    case "Fireball":
                        cellOfData = new FireBall();
                        break;
                    case "Flash":
                        cellOfData = new Flash();
                        break;
                    case "Sword":
                        cellOfData = new Sword();
                        break;
                }

                boardDb.addCellToBoard(rs2.getInt("Number"), cellOfData);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boardDb;
    }
}
