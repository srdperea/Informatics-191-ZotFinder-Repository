package com.example.test2app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DepartmentDatabase extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "UCI_department_directory"; 
	
	public DepartmentDatabase(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*
		 * Create the employee table and populate it with sample data.
		 * In step 6, we will move these hardcoded statements to an XML document.
		 */
		String sql = "CREATE TABLE IF NOT EXISTS department (" +
						"_id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
						"departmentName TEXT, " +
						"departmentPhoneNumber TEXT, " +
						"departmentAddress TEXT, " +
						"departmentWebsite TEXT)";
		db.execSQL(sql);
		
		ContentValues values = new ContentValues();

		values.put("departmentName", "Art");
		values.put("departmentPhoneNumber", "(949) 824-6648");
		values.put("departmentAddress", "3229 Art, Culture and Technology Building");
		values.put("departmentWebsite", "http://studioart.arts.uci.edu/");
		db.insert("department", "departmentName", values);
		
		values.put("departmentName", "Dance");
		values.put("departmentPhoneNumber", "(949) 824-7283");
		values.put("departmentAddress", "301 Mesa Arts Building");
		values.put("departmentWebsite", "http://dance.arts.uci.edu/");
		db.insert("department", "departmentName", values);
		
		

		//		values.put("lastName", "Smith");
//		values.put("title", "CEO");
//		values.put("officePhone", "617-219-2001");
//		values.put("cellPhone", "617-456-7890");
//		values.put("email", "jsmith@email.com");
//		db.insert("employee", "lastName", values);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS departments");
		onCreate(db);
	}
	
}
