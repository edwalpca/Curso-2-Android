package com.ticosoftweb.easywaypop;



import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class lista_proyectos extends Activity {
	
	private ListView lv;
	
	ArrayAdapter<String> adapter;
	
	EditText inputSearch;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tokens);
        
        
        // Arreglo de codigos de proyecto.
        String tokens[] = {"ABCD","BCD","EDFT","JGUR","AJHE","IKQ2","LKWW","W4T6","EMA1"};

		lv = (ListView) findViewById(R.id.list_view);
		lv.setTextFilterEnabled(true);
		inputSearch = (EditText) findViewById(R.id.inputSearch);
	
		adapter = new ArrayAdapter<String>(this,R.layout.list_item, R.id.codigo_token,tokens);
		
		lv.setAdapter(adapter);
		
		
		// Evento para cuando doy click en algun elemento de la lista ( ListView )
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// Mensaje Toast del elemento seleccionado.
				Toast.makeText(getApplicationContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
				
			}
			
		});
		
		
		/* Activando el filtro de busqueda */
		inputSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				
				lista_proyectos.this.adapter.getFilter().filter(arg0);
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		

		
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}