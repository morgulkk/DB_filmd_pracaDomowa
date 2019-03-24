package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel{
    private boolean start;
    private JButton table;
    private JButton id;
    private JPanel panel;
    private JPanel panel2;
    private String lastCommand;
//konstruktor
    public Panel()
    {
        setLayout(new BorderLayout());
        lastCommand = "";
        start = true;
// Dodanie wyświetlacza

//        table = new JButton("Brak tabeli");
//        id = new JButton("Nie wskazano id");
//        table.setEnabled(false);
//        id.setEnabled(false);
//        add(table, BorderLayout.NORTH);
//        add(id, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();
        ActionListener categoriesAL = new CommandAction();
        ActionListener filmsAL = new CommandAction();
        ActionListener films_acorsAL = new CommandAction();
        ActionListener team_membersAL = new CommandAction();
        ActionListener utworzAL = new CommandAction();
        ActionListener insertAL = new CommandAction();
        ActionListener deleteAL = new CommandAction();
        ActionListener updateAL = new CommandAction();
        ActionListener selectAllAL = new CommandAction();
        ActionListener selectIDAL = new CommandAction();

// Wstawienie przycisków

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        addButton("Brak tabeli", insert);
        addButton("Nie wskazano id", insert);
        add(panel, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        addButton("Categories", categoriesAL);
        addButton("Films", filmsAL);
        addButton("films_actors", films_acorsAL);
        addButton("team_members", team_membersAL);
        addButton("UTWÓRZ", utworzAL);
        add(panel, BorderLayout.WEST);
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 1));
        addButton("Insert", insertAL);
        addButton("Delete", deleteAL);
        addButton("Update", updateAL);
        addButton("Select all", selectAllAL);
        addButton("Select by id", selectIDAL);
        add(panel2, BorderLayout.EAST);
    }
    /**
     * Dodaje przycisk do panelu centralnego.
     * @param label etykieta przycisku
     * @param listener słuchacz przycisków
     */
    private void addButton(String label, ActionListener listener)
    {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

     //### to do rozmnorzyć Lisnery
    private class InsertAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            if (start)
            {
                table.setText("");
                id.setText("");
                start = false;
            }
            //table.setText(display.getText() + input);
            table.setText("");
            id.setText("");
        }
    }
    /**
     * Ta akcja wykonuje polecenia określone przez akcję przycisku.
     */
    private class CommandAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            if (start)
            {
                if (command.equals("-"))
                {
                    table.setText(command);
                    id.setText(command);
                    start = false;
                }
                else lastCommand = command;
            }
            else
            {
                //calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

}

