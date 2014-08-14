package com.cyberfuel.calculadorautilidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Acercade extends Activity{
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactenos);

        
        Button btncontacto = (Button) findViewById(R.id.btn_contactenos);
        btncontacto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				enviarCorreo();
				
			}
			
			
			
		});
        
    }
    
   
    public void enviarCorreo(){
        	
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Contacto");
            intent.putExtra(Intent.EXTRA_TEXT, "");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"ventas@cyberfuel.com" });
            startActivity(intent);

     }

       
}
    

    
  
    
