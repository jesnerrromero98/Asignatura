package com.example.asignaturas;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mylist;

    List<String> Asignatura = new ArrayList<String>(Arrays.asList("Investigacion Aplicada", "Facultativa II", "Planificación TIC"));
    EditText editTextAsignatura;
    MyAdapterList Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextAsignatura = (EditText)findViewById(R.id.editTextAsignatura);
        mylist = (ListView) findViewById(R.id.list1);
        fillList();
        SelectItemList();
    }
    void fillList() {
        Adapter=new MyAdapterList(this, R.layout.item_list,Asignatura);
        mylist.setAdapter(Adapter);
    }
    void SelectItemList(){
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Asignatura: "+Asignatura.get(position),Toast.LENGTH_LONG).show();
            }
        }) ;
    }

    void add(String asignatura) {
        if(!asignatura.isEmpty())
        {
            Asignatura.add(asignatura);
            editTextAsignatura.setText("");
            fillList();
            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Es necesario añadir la asignatura", Toast.LENGTH_SHORT).show();
        }
    }

    public void Guardar_OnClick(View v)
    {
        String asignatura = editTextAsignatura.getText().toString();
        add(asignatura);
    }
}

