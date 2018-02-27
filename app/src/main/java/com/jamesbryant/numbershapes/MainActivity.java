package com.jamesbryant.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;

                triangularNumber = triangularNumber + x;
            }

            if (number == triangularNumber) {

                return true;

            } else {

                return false;

            }



        }


        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {

                return true;

            } else {

                return false;

            }

        }


    }




    public void numberShapes(View view) {
        String message;

        EditText editText = (EditText) findViewById(R.id.numberEditText);

        if (editText.getText().toString().isEmpty()) {

            message = "Please enter a number.";

        } else {

            Number userNumber = new Number();

            userNumber.number = Integer.parseInt(editText.getText().toString());

            message = editText.getText().toString();

            if ((userNumber.isSquare()) && (userNumber.isTriangular())) {

                message += " is both, square and triangular.";

            } else if (userNumber.isSquare()) {

                message += " is square, but not triangular.";

            } else if (userNumber.isTriangular()) {

                message += " is triangular, but not square";

            } else {

                message += " is neither, square nor triangular.";

            }


            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
