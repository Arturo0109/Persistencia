package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    private TextView display;
    private double firstValue = 0;
    private double secondValue = 0;
    private String operation = "";
    private boolean operationClicked = false;
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora); // Asegúrate de que este sea el nombre correcto de tu layout

        display = findViewById(R.id.display);

        // Listener para números
        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String currentText = display.getText().toString();

                if (isNewOperation || currentText.equals("0") || operationClicked) {
                    currentText = "";
                    isNewOperation = false;
                }

                display.setText(currentText + button.getText().toString());
                operationClicked = false;
            }
        };

        // Asignar a todos los botones numéricos
        findViewById(R.id.zero).setOnClickListener(numberListener);
        findViewById(R.id.one).setOnClickListener(numberListener);
        findViewById(R.id.two).setOnClickListener(numberListener);
        findViewById(R.id.three).setOnClickListener(numberListener);
        findViewById(R.id.four).setOnClickListener(numberListener);
        findViewById(R.id.five).setOnClickListener(numberListener);
        findViewById(R.id.six).setOnClickListener(numberListener);
        findViewById(R.id.seven).setOnClickListener(numberListener);
        findViewById(R.id.eight).setOnClickListener(numberListener);
        findViewById(R.id.nine).setOnClickListener(numberListener);

        // Listener para las operaciones
        View.OnClickListener operationListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.isEmpty()) {
                    secondValue = Double.parseDouble(display.getText().toString());
                    performOperation();
                }

                Button button = (Button) v;
                firstValue = Double.parseDouble(display.getText().toString());
                operation = button.getText().toString();
                display.setText(firstValue + " " + operation);
                operationClicked = true;
            }
        };

        findViewById(R.id.add).setOnClickListener(operationListener);
        findViewById(R.id.subtract).setOnClickListener(operationListener);
        findViewById(R.id.multiply).setOnClickListener(operationListener);
        findViewById(R.id.divide).setOnClickListener(operationListener);

        // Botón de igual
        findViewById(R.id.equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.isEmpty()) {
                    secondValue = Double.parseDouble(display.getText().toString());
                    performOperation();
                    operation = "";
                }
            }
        });

        // Botón de limpiar
        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
                firstValue = 0;
                secondValue = 0;
                operation = "";
                isNewOperation = true;
            }
        });

        // Botón de punto decimal
        findViewById(R.id.decimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = display.getText().toString();
                if (!currentText.contains(".")) {
                    display.setText(currentText + ".");
                }
            }
        });

        // Botón de borrar un dígito
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = display.getText().toString();
                if (currentText.length() > 1) {
                    display.setText(currentText.substring(0, currentText.length() - 1));
                } else {
                    display.setText("0");
                }
            }
        });
    }

    // Método para realizar las operaciones
    private void performOperation() {
        double result = 0;

        switch (operation) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "×":
                result = firstValue * secondValue;
                break;
            case "÷":
                if (secondValue != 0) {
                    result = firstValue / secondValue;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }

        display.setText(String.valueOf(result));
        firstValue = result; // Continuar operaciones con el resultado
        isNewOperation = true;
    }
}
