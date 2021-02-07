package cs478.maazur.project1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String fullname;
    boolean result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {                                            // run on create
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {                                  // save fullname and result variables so that on change of portrait variables are not disposed
        super.onSaveInstanceState(outState);
        outState.putString("Name",fullname);
        outState.putBoolean("Result",result);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {                     // restore saved variables
        super.onRestoreInstanceState(savedInstanceState);
        fullname=savedInstanceState.getString("Name");
        result=savedInstanceState.getBoolean("Result");
    }



    public void enter_Name(View view){                                                              // call Inputscreen activity to input name
        Intent intent = new Intent(this,Input_Screen.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {       // check and set result variable according to the result received from Inputscreen
        super.onActivityResult(requestCode, resultCode, data);
        /*Integer x = resultCode;
        Log.i("test",x.toString());*/
        if(resultCode==-1){
            fullname=data.getStringExtra("Message");
            result=true;
        }else if (resultCode==1){
            fullname=data.getStringExtra("Message");
            result=false;
        }else{
            fullname=null;
            result=false;
        }
        }


    public void fetchContact(View view){                                                            // create new contact with the name received from calling the first activity(using implicit intents
        if (result){
            Intent intentContactEdit = new Intent(Intent.ACTION_INSERT);
            intentContactEdit.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            intentContactEdit.putExtra(ContactsContract.Intents.Insert.NAME,fullname);
            startActivity(intentContactEdit);
        } else if(fullname==null) {
            Toast.makeText(getApplicationContext(),"No Name has been entered, please press Enter Name",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Incorrect name Entered - "+fullname,Toast.LENGTH_SHORT).show();
        }


    }
}


