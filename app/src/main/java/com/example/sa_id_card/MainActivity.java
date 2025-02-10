package com.example.sa_id_card;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText etCnic;
    Button btnClear;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String id=etCnic.getText().toString().trim();
                parseID(id);
            }
        });
    }

    private void parseID(String id){
        if(id.isEmpty())
        {
            etCnic.setError("Id is empty!");
        }
        else if(id.length()>13 || id.length()<13){
            Toast.makeText(MainActivity.this,"ID is not 13 digits long",Toast.LENGTH_SHORT).show();
        }
        else{
            String dob=id.substring(0,6); //extracting the date of buirth from id card number i.e. first 6 digits
            // extracting seperate values from full dob
            String year=dob.substring(0,2);

//            as month is in int format in given id so we need to convert it to respective month name
            String []months = new String[]{"","January", "Feb", "March","April", "May", "June", "July", "Aug",
                    "Sept", "Oct", "Nov", "Dec"};

            String month=months[Integer.parseInt(dob.substring(2, 4))];
            String day=dob.substring(4,6);

//          Storing extracted proper dob in result
            String result="Date of birth is "+day+" "+month+","+" 19"+year+"\n";

//          extracting the gender from given id number
            String gender=id.substring(6,10);
//            check if male or female
            if(Integer.parseInt(gender)>=0 && Integer.parseInt(gender)<=4999){
                result=result+"Gender:Female"+"\n";
            }
            else if(Integer.parseInt(gender)>=5000 && Integer.parseInt(gender)<=9999){
                result=result+"Gender:Male"+"\n";
            }

//            extracting citizenship from given id
            char citizenship=id.charAt(10);
//            0 means SA citizen and 1 means Permanent citizen so checking this now
            if(citizenship=='0'){
                result=result+"Citizenship status: South African Citizen"+"\n";
            }
            else if(citizenship=='1'){
                result=result+"Citizenship status: Permanent Citizen"+"\n";
            }

//            checking verification if id
            char checksum=id.charAt(12);

//            0 means invalid, all other mean valid
            if(checksum=='0'){
                result=result+"Number is invalid";
            }
            else{
                result=result+"Number is valid";
            }

//            Storing final id card details in actual text view
            tvResult.setText(result);
            tvResult.setTextSize(18);
        }
    }



    private void init(){
        etCnic=findViewById(R.id.etCnic);
        btnClear=findViewById(R.id.btnClear);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvResult=findViewById(R.id.tvResult);
    }

    public void btnClearClicked(View v){
        etCnic.setText("");
    }
}