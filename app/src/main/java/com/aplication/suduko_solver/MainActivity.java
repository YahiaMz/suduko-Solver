package com.aplication.suduko_solver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button solveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
        onClickListiners();
    }

    private void init() {


        this.solveBtn = findViewById(R.id.button);
        this.btn1 = findViewById(R.id.NUMBER1);
        this.btn2 = findViewById(R.id.NUMBER2);
        this.btn3 = findViewById(R.id.NUMBER3);
        this.btn4 = findViewById(R.id.NUMBER4);
        this.btn5 = findViewById(R.id.NUMBER5);
        this.btn6 = findViewById(R.id.NUMBER6);
        this.btn7 = findViewById(R.id.NUMBER7);
        this.btn8 = findViewById(R.id.NUMBER8);
        this.btn9 = findViewById(R.id.NUMBER9);


    }

    private void onClickListiners() {
        this.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Suduko_board.solver.getCurrent_Column() > -1 && Suduko_board.solver.getCurrent_Row() > -1)
                    Suduko_board.solver.setValueAt(Suduko_board.solver.getCurrent_Column(), Suduko_board.solver.getCurrent_Row(), 1);
            }
        });
        // End of Btn
        this.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Suduko_board.solver.getCurrent_Column() > -1 && Suduko_board.solver.getCurrent_Row() > -1)
                    Suduko_board.solver.setValueAt(Suduko_board.solver.getCurrent_Column(), Suduko_board.solver.getCurrent_Row(), 2);

            }
        });
        // End of Btn
        this.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Suduko_board.solver.getCurrent_Column() > -1 && Suduko_board.solver.getCurrent_Row() > -1)
                    Suduko_board.solver.setValueAt(Suduko_board.solver.getCurrent_Column(), Suduko_board.solver.getCurrent_Row(), 3);

            }
        });
        // End of Btn
        this.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Suduko_board.solver.getCurrent_Column() > -1 && Suduko_board.solver.getCurrent_Row() > -1 )
                    Suduko_board.solver.setValueAt(Suduko_board.solver.getCurrent_Column() , Suduko_board.solver.getCurrent_Row() , 4);

            }
        });
        // End of Btn
        this.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Suduko_board.solver.getCurrent_Column() > -1 && Suduko_board.solver.getCurrent_Row() > -1)
                    Suduko_board.solver.setValueAt(Suduko_board.solver.getCurrent_Column(), Suduko_board.solver.getCurrent_Row(), 5);

            }
        });

        // End of Btn
        this.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Suduko_board.solver.getCurrent_Column() > -1 && Suduko_board.solver.getCurrent_Row() > -1)
                    Suduko_board.solver.setValueAt(Suduko_board.solver.getCurrent_Column(), Suduko_board.solver.getCurrent_Row(), 6);


            }
        });
        // End of Btn
        this.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Suduko_board.solver.getCurrent_Column() > -1 && Suduko_board.solver.getCurrent_Row() > -1)
                    Suduko_board.solver.setValueAt(Suduko_board.solver.getCurrent_Column(), Suduko_board.solver.getCurrent_Row(), 7);


            }
        });
        // End of Btn
        this.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Suduko_board.solver.getCurrent_Column() > -1 && Suduko_board.solver.getCurrent_Row() > -1)
                    Suduko_board.solver.setValueAt(Suduko_board.solver.getCurrent_Column(), Suduko_board.solver.getCurrent_Row(), 8);
            }
        });

        // End of Btn
        this.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Suduko_board.solver.getCurrent_Column() > -1 && Suduko_board.solver.getCurrent_Row() > -1)
                    Suduko_board.solver.setValueAt(Suduko_board.solver.getCurrent_Column(), Suduko_board.solver.getCurrent_Row(), 9);
            }

        });
        // End of Btn


        // solve btn
        this.solveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Suduko_board.solver.showBoard();
            }
        });


    }

}