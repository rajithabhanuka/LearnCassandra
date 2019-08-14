
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
public class DeleteData {

    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            connector.connectdb("localhost", 9042);

            final String deleteQuery = "DELETE FROM movies_keyspace.movies WHERE title=? AND year= ?";

            PreparedStatement psDelete = connector.getSession().prepare(deleteQuery);
            BoundStatement bsDelete = psDelete.bind("Annabelle", 2019);
            connector.getSession().execute(bsDelete);

            connector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
