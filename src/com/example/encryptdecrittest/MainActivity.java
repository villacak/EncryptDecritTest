package com.example.encryptdecrittest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String seedWith16Chars = "This is my seed.";
	private String textToEncrypt = "Hi, this is a test to check its gone work or not.";

	private TextView seed;
	private TextView text;
	private TextView encryptedValue;
	private TextView decryptedValue;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		seed = (TextView) findViewById(R.id.seedName);
		seed.setText(seedWith16Chars);

		text = (TextView) findViewById(R.id.textToEncrypt);
		text.setText(textToEncrypt);

		encryptedValue = (TextView) findViewById(R.id.encryptedText);
		decryptedValue = (TextView) findViewById(R.id.decryptedText);

		try {
			// This value was got when did run it from an 2.3.3 device a Galaxy SII running Android 4.0.4
			String encrypted = "MzA3RDBCMjMxMjQzNzcxREUxMUYxNjg1NzgwOTU1MjU1M0FDOUZEN0M3Q0JGQ0Q5MTI2NEIyNTE2"
					+ "OTQwQTc3NjM2QTBCRDFDMUEyNkUwRjlDMzQwN0U0MEI0NDg2M0JBMDU1OThCNTI1NTZCMEFGNjk1NjJFNzZBMUE0NzM4NTQ=";
			
			// Uncomment the line bellow and comment the line above to run it on an Android 4.1.2 or older.
			// String encrypted = EncodeDecodeAES.encrypt(seedWith16Chars, textToEncrypt);
			Log.e("Encrypt", encrypted);
			encryptedValue.setText(encrypted);

			String decrypted = EncodeDecodeAES.decrypt(seedWith16Chars, encrypted);
			decryptedValue.setText(decrypted);
			Log.e("Decrypt", decrypted);
		} catch (Exception e) {
			Log.e("Exception", e.getLocalizedMessage());
		}

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
