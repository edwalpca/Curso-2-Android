package com.cyberfuel.calculadorautilidades;


import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private CalActual mfragment_ca;
	private CalPropuesta mfragment_prop;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        setContentView(R.layout.layout_principal);
        
        
        mfragment_ca = new CalActual();
        mfragment_prop = new CalPropuesta();
        
        
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.FrmBody, mfragment_ca);
		fragmentTransaction.add(R.id.FrmBody, mfragment_prop);
		fragmentTransaction.hide(mfragment_prop);
		fragmentTransaction.commit();        
		
		/* Declaración de los botones */
        Button  b_actual 		= (Button) findViewById(R.id.btn_actual);
        Button  b_propuesta 	= (Button) findViewById(R.id.btn_propuesta);
        Button  b_resultados 	= (Button) findViewById(R.id.btn_resultados);
        
        
        /* Declaración de los metodos */
        b_actual.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				/*
				 * Toast msg = Toast.makeText(getApplicationContext(), "Propuesta Actual", Toast.LENGTH_SHORT);
				 * msg.show();
				*/
				
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				
					
				fragmentTransaction.show(mfragment_ca);
				fragmentTransaction.hide(mfragment_prop);
		
				
				//fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
				
			
				
			}
		});
        
        b_propuesta.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/*
				 * Toast msg = Toast.makeText(getApplicationContext(), "Nueva Propuesta", Toast.LENGTH_SHORT);
				 * msg.show();
				*/
				
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				
				fragmentTransaction.show(mfragment_prop);
				fragmentTransaction.hide(mfragment_ca);
		
				//fragmentTransaction.addToBackStack(null)  ;
				fragmentTransaction.commit();				
			
				
				
				
			}
		});
        
        b_resultados.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				

				 NumberFormat nf = NumberFormat.getInstance();
				 nf.setMinimumFractionDigits(2);
				 nf.setMaximumFractionDigits(2);

				
				
				/* Precio Unitarios */
				EditText  v_p1F2Col2 = (EditText) findViewById(R.id.p1F2Col2);
				EditText  v_p1F3Col2 = (EditText) findViewById(R.id.p1F3Col2);
				EditText  v_p1F4Col2 = (EditText) findViewById(R.id.p1F4Col2);
				EditText  v_p1F5Col2 = (EditText) findViewById(R.id.p1F5Col2);
				EditText  v_p1F6Col2 = (EditText) findViewById(R.id.p1F6Col2);
				
				
				/* CAMBIOS DIARIOS */
				EditText  v_p1F2Col3 = (EditText) findViewById(R.id.p1F2Col3);
				EditText  v_p1F3Col3 = (EditText) findViewById(R.id.p1F3Col3);
				EditText  v_p1F4Col3 = (EditText) findViewById(R.id.p1F4Col3);
				EditText  v_p1F5Col3 = (EditText) findViewById(R.id.p1F5Col3);
				EditText  v_p1F6Col3 = (EditText) findViewById(R.id.p1F6Col3);
				
				
				/* SUBTOTAL */
				EditText  v_p1F2Col4 = (EditText) findViewById(R.id.p1F2Col4);
				EditText  v_p1F3Col4 = (EditText) findViewById(R.id.p1F3Col4);
				EditText  v_p1F4Col4 = (EditText) findViewById(R.id.p1F4Col4);
				EditText  v_p1F5Col4 = (EditText) findViewById(R.id.p1F5Col4);
				EditText  v_p1F6Col4 = (EditText) findViewById(R.id.p1F6Col4);				
				
				
				/* MARGEN */
				EditText  v_p1F2Col5 = (EditText) findViewById(R.id.p1F2Col5);
				EditText  v_p1F3Col5 = (EditText) findViewById(R.id.p1F3Col5);
				EditText  v_p1F4Col5 = (EditText) findViewById(R.id.p1F4Col5);
				EditText  v_p1F5Col5 = (EditText) findViewById(R.id.p1F5Col5);
				EditText  v_p1F6Col5 = (EditText) findViewById(R.id.p1F6Col5);				
				
				/* UTILIDAD */	
				EditText  v_p1F2Col6 = (EditText) findViewById(R.id.p1F2Col6);
				EditText  v_p1F3Col6 = (EditText) findViewById(R.id.p1F3Col6);
				EditText  v_p1F4Col6 = (EditText) findViewById(R.id.p1F4Col6);
				EditText  v_p1F5Col6 = (EditText) findViewById(R.id.p1F5Col6);
				EditText  v_p1F6Col6 = (EditText) findViewById(R.id.p1F6Col6);				
				
				/*Resultado de Cambios Diarios */ 
				double totalCambioD = Double.parseDouble(v_p1F2Col3.getText().toString())	+ Double.parseDouble(v_p1F3Col3.getText().toString()) +
									  Double.parseDouble(v_p1F4Col3.getText().toString())	+ Double.parseDouble(v_p1F5Col3.getText().toString());
				v_p1F6Col3.setText(new Double( NumberFormat.getInstance().format(totalCambioD)).toString());					 	
				
				/* CALCULOS DE RESULTADO DE SUBTOTALES (PRECIO UNITARIO * CAMBIOS DIARIOS) */
				double subT_a = Double.parseDouble(v_p1F2Col2.getText().toString()) * Double.parseDouble(v_p1F2Col3.getText().toString());
				double subT_b = Double.parseDouble(v_p1F3Col2.getText().toString()) * Double.parseDouble(v_p1F3Col3.getText().toString());
				double subT_c = Double.parseDouble(v_p1F4Col2.getText().toString()) * Double.parseDouble(v_p1F4Col3.getText().toString());
				double subT_d = Double.parseDouble(v_p1F5Col2.getText().toString()) * Double.parseDouble(v_p1F5Col3.getText().toString());
				double subT_e = subT_a + subT_b + subT_c + subT_d;
				
				v_p1F2Col4.setText(nf.format(subT_a));
				v_p1F3Col4.setText(nf.format(subT_b));
				v_p1F4Col4.setText(nf.format(subT_c));
				v_p1F5Col4.setText(nf.format(subT_d));
				  v_p1F6Col4.setText(nf.format(subT_e));
				/* FIN CALCULOS DE RESULTADO DE SUBTOTALES */
				

				/* CALCULOS DE RESULTADO DE UTILIDAD ( SUBTOTAL * MARGEN ) */
				double util_a = subT_a * (Double.parseDouble(v_p1F2Col5.getText().toString())/100);
				double util_b = subT_b * (Double.parseDouble(v_p1F3Col5.getText().toString())/100);
				double util_c = subT_c * (Double.parseDouble(v_p1F4Col5.getText().toString())/100);
				double util_d = subT_d * (Double.parseDouble(v_p1F5Col5.getText().toString())/100);
				double util_e = util_a + util_b + util_c + util_d;
				
				v_p1F2Col6.setText(nf.format(util_a));
				v_p1F3Col6.setText(nf.format(util_b));
				v_p1F4Col6.setText(nf.format(util_c));
				v_p1F5Col6.setText(nf.format(util_d));
				  v_p1F6Col6.setText(nf.format(util_e));
				/* FIN CALCULOS DE RESULTADO DE UTILIDAD ( SUBTOTAL * MARGEN ) */
				
				/*Resultado propuesta Actual ( DIAS HABILES X TOTAL DE UTILIDAD*/
				
				 EditText v_CantidadDiasHabiles = (EditText) findViewById(R.id.CantidadDiasHabiles); 
				 TextView v_ResulActualPropuesta = (TextView) findViewById(R.id.ResulActualPropuesta);
				 
				 double rpa =  util_e *  Double.parseDouble(v_CantidadDiasHabiles.getText().toString());
				 v_ResulActualPropuesta.setText("RESULTADO ACTUAL:  " + nf.format(rpa));
				 
				 


				 
				 
				 /* ################ PROPUESTA 2#################### */
				 
					/* Precio Unitarios */
					EditText  v_p2F2Col2 = (EditText) findViewById(R.id.p2F2Col2);
					EditText  v_p2F3Col2 = (EditText) findViewById(R.id.p2F3Col2);
					EditText  v_p2F4Col2 = (EditText) findViewById(R.id.p2F4Col2);
					EditText  v_p2F5Col2 = (EditText) findViewById(R.id.p2F5Col2);
					EditText  v_p2F6Col2 = (EditText) findViewById(R.id.p2F6Col2);
					
					
					/* CAMBIOS DIARIOS */
					EditText  v_p2F2Col3 = (EditText) findViewById(R.id.p2F2Col3);
					EditText  v_p2F3Col3 = (EditText) findViewById(R.id.p2F3Col3);
					EditText  v_p2F4Col3 = (EditText) findViewById(R.id.p2F4Col3);
					EditText  v_p2F5Col3 = (EditText) findViewById(R.id.p2F5Col3);
					EditText  v_p2F6Col3 = (EditText) findViewById(R.id.p2F6Col3);
					
					
					/* SUBTOTAL */
					EditText  v_p2F2Col4 = (EditText) findViewById(R.id.p2F2Col4);
					EditText  v_p2F3Col4 = (EditText) findViewById(R.id.p2F3Col4);
					EditText  v_p2F4Col4 = (EditText) findViewById(R.id.p2F4Col4);
					EditText  v_p2F5Col4 = (EditText) findViewById(R.id.p2F5Col4);
					EditText  v_p2F6Col4 = (EditText) findViewById(R.id.p2F6Col4);				
					
					
					/* MARGEN */
					EditText  v_p2F2Col5 = (EditText) findViewById(R.id.p2F2Col5);
					EditText  v_p2F3Col5 = (EditText) findViewById(R.id.p2F3Col5);
					EditText  v_p2F4Col5 = (EditText) findViewById(R.id.p2F4Col5);
					EditText  v_p2F5Col5 = (EditText) findViewById(R.id.p2F5Col5);
					EditText  v_p2F6Col5 = (EditText) findViewById(R.id.p2F6Col5);				
					
					/* UTILIDAD */	
					EditText  v_p2F2Col6 = (EditText) findViewById(R.id.p2F2Col6);
					EditText  v_p2F3Col6 = (EditText) findViewById(R.id.p2F3Col6);
					EditText  v_p2F4Col6 = (EditText) findViewById(R.id.p2F4Col6);
					EditText  v_p2F5Col6 = (EditText) findViewById(R.id.p2F5Col6);
					EditText  v_p2F6Col6 = (EditText) findViewById(R.id.p2F6Col6);				
					
					/*Resultado de Cambios Diarios */ 
					double totalCambioD_p2 = Double.parseDouble(v_p2F2Col3.getText().toString())	+ Double.parseDouble(v_p2F3Col3.getText().toString()) +
										  Double.parseDouble(v_p2F4Col3.getText().toString())	+ Double.parseDouble(v_p2F5Col3.getText().toString());
					v_p2F6Col3.setText(new Double(totalCambioD_p2).toString());					 	
					
					/* CALCULOS DE RESULTADO DE SUBTOTALES (PRECIO UNITARIO * CAMBIOS DIARIOS) */
					double subT_a2 = Double.parseDouble(v_p2F2Col2.getText().toString()) * Double.parseDouble(v_p2F2Col3.getText().toString());
					double subT_b2 = Double.parseDouble(v_p2F3Col2.getText().toString()) * Double.parseDouble(v_p2F3Col3.getText().toString());
					double subT_c2 = Double.parseDouble(v_p2F4Col2.getText().toString()) * Double.parseDouble(v_p2F4Col3.getText().toString());
					double subT_d2 = Double.parseDouble(v_p2F5Col2.getText().toString()) * Double.parseDouble(v_p2F5Col3.getText().toString());
					double subT_e2 = subT_a2 + subT_b2 + subT_c2 + subT_d2;
					
					v_p2F2Col4.setText(nf.format(subT_a2));
					v_p2F3Col4.setText(nf.format(subT_b2));
					v_p2F4Col4.setText(nf.format(subT_c2));
					v_p2F5Col4.setText(nf.format(subT_d2));
					  v_p2F6Col4.setText(nf.format(subT_e2));
					/* FIN CALCULOS DE RESULTADO DE SUBTOTALES */
					

					/* CALCULOS DE RESULTADO DE UTILIDAD ( SUBTOTAL * MARGEN ) */
					double util_a2 = subT_a2 * (Double.parseDouble(v_p2F2Col5.getText().toString())/100);
					double util_b2 = subT_b2 * (Double.parseDouble(v_p2F3Col5.getText().toString())/100);
					double util_c2 = subT_c2 * (Double.parseDouble(v_p2F4Col5.getText().toString())/100);
					double util_d2 = subT_d2 * (Double.parseDouble(v_p2F5Col5.getText().toString())/100);
					double util_e2 = util_a2 + util_b2 + util_c2 + util_d2;
					
					v_p2F2Col6.setText(nf.format(util_a2));
					v_p2F3Col6.setText(nf.format(util_b2));
					v_p2F4Col6.setText(nf.format(util_c2));
					v_p2F5Col6.setText(nf.format(util_d2));
					  v_p2F6Col6.setText(nf.format(util_e2));
					/* FIN CALCULOS DE RESULTADO DE UTILIDAD ( SUBTOTAL * MARGEN ) */
					
					/*Resultado propuesta Nueva ( DIAS HABILES X TOTAL DE UTILIDAD*/
					
					 // EditText v_CantidadDiasHabiles = (EditText) findViewById(R.id.CantidadDiasHabiles); 
					 TextView v_ResulPropuestaNueva = (TextView) findViewById(R.id.ResulPropuestaNueva);
					 
					 double rpnueva =  util_e2 *  Double.parseDouble(v_CantidadDiasHabiles.getText().toString());
					 
					 v_ResulPropuestaNueva.setText("RESULTADO PROPUESTA:  " + nf.format(rpnueva));
					 				 
					 
					 /* Resultado Global */
					 
					 TextView v_ResultadoGanacia = (TextView) findViewById(R.id.ResultadoGanacia);
					 double ResulGanancia = rpnueva - rpa;
					 if (ResulGanancia > 0){
						 v_ResultadoGanacia.setText("GANANCIA ADICIONAL: (+)  " + nf.format(ResulGanancia));	
					 }else{
						 v_ResultadoGanacia.setText("GANANCIA ADICIONAL: (-)  " + nf.format(ResulGanancia));
					 }
					 
					 /* Resultado Global */				 
				 
				  
				
				
 			}
		});


    }
    
    



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.acerca_de) {
        	Intent i = new Intent(this,Acercade.class);
        	startActivity(i);
            //return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
