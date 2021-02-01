package cs478.maazur.project1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String fullname;
    String Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Enter_Name(View view){
        Intent intent = new Intent(this,Input_Screen.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fullname=data.getStringExtra("Message");
       Log.i("maaz",fullname);
        if(resultCode==-1){
            Result="True";
        }else if (resultCode==0){
            Result="False";
        }else{
            Log.i("ee","invalid");
        }
        }

    public void FetchContact(View view){
       Log.i("maaz",fullname);
        if (Result.equals("False")){
            Toast.makeText(getApplicationContext(),"Incorrect name Entered - "+fullname,Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Correct name Entered - "+fullname,Toast.LENGTH_SHORT).show();
        }
    }
}


