package com.ticosoftweb.easywaypop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ProyectosListado extends ListActivity {
	
	 // Progress Dialog
    private ProgressDialog pDialog;
    
 // Creating JSON Parser object
    JSONParser jParser = new JSONParser();
 
    ArrayList<HashMap<String, String>> proyectosList;
    
 // url to get all products list
    private static String url_all_products = "http://zona.ticosoftweb.com/easywaypop/webservice.php";
    
 // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PROYECTOS = "proyectos";
    private static final String TAG_PID = "token";
    private static final String TAG_NAME = "nombre_proyecto";
 
    // products JSONArray
    JSONArray products = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_proyectos);
        
        
        inputSearch = (EditText) findViewById(R.id.inputSearch);
 
        // Hashmap for ListView
        proyectosList = new ArrayList<HashMap<String, String>>();
 
        // Loading products in Background Thread
        new LoadAllProducts().execute();
 
        // Get listview
        ListView lv = getListView();
 
        // on seleting single product
        // launching Edit Product Screen
        lv.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // getting values from selected ListItem
                String token = ((TextView) view.findViewById(R.id.token)).getText().toString();
 
                // Starting new intent
                //--- Intent in = new Intent(getApplicationContext(), EditProductActivity.class);
                // sending pid to next activity
                //--- in.putExtra(TAG_PID, token);
 
                // starting new activity and expecting some response back
                // --- startActivityForResult(in, 100);
            }
        });
 
    }    
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if result code 100
        if (resultCode == 100) {
            // if result code 100 is received
            // means user edited/deleted product
            // reload this screen again
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
 
    }    
    
    class LoadAllProducts extends AsyncTask<String, String, String> {
    	 
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ProyectosListado.this);
            pDialog.setMessage("Cargando productos. Por favor, espere ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }
 
        /**
         * getting All products from url
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            JSONObject json = jParser.makeHttpRequest(url_all_products, "GET", params);
 
            // Check your log cat for JSON reponse
            Log.d("All Products: ", json.toString());
 
            try {
                // Checking for SUCCESS TAG
                int success = json.getInt(TAG_SUCCESS);
 
                if (success == 1) {
                    // products found
                    // Getting Array of Products
                    products = json.getJSONArray(TAG_PROYECTOS);
 
                    // looping through All Products
                    for (int i = 0; i < products.length(); i++) {
                    	
                        JSONObject c = products.getJSONObject(i);
 
                        // Storing each json item in variable
                        String token = c.getString(TAG_PID);
                        String nombre_proyecto = c.getString(TAG_NAME);
 
                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();
 
                        // adding each child node to HashMap key => value
                        map.put(TAG_PID, token);
                        map.put(TAG_NAME, nombre_proyecto);
 
                        // adding HashList to ArrayList
                        proyectosList.add(map);
                    }
                } else {
                    // no products found
                    // Launch Add New product Activity
                    // --- Intent i = new Intent(getApplicationContext(), NewProductActivity.class);
                    // Closing all previous activities
                    // --- i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    // --- startActivity(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
 
            return null;
        }
 
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    ListAdapter adapter = new SimpleAdapter( ProyectosListado.this, 
                    										 proyectosList,
                    										 R.layout.item_proyecto, 
                    										 new String[] { TAG_PID, TAG_NAME},
                    										 new int[] { R.id.token, R.id.nombre_proyecto }
                    										);
                    // updating listview
                    setListAdapter(adapter);
                }
            });
 
        }
 
    }
    
    
}
