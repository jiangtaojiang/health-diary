package goodinc2k.health_diary;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView versionText = (TextView) findViewById(R.id.text_version);
		PackageInfo pInfo = null;
		try {
			pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		if (pInfo != null) {
			String versionName = getString(R.string.version, pInfo.versionName);
			versionText.setText(versionName);
		}
		
		Button btnAddPressure = (Button) findViewById(R.id.btn_bpressure);
		btnAddPressure.setOnClickListener(mAddPressureListener);
		
		Button btnAddWeight = (Button) findViewById(R.id.btn_weight);
		btnAddWeight.setOnClickListener(mAddWeightListener);
	}

	private OnClickListener mAddPressureListener = new OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, PressureRecordActivity.class);
			intent.putExtra(PressureRecordActivity.ACTIVITY_MODE_PARAM, PressureRecordActivity.ACTIVITY_MODE_NEW);
			MainActivity.this.startActivity(intent);
		}
	};
	
	private OnClickListener mAddWeightListener = new OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, WeightRecordActivity.class);
			intent.putExtra(WeightRecordActivity.ACTIVITY_MODE_PARAM, WeightRecordActivity.ACTIVITY_MODE_NEW);
			MainActivity.this.startActivity(intent);
		}
	};
}
