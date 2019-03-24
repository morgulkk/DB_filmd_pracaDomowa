import javax.swing.*;
import java.awt.*;
import Frame.*;

public class Main {
    public static void main(String[] args) {

          String query = "create table if not exists curiosities (            " +
                    "id int(11) NOT NULL AUTO_INCREMENT,    " +
                    "description varchar(1000) NOT NULL,    " +
                    "film_id int(11) NOT NULL,    PRIMARY KEY (id),    " +
                    "KEY film_id (film_id),    " +
                    "CONSTRAINT curiosities_ibfk_1 FOREIGN KEY (film_id) REFERENCES films (id));";
//        CreateTable tab = new CreateTable();
//        tab.crateTableNow(query);
        EventQueue.invokeLater(() -> {
            DBFrame frame = new DBFrame();
            frame.setTitle("BAZY");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
