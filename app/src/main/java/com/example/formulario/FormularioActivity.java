package com.example.formulario;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.OutputStreamWriter;

public class FormularioActivity extends AppCompatActivity {

    // Campos del formulario de información personal
    private EditText etNombre, etApellidos, etDocumento, etEdad, etTelefono, etFechaNacimiento, etDireccion, etEmail;
    private RadioButton rbCasado, rbSoltero, rbMasculino, rbFemenino, rbNoBinario;

    // Campos del formulario de gustos
    private CheckBox cbMusica, cbDeporte, cbCine, cbComida, cbViajes, cbLibros;
    private Spinner spinnerEquipoFutbol;

    // Campos del formulario de información adicional
    private EditText etPeliculaFavorita, etColorFavorito, etComidaFavorita, etLibroFavorito, etDescripcion;
    private TextView tvCodigoID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        // Inicialización de los campos de información personal
        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etDocumento = findViewById(R.id.etDocumento);
        etEdad = findViewById(R.id.etEdad);
        etTelefono = findViewById(R.id.etTelefono);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        etDireccion = findViewById(R.id.etDireccion);
        etEmail = findViewById(R.id.etEmail);
        rbCasado = findViewById(R.id.rbCasado);
        rbSoltero = findViewById(R.id.rbSoltero);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        rbNoBinario = findViewById(R.id.rbNoBinario);

        // Inicialización de los campos de gustos
        cbMusica = findViewById(R.id.cbMusica);
        cbDeporte = findViewById(R.id.cbDeporte);
        cbCine = findViewById(R.id.cbCine);
        cbComida = findViewById(R.id.cbComida);
        cbViajes = findViewById(R.id.cbViajes);
        cbLibros = findViewById(R.id.cbLibros);
        spinnerEquipoFutbol = findViewById(R.id.spinnerEquipoFutbol);

        // Inicialización de los campos de información adicional
        etPeliculaFavorita = findViewById(R.id.etPeliculaFavorita);
        etColorFavorito = findViewById(R.id.etColorFavorito);
        etComidaFavorita = findViewById(R.id.etComidaFavorita);
        etLibroFavorito = findViewById(R.id.etLibroFavorito);
        etDescripcion = findViewById(R.id.etDescripcion);

        // Mostrar el ID autoincrementable
        tvCodigoID = findViewById(R.id.tvCodigoID);
        tvCodigoID.setText("Su código ID es: " + MainActivity.contadorID);
    }

    // Guardar toda la información en un solo evento
    public void guardarInformacion(View view) {
        if (validarCampos()) {
            // Recolectar información personal
            String estadoCivil = rbCasado.isChecked() ? "Casado" : "Soltero";
            String genero = rbMasculino.isChecked() ? "Masculino" : rbFemenino.isChecked() ? "Femenino" : "No Binario";
            String gustos = obtenerGustosSeleccionados();

            // Contenido a guardar
            String contenido = "ID: " + MainActivity.contadorID + "\n" +
                    "Nombre: " + etNombre.getText().toString() + "\n" +
                    "Apellidos: " + etApellidos.getText().toString() + "\n" +
                    "Documento: " + etDocumento.getText().toString() + "\n" +
                    "Edad: " + etEdad.getText().toString() + "\n" +
                    "Teléfono: " + etTelefono.getText().toString() + "\n" +
                    "Fecha de Nacimiento: " + etFechaNacimiento.getText().toString() + "\n" +
                    "Dirección: " + etDireccion.getText().toString() + "\n" +
                    "Email: " + etEmail.getText().toString() + "\n" +
                    "Estado Civil: " + estadoCivil + "\n" +
                    "Género: " + genero + "\n" +
                    "Gustos: " + gustos + "\n" +
                    "Equipo de Fútbol: " + spinnerEquipoFutbol.getSelectedItem().toString() + "\n" +
                    "Película Favorita: " + etPeliculaFavorita.getText().toString() + "\n" +
                    "Color Favorito: " + etColorFavorito.getText().toString() + "\n" +
                    "Comida Favorita: " + etComidaFavorita.getText().toString() + "\n" +
                    "Libro Favorito: " + etLibroFavorito.getText().toString() + "\n" +
                    "Descripción: " + etDescripcion.getText().toString();

            // Guardar en archivo
            String nombreArchivo = etNombre.getText().toString() + "_" + etDocumento.getText().toString() + ".txt";

            try {
                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombreArchivo, Context.MODE_PRIVATE));
                archivo.write(contenido);
                archivo.flush();
                archivo.close();

                Toast.makeText(this, "Se guardaron los datos", Toast.LENGTH_SHORT).show();

                // Incrementar el ID para el próximo usuario
                MainActivity.contadorID++;

                // Volver al MainActivity (Menú)
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

            } catch (Exception e) {
                Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para obtener los gustos seleccionados
    private String obtenerGustosSeleccionados() {
        StringBuilder gustos = new StringBuilder();
        if (cbMusica.isChecked()) gustos.append("Música ");
        if (cbDeporte.isChecked()) gustos.append("Deporte ");
        if (cbCine.isChecked()) gustos.append("Cine ");
        if (cbComida.isChecked()) gustos.append("Comida ");
        if (cbViajes.isChecked()) gustos.append("Viajes ");
        if (cbLibros.isChecked()) gustos.append("Libros ");
        return gustos.toString().trim();
    }

    // Método de validación
    private boolean validarCampos() {
        return !etNombre.getText().toString().isEmpty() &&
                !etApellidos.getText().toString().isEmpty() &&
                !etDocumento.getText().toString().isEmpty() &&
                !etEdad.getText().toString().isEmpty() &&
                !etTelefono.getText().toString().isEmpty() &&
                !etFechaNacimiento.getText().toString().isEmpty() &&
                !etDireccion.getText().toString().isEmpty() &&
                !etEmail.getText().toString().isEmpty() &&
                etEmail.getText().toString().contains("@") &&
                !spinnerEquipoFutbol.getSelectedItem().toString().equals("Selecciona un equipo") &&
                !etPeliculaFavorita.getText().toString().isEmpty() &&
                !etColorFavorito.getText().toString().isEmpty() &&
                !etComidaFavorita.getText().toString().isEmpty() &&
                !etLibroFavorito.getText().toString().isEmpty() &&
                !etDescripcion.getText().toString().isEmpty();
    }
}
