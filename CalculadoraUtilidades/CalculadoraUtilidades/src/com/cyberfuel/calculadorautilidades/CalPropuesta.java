package com.cyberfuel.calculadorautilidades;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CalPropuesta extends Fragment{
	
	private static final String TAG = "Calculadora";
	
	@Override
	public void onAttach(Activity activity) {
		Log.i(TAG, "CalPropuesta: entered onAttach()");
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "CalPropuesta :entered onCreate()");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "CalPropuesta :entered onCreateView()");

		return inflater.inflate(R.layout.layout_cal_propuesta,
				container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.i(TAG,"CalPropuesta :entered onActivityCreated()");
		super.onActivityCreated(savedInstanceState);

	}
	
	@Override
	public void onStart() {
		Log.i(TAG, "CalPropuesta:entered onStart()");
		super.onStart();
	}
	
	@Override
	public void onResume() {
		Log.i(TAG, "CalPropuesta:entered onResume()");
		super.onResume();
	}

	
	@Override
	public void onPause() {
		Log.i(TAG, "CalPropuesta:entered onPause()");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.i(TAG, "CalPropuesta:entered onStop()");
		super.onStop();
	}
	

	@Override
	public void onDestroyView() {
		Log.i(TAG, "CalPropuesta:entered onDestroyView()");
		super.onDestroyView();
	}

	
	@Override
	public void onDestroy() {
		Log.i(TAG, "CalPropuesta:entered onDestroy()");
		super.onDestroy();
	}

	
	@Override
	public void onDetach() {
		Log.i(TAG, "CalPropuesta:entered onDetach()");
		super.onDetach();
	}	
	

}
