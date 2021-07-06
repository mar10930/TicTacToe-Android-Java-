/*
Name: Mario Luja
Date: 5/31/21
This will be my first android project to really grasp the idea
of how to operate and implement buttons in Android, as well as
concepts that I already know in Java by implementing a game of
tic-tac-toe.
 */
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//CTRL+ALT+O to optimize imports
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int turnCounter = 0;
    //Views converted to buttons

    public void PlayMove(View v) {
        turnCounter += 1;

        Button b = (Button) v;
        TextView winText  =  findViewById(R.id.textView);

        if (b.isClickable() && (turnCounter % 2 == 0)) {
            b.setClickable(false);
            b.setText("X");
        }

        else {
            b.setClickable(false);
            b.setText("O");
        }
        //Create all the buttons that will represent a space (9)
        Button b1 =  (Button) (findViewById(R.id.toggleButton1));
        Button b2 =  (Button) (findViewById(R.id.toggleButton2));
        Button b3 =  (Button) (findViewById(R.id.toggleButton3));
        Button b4 =  (Button) (findViewById(R.id.toggleButton4));
        Button b5 =  (Button) (findViewById(R.id.toggleButton5));
        Button b6 =  (Button) (findViewById(R.id.toggleButton6));
        Button b7 =  (Button) (findViewById(R.id.toggleButton7));
        Button b8 =  (Button) (findViewById(R.id.toggleButton8));
        Button b9 =  (Button) (findViewById(R.id.toggleButton9));

        //Convert button text to char data type to read move
        char b1Move = b1.getText().toString().charAt(0);
        char b2Move = b2.getText().toString().charAt(0);
        char b3Move = b3.getText().toString().charAt(0);
        char b4Move = b4.getText().toString().charAt(0);
        char b5Move = b5.getText().toString().charAt(0);
        char b6Move = b6.getText().toString().charAt(0);
        char b7Move = b7.getText().toString().charAt(0);
        char b8Move = b8.getText().toString().charAt(0);
        char b9Move = b9.getText().toString().charAt(0);

        //Create a double array (3x3) to
        char[][] boardText =  {{b1Move,b2Move,b3Move},{b4Move,b5Move,
                b6Move},{b7Move,b8Move,b9Move}};

        if(xWin(boardText))
        {
            winText.setText("X is the winner!");
            disableEnableTable(b1,b2,b3,b4,b5,b6,b7,b8,b9,false);
        }
        else if(oWin(boardText))
        {
            winText.setText("O is the winner!");
            disableEnableTable(b1,b2,b3,b4,b5,b6,b7,b8,b9,false);
        }
        else
        {
            winText.setText("");
        }



    }
    //Method to check if X is the winner
    public boolean xWin(char[][] board )
    {
        String xWinHoriz = "";
        String xWinVert = "";
        String xDiagonalLeft = "";
        String xDiagRight = "";
        //boolean match
        boolean xMatch = false;


        //Check if a horizontal and vertical row is a win for X
        for(int i = 0; i <= 2; i++)
        {
            int col = 2;

            for(int j = 0; j <= 2; j++)
            {

                xWinHoriz += board[i][j];
                xWinVert += board[j][i];
                xDiagonalLeft += board[j][j];
                xDiagRight += board[j][col];
                if (xWinHoriz.equals("XXX"))
                {
                    xMatch = true;
                    //Set rest of buttons to false when a winner is chosen

                }
                else if(xWinVert.equals("XXX"))
                {
                    xMatch = true;

                }
                else if(xDiagonalLeft.equals("XXX"))
                {
                    xMatch = true;

                }
                else if(xDiagRight.equals("XXX"))
                {
                    xMatch = true;
                }
                col--;
            }

            xWinHoriz ="";
            xWinVert ="";
            xDiagonalLeft = "";
            xDiagRight = "";
        }

        return xMatch;
    }

    //Method to check if O is the winner
    public boolean oWin(char[][] boardO)
    {
        String oWinHoriz = "";
        String oWinVert = "";
        String oDiagonalLeft = "";
        //boolean match
        boolean oMatch = false;

        //Check if a horizontal row is a win for X
        for(int i = 0; i <= 2; i++)
        {
            for(int j = 0; j <= 2; j++)
            {
                oWinHoriz += boardO[i][j];
                oWinVert += boardO[j][i];
                oDiagonalLeft += boardO[j][j];
                if (oWinHoriz.equals("OOO"))
                {
                    oMatch = true;
                }
                else if(oWinVert.equals("OOO"))
                {
                    oMatch = true;
                }
                else if(oDiagonalLeft.equals("OOO"))
                {
                    oMatch = true;

                }
            }
            oWinHoriz ="";
            oWinVert ="";
            oDiagonalLeft = "";
        }
        return oMatch;

    }
    //Method used whenever the game is over or reset
    public void disableEnableTable(Button b1,Button b2,Button b3,Button b4,Button b5,
                            Button b6,Button b7,Button b8,Button b9,boolean clickable)
    {
        if(clickable == false)
        {
            b1.setClickable(false);
            b2.setClickable(false);
            b3.setClickable(false);
            b4.setClickable(false);
            b5.setClickable(false);
            b6.setClickable(false);
            b7.setClickable(false);
            b8.setClickable(false);
            b9.setClickable(false);
        }


    }
}



