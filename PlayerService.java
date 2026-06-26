package FPGame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlayerService {
    public Player login(String username, String password) {
        String sql = "SELECT * FROM players WHERE username = ? AND password = ?";

        try {
            Connection conn = DatabaseManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String uname = rs.getString("username");
                int wins = rs.getInt("wins");
                int losses = rs.getInt("losses");
                int draws = rs.getInt("draws");
                int score = rs.getInt("score");
                return new Player(id, uname, wins, losses, draws, score);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public void updateResult(
            String username,
            String result
    ){
        String sql = "";

        if(result.equals("WIN")){
            sql = "UPDATE players " + "SET wins=wins+1, score=score+10 " + "WHERE username=?";
        }

        else if(result.equals("LOSS")){
            sql = "UPDATE players " + "SET losses=losses+1 " + "WHERE username=?";
        }

        else if(result.equals("DRAW")){
            sql = "UPDATE players " + "SET draws=draws+1, score=score+3 " + "WHERE username=?";
        }

        try{
            Connection conn = DatabaseManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public ResultSet getTopScorers(){
        try{
            Connection conn = DatabaseManager.getConnection();

            String sql = "SELECT username,wins,losses,draws,score " +
                            "FROM players " +
                            "ORDER BY score DESC LIMIT 5";

            PreparedStatement ps = conn.prepareStatement(sql);

            return ps.executeQuery();

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;

    }
}


