package com.example.formulario;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static int contadorID = 1; // Inicia el ID en 1



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToIngresar(View view) {
        Intent intent = new Intent(this, FormularioActivity.class);
        startActivity(intent);
    }

    public void goToVerRegistros(View view) {
        Intent intent = new Intent(this, VerRegistrosActivity.class);
        startActivity(intent);
    }

    public void goToEditarRegistro(View view) {
        Intent intent = new Intent(this, EditarRegistroActivity.class);
        startActivity(intent);
    }
    public void goToCalculadora(View view) {
        Intent intent = new Intent(this, Calculadora.class);
        startActivity(intent);
    }



    public void salirApp(View view) {
        finish();
        System.exit(0);
    }

}
