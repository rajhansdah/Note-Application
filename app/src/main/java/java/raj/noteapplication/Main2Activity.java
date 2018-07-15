package java.raj.noteapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText title,content;
    Button update,delete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        title=findViewById(R.id.editText2);
        content=  findViewById(R.id.editText3);
        update =  findViewById(R.id.button);
        delete =   findViewById(R.id.button3);
        final DBClass dbClass=new DBClass(getApplicationContext());

        Bundle bundle = getIntent().getExtras();

        String str1 = bundle.getString("Title");
        String str2 = bundle.getString("Content");

        title.setText(str1);
        content.setText(str2);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBClass  dbClass =  new DBClass(Main2Activity.this);
               dbClass.onUpdate(title.getText().toString(), content.getText().toString());
                Toast.makeText(Main2Activity.this,"File updated",Toast.LENGTH_LONG).show();
                Intent intent1 =  new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent1);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DBClass dbClass = new DBClass(Main2Activity.this);
                dbClass.onDelete(title.getText().toString());
                Intent intent2 =  new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent2);
                Toast.makeText(Main2Activity.this,"item is deleted",  Toast.LENGTH_LONG).show();

            }
        });

    }
}
