package kuta.adrian.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {
	private int num1;
	private int num2;
	private int points;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		roll();
	}

	public void clickButton1(View view) {
		check(num1, num2);
	}

	public void clickButton2(View view) {
		check(num2, num1);
	}

	private void check(int a, int b) {
		if (a > b) {
			points++;
			Toast.makeText(this, "Dobrze!", Toast.LENGTH_SHORT).show();
		} else {
			points--;
			Toast.makeText(this, "Źle!", Toast.LENGTH_SHORT).show();
		}

		TextView pointsView = (TextView) findViewById(R.id.pointsTextView);
		pointsView.setText("Punkty: " + points);
		roll();
	}

	private void roll() {
		Random r = new Random();
		num1 = r.nextInt(9);
		num2 = r.nextInt(9);
		while (num2 == num1) {
			num2 = r.nextInt(9);
		}

		Button left = (Button) findViewById(R.id.buttonLeft);
		left.setText("" + num1);

		Button right = (Button) findViewById(R.id.buttonRight);
		right.setText("" + num2);
	}
}

