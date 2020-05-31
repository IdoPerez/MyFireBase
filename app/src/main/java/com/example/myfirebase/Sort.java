package com.example.myfirebase;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.myfirebase.FBref.refStudents;

/**
 * @author Ido Perez
 * @since 2.9.03
 * @version 001
 */
public class Sort extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<String> stuList = new ArrayList<>();
    ArrayList<Student> stuValues = new ArrayList<>();

    ArrayList<Integer> graList = new ArrayList<>();
    ArrayList<Grades> graValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        listView = (ListView) findViewById(R.id.lv);

        listView.setOnItemClickListener(this);
        listView.setChoiceMode(listView.CHOICE_MODE_SINGLE);
    }

    /**
     * the method sorting the grades of all the students from the bigger to lower
     * @param view
     */
    public void SortByGrade(View view) {
        graValues.clear();
        graList.clear();

        Query query = refStudents.orderByChild("Grade");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Grades grade = dataSnapshot.getValue(Grades.class);
                    int tmp = grade.getGrade();
                    graList.add(tmp);
                }
                ArrayAdapter adp = new ArrayAdapter<Integer>(Sort.this,R.layout.support_simple_spinner_dropdown_item, graList);
                listView.setAdapter(adp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    /**
     * the method sorting the names of the students from a - z.
     * @param view
     */
    public void SortByName(View view) {
          stuList.clear();
          stuValues.clear();

        Query query = refStudents.orderByKey();
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    String str1 = data.getKey();
                    Student tmp = data.getValue(Student.class);
                    stuValues.add(tmp);
                    stuList.add(str1);
                }
                ArrayAdapter adp = new ArrayAdapter<String>(Sort.this,R.layout.support_simple_spinner_dropdown_item, stuList);
                listView.setAdapter(adp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.Main){
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
            return true;
        }else if (id == R.id.Infor){
            Intent si = new Intent(this, Infore.class);
            startActivity(si);
            return true;
        }
        return true;
    }
}
