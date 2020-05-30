package com.example.myfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static com.example.myfirebase.FBref.refGrades;
import static com.example.myfirebase.FBref.refStudents;

public class MainActivity extends AppCompatActivity {
    EditText Name,Address, Phone_Num, Home_Num,Father,Mother,Mom_Num, Dad_Num, NameGrade, Quarter, Subject,Grade ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.Name);
        Address = (EditText) findViewById(R.id.Address);
        Phone_Num = (EditText) findViewById(R.id.Phone_Num);
        Home_Num = (EditText) findViewById(R.id.Home_Num);
        Father = (EditText) findViewById(R.id.Father);
        Mother = (EditText) findViewById(R.id.Mother);
        Mom_Num = (EditText) findViewById(R.id.Mom_Num);
        Dad_Num = (EditText) findViewById(R.id.Dad_Num);

        //Grades
        NameGrade = (EditText) findViewById(R.id.NameGrades);
        Quarter = (EditText) findViewById(R.id.Quarter);
        Subject = (EditText) findViewById(R.id.Subject);
        Grade = (EditText) findViewById(R.id.Grade);
    }

    public void GB(View view) {

        String name = NameGrade.getText().toString();
        String Qua = Quarter.getText().toString();
        String sub = Subject.getText().toString();
        String grade = Grade.getText().toString();

        Grades Grade = new Grades(name, Integer.parseInt(Qua), sub, Integer.parseInt(grade), true);
        refGrades.child(name).setValue(Grade);
    }


    public void SB(View view) {
        String st[] = new String[8];
        st[0] = Name.getText().toString();
        st[1] = Address.getText().toString();
        st[2] = Phone_Num.getText().toString();
        st[3] = Home_Num.getText().toString();
        st[4] = Father.getText().toString();
        st[5] = Mother.getText().toString();
        st[6] = Mom_Num.getText().toString();
        st[7] = Dad_Num.getText().toString();

        Student student = new Student(st[0], st[1], st[2], st[3], st[4], st[5], st[6], st[7], true);
        refStudents.child(st[0]).setValue(student);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.Infore){
            Intent si = new Intent(this, Infore.class);
            startActivity(si);
            return true;
        } else if (id == R.id.Sort){
            Intent si = new Intent(this, Sort.class);
            startActivity(si);
            return true;
        }
        return true;
    }
}
