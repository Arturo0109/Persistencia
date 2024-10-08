package com.example.formulario;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VerRegistrosActivity extends AppCompatActivity {

    private EditText etBuscarID;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_registros);

        etBuscarID = findViewById(R.id.etBuscarID);
        tvResultado = findViewById(R.id.tvResultado);
    }

    // Buscar un registro por ID
    public void buscarPorID(View view) {
        String idTexto = etBuscarID.getText().toString();

        if (!idTexto.isEmpty()) {
            try {
                // Crear el nombre del archivo basado en el ID ingresado
                String nombreArchivo = "Usuario_" + idTexto + ".txt"; // Suponiendo que el archivo se guarda con este formato

                // Leer el contenido del archivo
                InputStreamReader archivo = new InputStreamReader(openFileInput(nombreArchivo));
                BufferedReader br = new BufferedReader(archivo);
                StringBuilder texto = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    texto.append(linea).append("\n");
                }
                br.close();
                archivo.close();

                // Mostrar la información en el TextView
                tvResultado.setText(texto.toString());

            } catch (Exception e) {
                Toast.makeText(this, "No se encontró ningún registro con ese ID", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor ingresa un ID", Toast.LENGTH_SHORT).show();
        }
    }
}
