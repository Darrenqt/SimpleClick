package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    CheckBox ckbLike;

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        Float ftGPA = Float.parseFloat(strGPA);

        int selection = rgGender.getCheckedRadioButtonId();
        boolean isChecked = ckbLike.isChecked();


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putFloat("gpa",ftGPA);
        prefEdit.putString("name",strName);
        prefEdit.putInt("gender",selection);
        prefEdit.putBoolean("checked", isChecked);
        prefEdit.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs =  PreferenceManager.getDefaultSharedPreferences(this);
        String strName = prefs.getString("name","John");
        etName.setText(strName);

        Float ftGPA = prefs.getFloat("gpa",4);
        String strGPA = ftGPA.toString();
        etGPA.setText(strGPA);

        int intgender = prefs.getInt("gender", 0);
        boolean isChecked = prefs.getBoolean("checked", false);
        rgGender.check(intgender);
        ckbLike.setChecked(isChecked);
    }

    //This is a new line
}
