import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Frame extends JFrame {
    public Frame() throws FileNotFoundException {
        super("Cipher");

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(900, 800);
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        JButton button1 = new JButton("Reset danych");
        JButton button2 = new JButton("Szyfruj");
        JButton button3 = new JButton("Deszyfruj");
        JButton button4 = new JButton("Zmien tryb pracy");
        JButton button5= new JButton("Wybierz plik");
        button1.setBounds(0, 0, 150, 50);
        button2.setBounds(230, 0, 100, 50);
        button3.setBounds(400, 0, 100, 50);
        button4.setBounds(550, 0, 150, 50);
        button5.setBounds(740,0,150,50);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);

        JLabel label1 = new JLabel("Wpisz tekst do zaszyfrowania");
        JLabel label2 = new JLabel("Zaszyfrowana wiadomosc");
        label1.setBounds(70, 30, 175, 100);
        label2.setBounds(550, 30, 150, 100);
        add(label1);
        add(label2);
        JTextArea tekst_jawny = new JTextArea();
        JTextArea zaszyfrowane = new JTextArea();
        //JScrollPane scrollPane = new JScrollPane(tekst_jawny);
        //JScrollPane scrollPane1 = new JScrollPane(zaszyfrowane);
        tekst_jawny.setBounds(10, 100, 400, 500);
        zaszyfrowane.setBounds(475, 100, 400, 500);
        tekst_jawny.setVisible(true);
        zaszyfrowane.setVisible(true);
        tekst_jawny.setLineWrap(true);
        zaszyfrowane.setLineWrap(true);
        //zaszyfrowane.setEditable(false);
        add(tekst_jawny);
        add(zaszyfrowane);




        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tekst_jawny.setText("");
                zaszyfrowane.setText("");
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String  key= "test";
                key = key.toUpperCase().replace("[^A-Za-z]","").replace(" ","").replace("J","I");
                Playfair playfair = new Playfair();
                playfair.createTable(key);
                System.out.println();
                String text = tekst_jawny.getText();
                text = text.toUpperCase().replace("[^A-Za-z]","").replace(" ","").replace("J","I");
                String [] output = playfair.cipher(text);
                for(int i=0;i<output.length;i=i+2) {

                    zaszyfrowane.append(output[i]);
                }
                }
        });


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String  key= "test";
                key = key.toUpperCase().replace("[^A-Za-z]","").replace(" ","").replace("J","I");
                Playfair playfair = new Playfair();
                playfair.createTable(key);
                System.out.println();
                String text = zaszyfrowane.getText();
                text = text.toUpperCase().replace("[^A-Za-z]","").replace(" ","").replace("J","I");
                String [] output = playfair.decode(text);
                for(int i=0;i<output.length;i=i+2) {

                    tekst_jawny.append(output[i]);
                }
            }
        });


        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                fc.showOpenDialog(Frame.this);
                fc.setBounds(475,600,60,70);
                add(fc);
                try {
                    // Open an input stream
                    Scanner reader = new Scanner(fc.getSelectedFile());
                } catch (Exception error){}
            }
        });

//        button4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int flag = 0;
//                if (flag == 0) {
//                    tekst_jawny.setEditable(false);
//                    zaszyfrowane.setEditable(true);
//                    flag = 1;
//                }
//                if (flag == 1) {
//                    tekst_jawny.setEditable(true);
//                    zaszyfrowane.setEditable(false);
//                    flag = 0;
//
//                }
//
//            }
//
//        });
    }
}