package com.example.myfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.myfirebase.FBref.refGrades;
import static com.example.myfirebase.FBref.refStudents;

public class Infore extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<String> stuList = new ArrayList<>();
    ArrayList<Student> stuValues = new ArrayList<>();
    ValueEventListener stuListener;

    ArrayList<String> graList = new ArrayList<>();
    ArrayList<Grades> graValues = new ArrayList<>();
    ValueEventListener graListener;

    int itemDelete, Type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infore);
        listView = (ListView) findViewById(R.id.Infor);


        listView.setOnItemClickListener(this);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }

    public void GB(View view) {
        Type = 1;
        graList.clear();
        graValues.clear();

        graListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dS) {
                for(DataSnapshot data: dS.getChildren()){
                    String Name = data.getKey();
                    Grades tmp = data.getValue(Grades.class);
                    graValues.add(tmp);
                    int Qua = tmp.getQuarter();
                    graList.add(Name+" "+ Qua);
                }
                ArrayAdapter adp = new ArrayAdapter<String>(Infore.this,R.layout.support_simple_spinner_dropdown_item, graList);
                listView.setAdapter(adp);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        };
        refGrades.addValueEventListener(graListener);

    }

    public void SB(View view) {
        Type = 2;
        stuList.clear();
        stuValues.clear();

         stuListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dS) {
                for(DataSnapshot data: dS.getChildren()){
                    String str1 = data.getKey();
                    Student tmp = data.getValue(Student.class);
                    stuValues.add(tmp);
                    String str2 = tmp.getAddress();
                    stuList.add(str1+" "+ str2);
                }
               ArrayAdapter adp = new ArrayAdapter<String>(Infore.this,R.layout.support_simple_spinner_dropdown_item, stuList);
                listView.setAdapter(adp);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        };
        refStudents.addValueEventListener(stuListener);
    }

    public void Delete(View view) {
        if(Type == 1){
            refGrades.child(graValues.get(itemDelete).getName()).removeValue();
        } else{
            refStudents.child(stuValues.get(itemDelete).getName()).removeValue();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        itemDelete = position;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (stuListener!=null) {
            refStudents.removeEventListener(stuListener);
        }

        if(id == R.id.Main){
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
            return true;
        }else if (id == R.id.Sort){
            Intent si = new Intent(this, Sort.class);
            startActivity(si);
            return true;
        }
        return true;
    }

}