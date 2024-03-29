package goodinc2k.health_diary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


	private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "values";

    // Tables
    private static final String TABLE_VALUES = "values";
    
    // Columns
    private static final String KEY_ID = "id";
    private static final String KEY_DATETIME = "datetime";
    private static final String KEY_METRIC = "metric";
    private static final String KEY_VALUE = "value";

    // Values
    public static final int VALUE_METRIC_WEIGHT = 1;
    public static final int VALUE_METRIC_PULSE = 2;
    public static final int VALUE_METRIC_SYSTOLIC = 3; //max pressure
    public static final int VALUE_METRIC_DIASTOLIC = 4; //min pressure
    

    public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_VALUES_TABLE = "CREATE TABLE " + TABLE_VALUES + "("
                + KEY_ID + " INTEGER AUTOINCREMENT PRIMARY KEY,"
				+ KEY_DATETIME + " TEXT,"
				+ KEY_METRIC + " INTEGER,"
                + KEY_VALUE + " INTEGER" + ")";

		db.execSQL(CREATE_VALUES_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
