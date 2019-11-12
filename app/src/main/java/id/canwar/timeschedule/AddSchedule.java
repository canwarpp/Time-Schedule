package id.canwar.timeschedule;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddSchedule extends AppCompatActivity implements View.OnClickListener{

    private EditText etTittle;
    private TextView btnStart;
    private TextView btnEnd;
    private EditText etRoom;
    private EditText etInfo;
    private Button btnSave;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etTittle = findViewById(R.id.etTittle);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        etRoom = findViewById(R.id.etRoom);
        etInfo = findViewById(R.id.etInfo);
        btnSave = findViewById(R.id.btnSave);
        database = new Database(this);

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                // jika klik save
                long newRowId = database.addSchedule(this,
                        etTittle.getText().toString().trim(),
                        btnStart.getText().toString().trim(),
                        btnEnd.getText().toString().trim(),
                        etInfo.getText().toString().trim());
                if(newRowId == -1){
                    Log.i("Error", "Insert falied");
                }else {
                    Log.i("Info", "Database saved");
                }
                Log.i("info", "Button save pressed");
        }
    }
}
