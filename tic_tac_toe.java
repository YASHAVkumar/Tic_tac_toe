package game;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class checkRepeat
   {
       Set<Integer> obj=new HashSet<>();
       int flag=0;
       public int checkRepeat(int a)
       {
           if(obj.contains(a))
               flag=1;
           else
               obj.add(a);

           return flag;
       }
   }
public class tic_tac_toe {
    static int var=0,sum=0,sum1=0,f=0;
    static  char arr[][]=new char[3][3];
    static int array[][]={{1,2,3},{4,5,6},{7,8,9}};

    public static int function(char ch,char ch1){
        Scanner sc=new Scanner(System.in);

       if(f==0)
       {System.out.println("Player 1 it's Your turn");f-=1;}
       else
       {
           System.out.println("Player 2 it's Your turn");
           f+=1;
       }
   checkRepeat obj=new checkRepeat();
        System.out.println("Enter a Postion of i and j ");
      int posi=sc.nextInt(),posj=sc.nextInt();

      if(obj.checkRepeat(array[posi][posj])==1)
      {
          System.out.println("This position is already taken \n \"Please Renter your Position\"");
          posi=sc.nextInt();
          posj=sc.nextInt();
          try{
              int num;
              if(obj.checkRepeat(array[posi][posj])==1)
                   num=1/0;
          }
          catch (Exception e)
          {
              System.out.println("Twice position recorded Exception "+e);
          }
      }


int count_on_turn1=0,count_on_turn2=0;

      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++) {
              if (i == posi && j == posj & var == 0) {
                  arr[i][j] = ch;
                  var += 1;
                  sum+=array[i][j];
                  count_on_turn1++;
              } else if (var == 1 && j == posj && i == posi) {
                  arr[i][j] = ch1;
                  var -= 1;
                  sum1+=array[i][j];
                  count_on_turn2++;
              }
          }
      }

      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
              System.out.print(arr[i][j]+" | ");
          System.out.println();
      }
      if((sum==6||sum==15||sum==24||sum==12||sum==18)&&count_on_turn1==3)
          return 1;
       else if((sum1==6||sum1==15||sum1==24||sum1==12||sum1==18)&&count_on_turn2==3)
        return 2;
       else
           return 0;
    }

    public  static  int turn()
    {
        int flag= (int) (Math.random()*10),turn;
        if(flag<=5)
            turn=1;
        else
            turn=2;

        return turn;

    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=9;
        int arr[][]=new int[3][3];

        System.out.println("Tic Tac Toe - Game");

        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(i + "" + j + " | ");

            }
            System.out.println();
        }


     char ch='0',ch1='1';

        int flag=0;

        System.out.println("Enter 1 for inputs ands 2 for  random ");
        flag=sc.nextInt();

        switch (flag) {
            case 1:
                System.out.println("Player 1 enter your choice");
                ch = sc.next().charAt(0);
                if (ch == 'o')
                    ch1 = 'x';
                else
                    ch1 = 'o';
                break;
            case 2:
                int n;
                n = turn();
                if (n == 1) {
                    ch = 'o';
                    ch1 = 'x';
                } else {
                    ch = 'x';
                    ch1 = 'o';
                }
                break;
            default:
                System.out.println("Testing");
                break;
        }

        System.out.println("Player 1 "+ch+" Player 2 "+ch1);

              int check=0;
              while (t-->0)
          {

            check=function(ch,ch1);

            if(check==1)
            {
                System.out.println("Player 1 "+ch+" is Winner");
                break;
            }
            else if(check==2)
            {
                System.out.println("Player 2 "+ch1+" is Winner");
                break;
            }

          }
              if(check==0)
        System.out.println("Draw Game Thanks for playing");

    }
}
