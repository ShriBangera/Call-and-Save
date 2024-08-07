package com.bangera.callandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num=findViewById(R.id.number);
    }
    public void delete(View v)
    {
        String mynum=num.getText().toString();
        mynum=mynum.substring(0,mynum.length()-1);
        num.setText(mynum);
    }

    public void number(View v)
    {
        Button b=(Button) v;
        String n=(String)  b.getText();
        num.append(n);
    }
    public void call(View v)
    {
        String number=num.getText().toString();
        Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
        startActivity(i);
    }
    public void save(View v)
    {
        String number=num.getText().toString();
        Intent i=new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);
        i.putExtra(ContactsContract.Intents.Insert.PHONE,number);
        startActivity(i);

    }
}