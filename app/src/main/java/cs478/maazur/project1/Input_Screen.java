package cs478.maazur.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Input_Screen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input__screen);
        EditText name = (EditText) findViewById(R.id.Input_Fullname);
        name.setImeActionLabel("Reply", EditorInfo.IME_ACTION_SEND);
        name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String fullname = name.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Message", fullname);
                if (fullname.matches(".*\\d.*") || !fullname.contains(" ")) {
                    setResult(RESULT_CANCELED, intent);
                } else {
                    setResult(RESULT_OK, intent);
                }
                finish();
                return  true;
            }
        });




/*        Button button1 =(Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.Input_Fullname);
                String fullname= name.getText().toString().trim();
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("Message",fullname);
                if(fullname.matches(".*\\d.*") || !fullname.contains(" ")) {
                    setResult(RESULT_CANCELED, intent);
                }else {
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });*/
    }

}