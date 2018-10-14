import java.awt.*;

public class Playfair {
   private char [][] table;
   int length;
   public Playfair(){};


   public char[][] createTable(String keyWord)
   {
       int counter=0;
       char current;
       boolean flag=true;
       boolean flag2=false;
       table=new char[5][5];
       String key= ""+ keyWord.charAt(0);

       for(int i=1;i<keyWord.length();i++) {
           for (int j = 0; j < key.length(); j++) {
               if (keyWord.charAt(i) == key.charAt(j)) {
                   flag2=true;
               }

           }
           if(flag2==false)
           {
               key = key + keyWord.charAt(i);
           }
           flag2=false;
       }





       for(int i=0;i<26;i++)
       {
           current=(char) (i+65);
           flag=true;
           if(current=='J')
           {
               continue;
           }
           for(int j=0;j<key.length();j++)
           {
               if(current==key.charAt(j))
               {
                   flag=false;
                   break;
               }
           }
           if(flag)
           {
               key= key+current;
           }
       }


    for(int i=0;i<5;i++)
    {
        for(int j=0;j<5;j++)
        {
            table[i][j]=key.charAt(counter);
            counter++;
        }
    }
       for(int i=0;i<5;i++)
       {
           for(int j=0;j<5;j++)
           {
              System.out.print(table[i][j]);
           }
           System.out .println();
       }

    return table;

   }


   public String [] cipher(String message)
   {
        StringBuilder sb= new StringBuilder(message);

        for(int i=0;i<sb.length();i=i+2)
        {
            if(i==sb.length()-1)
            {
                if(sb.length()%2!=0)
                {
                    sb.append('X');
                }
            }
            if(sb.charAt(i)==sb.charAt(i+1))
            {
                sb.insert(i+1,'X');
            }
        }
        System.out.println(sb);
        message=sb.toString();
        return encode((message));
   }

   public String [] encode(String message)
   {
       length=message.length();
       String [] code=new String[length];
       for(int i=0;i<length;i=i+2)
       {
        char a= message.charAt(i);
        char b = message.charAt(i+1);

        int row1=getPoint(a).x;
        int row2=getPoint(b).x;
        int col1=getPoint(a).y;
        int col2=getPoint(b).y;

        if(row1==row2)
        {
            col1=(col1+1)%5;
            col2=(col2+1)%5;
        }

        else if(col1==col2)
        {
            row1=(row1+1)%5;
            row2=(row2+1)%5;
        }

        else
        {
            int help=col1;
            col1=col2;
            col2=help;
        }

        code[i]=table[row1][col1] +""+table[row2][col2];

       }
      for(int i=0;i<code.length;i=i+2)
      {
          System.out.print(code[i]);
      }
       return code;
   }

   public String[] decode (String output)
   {
       length=output.length();
       String [] decoded =new String[length];
       for(int i=0;i<length;i=i+2)
       {
           char a= output.charAt(i);
           char b = output.charAt(i+1);

           int row1=getPoint(a).x;
           int row2=getPoint(b).x;
           int col1=getPoint(a).y;
           int col2=getPoint(b).y;

           if(row1==row2)
           {
               col1=(col1+4)%5;
               col2=(col2+4)%5;
           }

           else if(col1==col2)
           {
               row1=(row1+4)%5;
               row2=(row2+4)%5;
           }

           else
           {
               int help=col1;
               col1=col2;
               col2=help;
           }

           decoded[i]=table[row1][col1] +""+table[row2][col2];

       }
       for(int i=0;i<decoded.length;i=i+2)
       {
           System.out.print(decoded[i]);
       }
       return decoded;
   }

   public Point getPoint(char c)
   {
       Point point=new Point(0,0);
       for(int i=0;i<5;i++)
       {
           for(int j=0;j<5;j++)
           {
               if(c==table[i][j])
               {
                   point= new Point(i,j);
               }
           }
       }
       return point;
   }
}
