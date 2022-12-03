import java.util.Scanner;
public class FIeld_3X3X3
{
    final private String[][][] PlayFiedl;
    private boolean IsXTurn = true;
    private boolean isWin = false;

    public FIeld_3X3X3()
    {
        PlayFiedl = new String[3][3][3];
        for(int z=0; z<3; z++)
        {
            for(int y=0; y<3; y++)
            {
                for(int x=0; x<3; x++)
                {
                    PlayFiedl[x][y][z] = "-";
                }
            }
        }
    }

    private void set_values()
    {
        Scanner myObj = new Scanner(System.in);
        int x = myObj.nextInt()-1;
        int y = myObj.nextInt()-1;
        int z = myObj.nextInt()-1;

        if ((x<0 | x>2)|(y <0 | y >2) | (z <0 | z > 2))
        {
            System.out.println("incorrect cords");
            set_values();
            return;
        }
        if (!(PlayFiedl[x][y][z].equals("-")))
        {
            System.out.println("cell is allredy cords");
            set_values();
            return;
        }
        if (IsXTurn) {
            IsXTurn = false;
            PlayFiedl[x][y][z] = "X";
        } else {
            IsXTurn = true;
            PlayFiedl[x][y][z] = "O";
        }
        isWinCheck();
    }

    private void isWinCheck()
    {
        if(checkVertical()| checkHorizontal() | checkHighest() | checkDiagonals() | checkFlatDiagonals())
        {
            isWin = true;

        }
    }
    private boolean checkVertical()
    {
        for(int z=0;z<3;z++)
        {
            for(int y=0;y<3;y++)
            {
                String test = (PlayFiedl[0][y][z]+PlayFiedl[1][y][z]+PlayFiedl[2][y][z]);
                if((test.equals("OOO")) | (test.equals("XXX")))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal()
    {
        for(int z=0;z<3;z++)
        {
            for(int x=0;x<3;x++)
            {
                String test = (PlayFiedl[x][0][z]+PlayFiedl[x][1][z]+PlayFiedl[x][2][z]);
                if(test.equals("OOO") | (test.equals("XXX")))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonals()
    {
        for(int y=0;y<3;y++)
        {
            for(int x=0;x<3;x++)
            {
                String test = PlayFiedl[x][y][0]+PlayFiedl[1][1][1]+PlayFiedl[2-x][2-y][2];
                if((test.equals("OOO")) | (test.equals("XXX")))
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkFlatDiagonals()
    {
        for(int z=0;z<3;z++)
        {
            for(int x=0;x<3;x++)
            {
                String test = PlayFiedl[0][0][z]+PlayFiedl[1][1][z]+PlayFiedl[2][2][z];
                String test2 = PlayFiedl[2][0][z]+PlayFiedl[1][1][z]+PlayFiedl[0][2][z];
                if((test.equals("OOO")) | (test.equals("XXX")) | (test2.equals("OOO")) | (test2.equals("XXX")))
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkHighest()
    {
        for(int y=0;y<3;y++)
        {
            for(int x=0;x<3;x++)
            {
                String test = PlayFiedl[x][y][0]+PlayFiedl[x][y][1]+PlayFiedl[x][y][2];
                if((test.equals("OOO")) | (test.equals("XXX")))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public void start()
    {
        while(true) {
            while (!(isWin)) {
                print();
                if (IsXTurn) {
                    System.out.println("X turn");
                } else {
                    System.out.println("O turn");
                }
                set_values();
            }
            print();
            if (!IsXTurn) {
                System.out.print("X win");
            } else {
                System.out.println("O win");
            }

            System.out.println("Restart? Y/N");
            Scanner myObj = new Scanner(System.in);
            if (myObj.next().equals("Y") | myObj.next().equals("y")) {
                isWin = false;
                clear();
            }
        }
    }

    private void clear()
    {
        for(int z=0; z<3; z++)
        {
            for(int y=0; y<3; y++)
            {
                for(int x=0; x<3; x++)
                {
                    PlayFiedl[x][y][z] = "-";
                }
            }
        }
    }
    
    public void print()
    {
        for(int z=0; z<3; z++)
        {
            for(int y=0; y<3; y++)
            {
                for(int x=0; x<3; x++)
                {
                    System.out.print(PlayFiedl[x][y][z]+"|");
                }
                System.out.println();
            }
            System.out.println("------------");
        }
    }
}
