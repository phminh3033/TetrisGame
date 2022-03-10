package tetrisgame_jw_1.pkg0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class TetrisGame_JW_10 {
    
    private static Game_form gf;
    private static Startgame_form sf;
    private static Leaderboard_form lf;
    
    public String playerName;
    public int score;
    
    
    public static void start(){
        gf = new Game_form();
        gf.setVisible(true);
        gf.startGame();
    }
    
    public static void showLeaderboard(){
        lf.setVisible(true);
    }
    
    public static void showStartgame(){
        sf.setVisible(true);
    }
    
    public static void gameOver(int score){
        
        String playerName = JOptionPane.showInputDialog("Game Over!\nPlease enter your name");
        gf.setVisible(false);
        lf.addPlayer(playerName, score);
        ResultSet  rs = null;
        String query = "insert into player_name(name, score) values (?, ?)";  
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl= "jdbc:sqlserver://DESKTOP-BUGQL8P\\SQLEXPRESS:1433; databaseName=TetrisGame_DB; user=sa; password=123456789minh";
            Connection con = DriverManager.getConnection(dbUrl);
              
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, playerName);
            ps.setInt(2, score);
            
            rs = ps.executeQuery();
            
            System.out.println("thanh cong");
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("that bai");
        }
    }
    
    public static void main(String[] args) { 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gf = new Game_form();
                sf = new Startgame_form();
                lf = new Leaderboard_form();
        
                sf.setVisible(true);
            }
        });
    }
}
