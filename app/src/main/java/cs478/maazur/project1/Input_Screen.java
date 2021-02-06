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
        // take name input and run an onEditorActionListener to check on press of enter run a logic
        EditText name = (EditText) findViewById(R.id.Input_Fullname);
       // name.setImeActionLabel("Reply", EditorInfo.IME_ACTION_SEND);
        name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event==null) {
                    // validate name to remove leading and trailing whitespaces as well as check for any digits and spaces in a name to make it a real name
                    String fullname = name.getText().toString().trim();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("Message", fullname);
                    if (fullname.matches(".*\\d.*") || !fullname.contains(" ")) {
                        setResult(RESULT_CANCELED, intent);  //send invalid result back to parent
                    } else {
                        setResult(RESULT_OK, intent);        //send valid result back to parent
                    }
                    finish();
                }
                return true;
            }
        });

    }

}