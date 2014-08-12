package goodinc2k.health_diary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WeightRecordActivity extends Activity {

	public static String ACTIVITY_MODE_PARAM = "mode";

	public static int ACTIVITY_MODE_NEW = 0;
	public static int ACTIVITY_MODE_EDIT = 1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight_record);
		
		Intent intent = getIntent();
		int mode = intent.getIntExtra(ACTIVITY_MODE_PARAM, ACTIVITY_MODE_NEW);
		if(mode == ACTIVITY_MODE_EDIT) {
			TextView caption = (TextView)findViewById(R.id.lbl_caption);
			caption.setText(R.string.lbl_edit_record);
		}
	}
}
