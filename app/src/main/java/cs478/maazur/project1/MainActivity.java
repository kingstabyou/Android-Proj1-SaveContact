package cs478.maazur.project1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
        if(requestCode==RESULT_OK){
            String name=data.getStringExtra("Message");
            Log.i("ter",name);
        }else if (requestCode==RESULT_CANCELED){
                Log.i("ee","fail");
        }else{
            Log.i("ee","fail");
        }

        }
    }

