package cs478.maazur.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Input_Screen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input__screen);
        Button button1 =(Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.Input_Fullname);
                String fullname= name.getText().toString().trim();
                Log.i("ter",fullname);
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("Message",fullname);
                if(1==1) {
                    setResult(RESULT_OK, intent);
                }else {
                    setResult(RESULT_CANCELED, intent);
                }
                finish();
            }
        });
    }
}