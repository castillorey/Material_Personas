package com.kevinmcr.material_personas;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearPersona extends AppCompatActivity {
    private EditText txtCedula, txtNombre, txtApellido;
    private Spinner cmbSexo;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);

        txtCedula = findViewById(R.id.txtCedula);
        txtApellido = findViewById(R.id.txtApellido);
        txtNombre = findViewById(R.id.txtNombre);
        cmbSexo = findViewById(R.id.cmbSexo);

        opc = this.getResources().getStringArray(R.array.sexo);
        adapter = new ArrayAdapter<String>(this,R.layout.custom_spinner,opc);
        cmbSexo.setAdapter(adapter);

        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public void guardar(View v){
        String ced, nomb, apell,id;
        int sexo, foto;
        foto = Datos.fotoAleatoria(fotos);
        ced = txtCedula.getText().toString();
        apell = txtApellido.getText().toString();
        nomb = txtNombre.getText().toString();
        sexo = cmbSexo.getSelectedItemPosition();
        id = Datos.getId();

        Persona p = new Persona(id,ced,nomb,apell,foto,sexo);
        p.guardar();
        Snackbar.make(v, getResources().getString(R.string.mensaje_guardado_exitoso), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtCedula.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        cmbSexo.setSelection(0);
        txtCedula.requestFocus();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent (CrearPersona.this,Principal.class);
        startActivity(i);
    }
}
