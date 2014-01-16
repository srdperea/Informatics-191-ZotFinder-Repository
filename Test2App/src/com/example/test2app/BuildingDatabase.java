package com.example.test2app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
						"buildingLongitude TEXT, " +
						"buildingLatitude TEXT, " +
						"buildingType TEXT, " +
						"buildingAddress TEXT, " + 
						"buildingNumber TEXT, " + 
						"buildingAbbreviation TEXT)";
		db.execSQL(sql);
		ContentValues values = new ContentValues();
	
		/*BufferedReader br = null;
		String line = "";
		
		try {
			br = new BufferedReader(new FileReader("building_file.csv"));
			while ((line = br.readLine()) != null)
			{
				String[] buildingInfo = line.split(",");
				values.put("buildingName", buildingInfo[0]);
				values.put("buildingLongitude", buildingInfo[1]);
				values.put("buildingLatitude", buildingInfo[2]);
				values.put("buildingType", buildingInfo[3]);
				values.put("buildingAddress", buildingInfo[4]);
				values.put("buildingNumber", buildingInfo[5]);
				if (!(buildingInfo[6].equals("none")))
					values.put("buildingAbbreviation", buildingInfo[6]);
				db.insert("building", "buildingName", values);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		

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
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS buildings");
		onCreate(db);
	}
	
}
