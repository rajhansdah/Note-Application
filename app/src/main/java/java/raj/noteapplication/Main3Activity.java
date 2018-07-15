package java.raj.noteapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText content,title;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        content =  findViewById(R.id.editText4);
        title =  findViewById(R.id.editText);
        save =  findViewById(R.id.button2);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(title.getText().toString().isEmpty())
                {
                    Toast.makeText(Main3Activity.this,"Note is Empty",Toast.LENGTH_LONG).show();
                }
                else {
                    DBClass dbClass = new DBClass(Main3Activity.this);
                    dbClass.addData(title.getText().toString(), content.getText().toString());
                    Toast.makeText(Main3Activity.this,"File seved",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
