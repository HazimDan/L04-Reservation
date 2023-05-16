package sg.edu.rp.c346.id22012867.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText contact;
    EditText NOG;
    CheckBox smokeYes;
    CheckBox smokeNo;
    Button btnSubmit;
    Button btnReset;
    TextView txtDisplay;
    DatePicker dp;
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        contact = findViewById(R.id.editNumber);
        NOG = findViewById(R.id.NOG);
        smokeYes = findViewById(R.id.smokeYes);
        smokeNo = findViewById(R.id.smokeNo);
        btnSubmit = findViewById(R.id.submit);
        btnReset = findViewById(R.id.reset);
        txtDisplay = findViewById(R.id.txtDisplay);
        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);

        dp.init(2020,5, 1, null);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (smokeYes.isChecked()) {
                    String time = String.format(Locale.getDefault(), "%02d:%02d", tp.getCurrentHour(), tp.getCurrentMinute());
                    String date = String.format(Locale.getDefault(), "%d/%d/%d", dp.getDayOfMonth(), dp.getMonth()+1, dp.getYear());
                    String displayAll = "Reservation Placed: \n" + "Name: " + name.getText().toString() + "\n"
                            + "Phone Number: " + contact.getText().toString() + "\n"
                            + "Smoking Area: Yes\n"
                            + "Date booked: " + date + "\n"
                            + "Time booked: " + time;
                    txtDisplay.setText(displayAll);
                    Toast.makeText(MainActivity.this, displayAll, Toast.LENGTH_SHORT).show();
                }
                if (smokeNo.isChecked()) {
                    String time = String.format(Locale.getDefault(), "%02d:%02d", tp.getCurrentHour(), tp.getCurrentMinute());
                    String date = String.format(Locale.getDefault(), "%d/%d/%d", dp.getDayOfMonth(), dp.getMonth()+1, dp.getYear());
                    String displayAll = "Reservation Placed: \n" + "Name: " + name.getText().toString() + "\n"
                            + "Phone Number: " + contact.getText().toString() + "\n"
                            + "Smoking Area: No\n"
                            + "Date booked: " + date + "\n"
                            + "Time booked: " + time;
                    txtDisplay.setText(displayAll);
                    Toast.makeText(MainActivity.this, displayAll, Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDisplay.setText("");
                dp.init(2020,5, 1, null);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                name.setText("");
                contact.setText("");
                NOG.setText("");
                smokeYes.setChecked(false);
                smokeNo.setChecked(false);
            }
        });
    }
}