package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {
	
	private ViewClickListener viewClickListener = new ViewClickListener();
	private static int[] buttonsIds = { R.id.button1,
		R.id.button2,
		R.id.button3,
		R.id.button4,
		R.id.button5,
		R.id.button6,
		R.id.button7,
		R.id.button8,
		R.id.button9,
		R.id.button9,
		R.id.button10,
		R.id.button11,
		R.id.button12
	};

	
	private class ViewClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int button_id = v.getId();
			EditText editText = (EditText) findViewById(R.id.editText1);
			String phoneNumber = editText.getText().toString();
			
			if (button_id == R.id.imageButton1) { // backspace button
				
				if (!phoneNumber.isEmpty()) {
					editText.setText(phoneNumber.substring(0, phoneNumber.length() - 1));
				}
			} else if (button_id == R.id.imageButton2) { // call button
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:"+phoneNumber));
				startActivity(intent);
			} else if (button_id == R.id.imageButton3) { // hangup button
				finish();
			} else { // 0-9, *, # buttons
				Button button = (Button) findViewById(button_id);
				editText.setText(phoneNumber + button.getText());
			}
		}
		
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        
        for (int id : buttonsIds) {
        	Button button = (Button) findViewById(id);
        	button.setOnClickListener(viewClickListener);
        }
        
        ImageButton backspaceButton = (ImageButton) findViewById(R.id.imageButton1);
        backspaceButton.setOnClickListener(viewClickListener);
        
        ImageButton callButton = (ImageButton) findViewById(R.id.imageButton2);
        callButton.setOnClickListener(viewClickListener);
        
        ImageButton hangupButton = (ImageButton) findViewById(R.id.imageButton3);
        hangupButton.setOnClickListener(viewClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
