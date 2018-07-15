package java.raj.noteapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button plus;
    ArrayList<String> totaLiist;
    ArrayList<String> titleList;
    ArrayList<String> contentList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        plus =  findViewById(R.id.add_1);


        totaLiist = new ArrayList<>();
        titleList = new ArrayList<>();
        contentList = new ArrayList<>();


        final DBClass dBclass= new DBClass(MainActivity.this);
        Cursor cursor = dBclass.getData();

        if(cursor.moveToFirst()) {
            do {


                String title_f = cursor.getString(cursor.getColumnIndex("Title"));
                String type_f = cursor.getString(cursor.getColumnIndex("Type"));

                titleList.add(title_f);
                contentList.add(type_f);



                ArrayList<String> finalData = new ArrayList<>();

                for (int i = 0; i < titleList.size(); i++) {

                    finalData.add(titleList.get(i) + "\n" + contentList.get(i));
                }
                totaLiist.add(title_f + "\n" + type_f);



            }
            while (cursor.moveToNext());
            {
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1, totaLiist);
                listView.setAdapter(arrayAdapter);
            }

        }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.putExtra("Title", titleList.get(i));
                    intent.putExtra("Content", contentList.get(i));

                    startActivity(intent);
                }
            });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"click",Toast.LENGTH_SHORT).show();
            }
        });





    }
}
