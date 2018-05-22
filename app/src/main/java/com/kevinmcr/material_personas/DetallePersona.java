package com.kevinmcr.material_personas;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePersona extends AppCompatActivity {
    private TextView tvCedulaDetalle, tvNombreDetalle, tvApellidoDetalle, tvSexoDetalle;
    private String[] sexos;
    private ImageView imgFotoDetalle;
    private String cedula, nombre, apellido, id;
    private int foto, sexo;
    private Intent i;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);

        tvCedulaDetalle = findViewById(R.id.lblCedulaDetalle);
        tvNombreDetalle = findViewById(R.id.lblNombreDetalle);
        tvApellidoDetalle = findViewById(R.id.lblApellidoDetalle);
        tvSexoDetalle = findViewById(R.id.lblSexoDetalle);
        imgFotoDetalle = findViewById(R.id.imgFotoDetalle);
        sexos = getResources().getStringArray(R.array.sexo);

        i = getIntent();
        bundle = getIntent().getBundleExtra("datos");
        cedula = bundle.getString("cedula");
        nombre = bundle.getString("nombre");
        apellido = bundle.getString("apellido");
        sexo = bundle.getInt("sexo");
        foto = bundle.getInt("foto");
        id = bundle.getString("id");

        tvCedulaDetalle.setText(cedula);
        tvNombreDetalle.setText(nombre);
        tvApellidoDetalle.setText(apellido);
        tvSexoDetalle.setText(sexos[sexo]);
        imgFotoDetalle.setImageResource(foto);

    }

    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Persona p = new Persona(id);
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetallePersona.this,Principal.class);
        startActivity(i);
    }
}
