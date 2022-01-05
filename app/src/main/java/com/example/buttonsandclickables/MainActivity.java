package com.example.buttonsandclickables;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buttonsandclickables.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final String[] spinnerResource = {"Apple", "Orange", "Pineapple", "Grape"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        initialization();
    }

    void initialization() {
        //Raised Button
        binding.buttonRaisedBtn.setOnClickListener(v ->
                Toast.makeText(getApplicationContext(), "Raised Button Clicked", Toast.LENGTH_SHORT).show());

        //Outlined Button
        binding.buttonOutlined.setOnClickListener(v ->
                Toast.makeText(getApplicationContext(), "Outlined Button Clicked", Toast.LENGTH_SHORT).show());

        //Text Button
        binding.buttonText.setOnClickListener(v ->
                Toast.makeText(getApplicationContext(), "Text Button Clicked", Toast.LENGTH_SHORT).show());

        //Switch
        binding.switch1.setOnCheckedChangeListener((view, isChecked) ->
                Toast.makeText(getApplicationContext(), " Is switched on: " + view.isChecked(), Toast.LENGTH_SHORT).show());

        //Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_selectable_list_item, spinnerResource);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), parent.getItemAtPosition(position).toString() + " selected", Toast.LENGTH_SHORT).show();
                //Log.d("Spinner",parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //ToggleButton
        binding.toggleButton.setOnCheckedChangeListener((view, isChecked) ->
                Toast.makeText(getApplicationContext(), "Toggle Button switched on : " + view.isChecked(), Toast.LENGTH_SHORT).show());

        //Toggle Group
        binding.toggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            Button toggleButton = findViewById(group.getCheckedButtonId());
            if (isChecked)
                toggleButton.setOnClickListener(v ->
                        Toast.makeText(getApplicationContext(), toggleButton.getText() + " Selected", Toast.LENGTH_SHORT).show());
        });

        //Radio Group
        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedButton = findViewById(group.getCheckedRadioButtonId());
            Toast.makeText(getApplicationContext(), selectedButton.getText() + " Selected", Toast.LENGTH_SHORT).show();
        });

        //Check Box
        binding.checkbox.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(getApplicationContext(), "Checkbox " + buttonView.getText() + " is selected: " + buttonView.isChecked(), Toast.LENGTH_SHORT).show());

        //PopUp Button
        binding.popUpButton.setOnClickListener(this::showPopup);

        //Floating Button
        binding.floating.setOnClickListener(v ->
                Toast.makeText(getApplicationContext(), "Floating Button Clicked", Toast.LENGTH_SHORT).show());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(this, getResources().getString(R.string.search), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favorite:
                Toast.makeText(this, getResources().getString(R.string.favourite), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(this, getResources().getString(R.string.settings), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showPopup(final View anchor) {
        PopupMenu popup = new PopupMenu(this, anchor);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_resource, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
                    Toast.makeText(getApplicationContext(), item.getTitle() + " selected", Toast.LENGTH_SHORT).show();
                    return true;
                }
        );
        popup.show();
    }
}