package com.example.test2app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RolesExpectationsFragment extends Fragment {
	
	   @Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container,
               Bundle savedInstanceState) {
           View rolesExpectations= inflater.inflate(R.layout.roles_expectations_frag, container, false);
		return rolesExpectations;
	   }
	   
	   public void goToStudentExpectations(View view) {
			Intent intent = new Intent(getActivity(),StudentExpectationsActivity.class);
			startActivity(intent);
		}
		
		public void goToFacultyExpectations(View view) {
			Intent intent = new Intent(getActivity(),FacultyExpectationsActivity.class);
			startActivity(intent);
		}
		
		
		public void goToRolesExpectations(View view) {
			Intent intent = new Intent(getActivity(),RolesExpectationsActivity.class);
			startActivity(intent);
		}
}