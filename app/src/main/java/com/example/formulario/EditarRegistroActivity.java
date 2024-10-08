package com.example.formulario;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class EditarRegistroActivity extends AppCompatActivity {

    private EditText etBuscarID;
    private EditText etNombre, etApellidos, etDocumento, etEdad, etTelefono, etFechaNacimiento, etDireccion, etEmail;
    private TextView tvCodigoID;
    private String idBuscado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_registro);

        etBuscarID = findViewById(R.id.etBuscarID);
        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etDocumento = findViewById(R.id.etDocumento);
        etEdad = findViewById(R.id.etEdad);
        etTelefono = findViewById(R.id.etTelefono);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        etDireccion = findViewById(R.id.etDireccion);
        etEmail = findViewById(R.id.etEmail);
        tvCodigoID = findViewById(R.id.tvCodigoID);
    }

    // Método para buscar el registro por ID
    public void buscarRegistro(View view) {
        String idTexto = etBuscarID.getText().toString();

        if (!idTexto.isEmpty()) {
            idBuscado = idTexto; // Guardar el ID buscado
            String nombreArchivo = "Usuario_" + idBuscado + ".txt"; // Suponiendo que el archivo se guarda con este formato

            try {
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

                // Llenar los campos de texto con la información del archivo
                String[] datos = texto.toString().split("\n");
                if (datos.length >= 8) {
                    etNombre.setText(datos[0]);
                    etApellidos.setText(datos[1]);
                    etDocumento.setText(datos[2]);
                    etEdad.setText(datos[3]);
                    etTelefono.setText(datos[4]);
                    etFechaNacimiento.setText(datos[5]);
                    etDireccion.setText(datos[6]);
                    etEmail.setText(datos[7]);
                    tvCodigoID.setText("ID: " + idBuscado);
                } else {
                    Toast.makeText(this, "Datos incompletos en el archivo", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "No se encontró ningún registro con ese ID", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor ingresa un ID", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para guardar los cambios realizados
    public void guardarCambios(View view) {
        String nombreArchivo = "Usuario_" + idBuscado + ".txt"; // Suponiendo que el archivo se guarda con este formato

        try {
            // Abrir el archivo para escribir
            FileOutputStream fos = openFileOutput(nombreArchivo, MODE_PRIVATE);
            String datos = etNombre.getText().toString() + "\n" +
                    etApellidos.getText().toString() + "\n" +
                    etDocumento.getText().toString() + "\n" +
                    etEdad.getText().toString() + "\n" +
                    etTelefono.getText().toString() + "\n" +
                    etFechaNacimiento.getText().toString() + "\n" +
                    etDireccion.getText().toString() + "\n" +
                    etEmail.getText().toString();
            fos.write(datos.getBytes());
            fos.close();

            Toast.makeText(this, "Registro actualizado exitosamente", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al guardar los cambios", Toast.LENGTH_SHORT).show();
        }
    }
}
