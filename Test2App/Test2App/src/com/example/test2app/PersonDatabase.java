package com.example.test2app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonDatabase extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "UCI_person_directory"; 
	
	public PersonDatabase(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*
		 * Create the employee table and populate it with sample data.
		 * In step 6, we will move these hardcoded statements to an XML document.
		 */
		String sql = "CREATE TABLE IF NOT EXISTS person (" +
						"_id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
						"personName TEXT, " +
						"personPhoneNumber TEXT, " +
						"personAddress TEXT, " +
						"personEmail TEXT)";
		db.execSQL(sql);
		
		ContentValues values = new ContentValues();

		values.put("personName", "Donald Patterson");
		values.put("personPhoneNumber", "(206) 355-5863");
		values.put("personAddress", "5208 Donald Bren Hall");
		values.put("personEmail", "djp3@ics.uci.edu");
		db.insert("person", "personName", values);
		
		values.put("personName", "Hadar Ziv");
		values.put("personPhoneNumber", "(206) 355-5863");
		values.put("personAddress", "5062 Donald Bren Hall");
		values.put("personEmail", "ziv@ics.uci.edu");
		db.insert("person", "personName", values);
		
		values.put("personName", "Anne K Widney");
		values.put("personPhoneNumber", "(949) 824-7147");
		values.put("personAddress", "100 Public Services");
		values.put("personEmail", "awidney@uci.edu");
		db.insert("person", "personName", values);
		

		//		values.put("lastName", "Smith");
//		values.put("title", "CEO");
//		values.put("officePhone", "617-219-2001");
//		values.put("cellPhone", "617-456-7890");
//		values.put("email", "jsmith@email.com");
//		db.insert("employee", "lastName", values);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS persons");
		onCreate(db);
	}
	
}
