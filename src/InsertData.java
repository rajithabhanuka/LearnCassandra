
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bhanuka
 */
public class InsertData {

    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            connector.connectdb("localhost", 9042);

            final String insertQuery = "INSERT INTO movies_keyspace.movies (title,year,descreiption,rating) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement psInsert = connector.getSession().prepare(insertQuery);
            BoundStatement bsInsert = psInsert.bind("Annabelle", 2019, "Horror", "4.5");
            connector.getSession().execute(bsInsert);

            connector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
