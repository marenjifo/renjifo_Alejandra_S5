package com.example.mariarenjifo.renjifo_alejandra_s5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    NoticiaAdapter customAdapter;
    EditText et_nombre;
    EditText et_telefono;
    Switch sw_genero;
    Button btn_generar;
    String genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_noticias=findViewById(R.id.lv_noticias);
        customAdapter= new NoticiaAdapter(this);
        lv_noticias.setAdapter(customAdapter);
        et_nombre=findViewById(R.id.et_nombre);
        et_telefono=findViewById(R.id.et_telefono);
        sw_genero=findViewById(R.id.sw_genero);
        btn_generar=findViewById(R.id.btn_generar);

        //Noticia noticia1= new Noticia("Cambio en hoy es diseño","Va a haber un cambio en el logo","30/08/18");
       // Noticia noticia2= new Noticia("Nueva cafeteria","Hay un nuevo restaurante en la U","30/08/18");

      //  customAdapter.agregarNoticia(noticia1);
       // customAdapter.agregarNoticia(noticia2);

        lv_noticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Noticia noticia_click = (Noticia) customAdapter.getItem(position);
                Toast.makeText(MainActivity.this,noticia_click.getNombre(),Toast.LENGTH_SHORT).show();

            }
        });

        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



              if(sw_genero.isChecked()){
                  genero="Mujer";
              }else{
                  genero="Hombre";
              }



                String nombre= et_nombre.getText().toString();
                String telefono=et_telefono.getText().toString();
                Noticia newNoticia= new Noticia (nombre, telefono,genero);
                et_nombre.setText("");
                et_telefono.setText("");
                sw_genero.setChecked(false);
                customAdapter.agregarNoticia(newNoticia);
            }
        });
    }
}
