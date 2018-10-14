import java.io.*;
import java.util.Scanner;
public class main {

    public static void main(String[] args) throws IOException {

        Frame frame = new Frame();

        String opcja = new String();
        System.out.println("Do you want to input data from keyboard or from file?");
        System.out.println("1. From Keyboard");
        System.out.println("2. From File");
        Scanner temp = new Scanner(System.in);
        opcja = temp.nextLine();

        switch (opcja) {

            case "1": {
                System.out.println("Podaj klucz szyfrujacy: ");
                Scanner sc = new Scanner(System.in);
                String key = parseString(sc);
                System.out.println();

                System.out.println("Podaj jaka wiadomosc ma zostac zaszyfrowana: ");
                Scanner scanner = new Scanner(System.in);
                String text = parseString(sc);
                System.out.println();

                Playfair playfair = new Playfair();
                playfair.createTable(key);
                System.out.println();
                String [] output = playfair.cipher(text);
                System.out.println();
                String[] decoded= new String[output.length];
                for(int i=0;i<output.length;i=i+2)
                {
                    decoded[i]=decoded[i]+playfair.decode(output[i]);
                }

                break;
            }

            case"2":
            {
                File file= new File("C:/Users/deco6/Desktop/Playfair Cipher/key.txt");
                File file1=new File("C:/Users/deco6/Desktop/Playfair Cipher/text.txt");
                BufferedReader bf = new BufferedReader(new FileReader(file));
                BufferedReader br = new BufferedReader(new FileReader(file1));

                String key = bf.readLine().toUpperCase().replace("J","I").replace(" ","");
                String text = br.readLine().toUpperCase().replace("[^A-Za-z]","").replace(" ","");

                Playfair pf = new Playfair();
                pf.createTable(key);
                System.out.println();
                String [] output = pf.cipher(text);
                System.out.println();
                BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted.txt"));
                for(int i =0;i<output.length;i=i+2) {
                    writer.write(output[i]);
                }
                writer.close();
                System.out.println();
                String[] decoded= new String[output.length];
                for(int i=0;i<output.length;i=i+2)
                {
                    decoded[i]=decoded[i]+pf.decode(output[i]);
                }


                BufferedWriter writer1= new BufferedWriter(new FileWriter("decrypted.txt"));
                for(int i=0;i<decoded.length;i=i+2)
                {
                    writer1.write(decoded[i]);
                }
                writer1.close();

                break;
            }

            default:
            {
                System.out.println("Podano zla wartosc");
            }
        }
    }

    private static String parseString(Scanner sc) {
        String parse = sc.nextLine();
        parse=parse.toUpperCase();
        parse = parse.replace("[^A-Za-z]","");
        parse = parse.replace(" ","");
        parse = parse.replace("J","I");
        return parse;
    }
}
