import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    public Frame(){
        super("hello world");

        setLayout( null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(900,800);
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        JButton button1 = new JButton("Reset danych");
        JButton button2 =new JButton("Szyfruj");
        JButton button3 = new JButton("Deszyfruj");
        button1.setBounds(0,0,150,50);
        button2.setBounds(400,0,100,50);
        button3.setBounds(785,0,100,50);
        add (button1);
        add (button2);
        add (button3);


        JTextArea tekst_jawny= new JTextArea("Tekst jawny");
        JTextArea zaszyfrowane = new JTextArea();
        //JScrollPane scrollPane = new JScrollPane(tekst_jawny);
        //JScrollPane scrollPane1 = new JScrollPane(zaszyfrowane);
        tekst_jawny.setBounds(10,100,400,500);
        zaszyfrowane.setBounds(475,100,400,500);
        tekst_jawny.setVisible(true);
        zaszyfrowane.setVisible(true);
        tekst_jawny.setLineWrap(true);
        zaszyfrowane.setLineWrap(true);
        add(tekst_jawny);
        add(zaszyfrowane);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tekst_jawny.setText("");
                zaszyfrowane.setText("");
            }
        });


    }
}
