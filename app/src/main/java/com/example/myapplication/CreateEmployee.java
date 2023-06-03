package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.dao.Database;
import com.example.myapplication.entity.Employee;

public class CreateEmployee extends AppCompatActivity {
    EditText edEmployeeName;
    EditText edEmployeePassword;
    EditText edEmployeeEmail;
    EditText edEmployeeContact;
    Button btn;
    TextView tv;

    Spinner  spinnerDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employee);



        edEmployeeName=findViewById(R.id.name);
        edEmployeePassword=findViewById(R.id.password);
        edEmployeeEmail=findViewById(R.id.email);
        edEmployeeContact=findViewById(R.id.contact);
        btn=findViewById(R.id.submit);
        tv=findViewById(R.id.coname);
        spinnerDepartment=findViewById(R.id.spinnerEmpDepartment);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee emp=new Employee();


                String name= edEmployeeName.getText().toString();
                String  password=edEmployeePassword.getText().toString();
                String email=edEmployeeEmail.getText().toString();
                Integer contact = Integer.valueOf(edEmployeeContact.getText().toString());
                String coName=tv.getText().toString();
                String department=spinnerDepartment.getSelectedItem().toString();


                emp.setName(name);
                emp.setPassword(password);
                emp.setContact(contact);
                emp.setEmail(email);
                emp.setDepartment(department);



                Database database = new Database(getApplicationContext(),"healthcare",null,1);


//                Toast.makeText(getApplicationContext(),"Name: "+name+ "Password: "+password+"Com Name: " +coName +"Email: "+email,Toast.LENGTH_SHORT).show();

                if( name.length()==0 ||  password.length()==0 || email.length()==0 || department.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill All The Data Field",Toast.LENGTH_SHORT).show();
                }else {
                    database.addNewEmployee(emp);

                    Toast.makeText(getApplicationContext(),"Employeed added..",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}