package me.seandillon.gnarlydialogsampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import me.seandillon.gnarlydialog.GnarlyDialog;

public class MainActivity extends AppCompatActivity {

    // UI vars
    TextView textview_title;
    TextView textview_content;
    TextView textview_primaryButton;
    TextView textview_secondaryButton;

    Button button_launchDialogSuccess;
    Button button_launchDialogError;
    Button button_launchDialogWarning;
    Button button_launchDialogInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findByIds();
        assignOnClickListeners();

    }

    private void findByIds() {

        textview_title = (TextView)findViewById(R.id.textview_title);
        textview_content = (TextView)findViewById(R.id.textview_content);
        textview_primaryButton = (TextView)findViewById(R.id.textview_primaryButton);
        textview_secondaryButton = (TextView)findViewById(R.id.textview_secondaryButton);

        button_launchDialogSuccess = (Button) findViewById(R.id.button_launchDialogSuccess);
        button_launchDialogError = (Button) findViewById(R.id.button_launchDialogError);
        button_launchDialogWarning = (Button) findViewById(R.id.button_launchDialogWarning);
        button_launchDialogInfo = (Button) findViewById(R.id.button_launchDialogInfo);

    }

    private void assignOnClickListeners() {

        button_launchDialogSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGnarlyAlert(GnarlyDialog.GNARLY_DIALOG_TYPE_SUCCESS);
            }
        });

        button_launchDialogError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGnarlyAlert(GnarlyDialog.GNARLY_DIALOG_TYPE_ERROR);
            }
        });

        button_launchDialogWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGnarlyAlert(GnarlyDialog.GNARLY_DIALOG_TYPE_WARNING);
            }
        });

        button_launchDialogInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGnarlyAlert(GnarlyDialog.GNARLY_DIALOG_TYPE_INFO);
            }
        });

    }

    public void showGnarlyAlert(int whichType) {

        // initialize GnarlyDialog and get UI text to put in there
        final GnarlyDialog gnarlyDialog = new GnarlyDialog(MainActivity.this, whichType);

        if (!textview_title.getText().toString().equals("")) {
            gnarlyDialog.setGnarlyTitleText(textview_title.getText().toString());
        }

        if (!textview_content.getText().toString().equals("")) {
            gnarlyDialog.setGnarlyContentText(textview_content.getText().toString());
        }

        if (!textview_primaryButton.getText().toString().equals("")) {
            gnarlyDialog.setGnarlyPrimaryButtonText(textview_primaryButton.getText().toString());
            gnarlyDialog.setGnarlyPrimaryButtonListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Primary button clicked", Toast.LENGTH_SHORT).show();
                    gnarlyDialog.gnarlyDialogDismiss();
                }
            });
            gnarlyDialog.setGnarlyShouldDismisOnOutsideTouch(false);
        }

        if (!textview_secondaryButton.getText().toString().equals("")) {
            gnarlyDialog.setGnarlySecondaryButtonText(textview_secondaryButton.getText().toString());
            gnarlyDialog.setGnarlySecondaryButtonListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Secondary button clicked", Toast.LENGTH_SHORT).show();
                    gnarlyDialog.gnarlyDialogDismiss();
                }
            });
            gnarlyDialog.setGnarlyShouldDismisOnOutsideTouch(false);
        }

        // lastly show the dialog
        gnarlyDialog.gnarlyDialogShow();

    }

}
