package com.example.test2app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BuildingDatabase extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "UCI_building_directory";
	
	public BuildingDatabase(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*
		 * Create the employee table and populate it with sample data.
		 * In step 6, we will move these hardcoded statements to an XML document.
		 */
		String sql = "CREATE TABLE IF NOT EXISTS building (" +
						"_id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
						"buildingName TEXT, " +
						"buildingNumber TEXT, " +
						"buildingAddress TEXT)";
		db.execSQL(sql);
		
		ContentValues values = new ContentValues();

		values.put("buildingName", "Donald Bren Hall");
		values.put("buildingNumber", "314");
		values.put("buildingAddress", "314 Engineering Quad");
		db.insert("building", "buildingName", values);
		
		values.put("buildingName", "Humanities Hall");
		values.put("buildingNumber", "601");
		values.put("buildingAddress", "601 Humanities Quad");
		db.insert("building", "buildingName", values);
		
		values.put("buildingName", "Engineering Gateway");
		values.put("buildingNumber", "321");
		values.put("buildingAddress", "321 Engineering Quad");
		db.insert("building", "buildingName", values);
		
		values.put("buildingName", "Humanties Gateway");
		values.put("buildingNumber", "611");
		values.put("buildingAddress", "611 Humanities Quad");
		db.insert("building", "buildingName", values);
		
		values.put("buildingName", "Aldrich Hall");
		values.put("buildingNumber", "111");
		values.put("buildingAddress", "111 Gateway Quad");
		db.insert("building", "buildingName", values);

		//		values.put("lastName", "Smith");
//		values.put("title", "CEO");
//		values.put("officePhone", "617-219-2001");
//		values.put("cellPhone", "617-456-7890");
//		values.put("email", "jsmith@email.com");
//		db.insert("employee", "lastName", values);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS buildings");
		onCreate(db);
	}
	
}
