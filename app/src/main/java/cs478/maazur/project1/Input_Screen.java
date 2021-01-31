package cs478.maazur.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Input_Screen extends AppCompatActivity {
 public static final String EXTRA_MESSAGE="name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input__screen);
    }



    public void Full_Name(View view){
        EditText name = (EditText) findViewById(R.id.Input_Fullname);
        String fullname= name.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE,fullname);
        setResult(RESULT_OK,intent);
        finish();
    }
}