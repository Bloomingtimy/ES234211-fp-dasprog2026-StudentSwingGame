package FPGame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;


public class TopScorersFrame extends JFrame {
    JTable table;

    public TopScorersFrame(){

        setTitle("Top 5 Scorers");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns =
                {
                        "Username",
                        "Wins",
                        "Losses",
                        "Draws",
                        "Score"
                };


        DefaultTableModel model = new DefaultTableModel(columns, 0);
        PlayerService service = new PlayerService();

        try{
            ResultSet rs = service.getTopScorers();

            while(rs.next()){
                model.addRow(
                        new Object[]{
                                rs.getString("username"),
                                rs.getInt("wins"),
                                rs.getInt("losses"),
                                rs.getInt("draws"),
                                rs.getInt("score")
                        }
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable(model);

        add(new JScrollPane(table));
    }


}