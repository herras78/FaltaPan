package com.faltapan.activities;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.faltapan.bd.BD_Manager;

public class ListadoDeListas extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_listado_listas);
	
		ListView listado_listas = (ListView) findViewById(R.id.B_LV_0);
		listado_listas.setAdapter(getAdapter());
		setFont();
	}
		
	public SimpleCursorAdapter getAdapter(){
		Context context = this;
		int layoutItem = R.layout.item_listado_listas;
		String query = "SELECT _id,NOMBRE, NUM_ELEMENTOS,REF_IMAGEN FROM T_LISTA";
		Cursor cursor = getCursorLista(query);
		int[] ref_controles = new int[]{R.id.B_TXV_ID1, R.id.B_TXV_ID2,R.id.B_IV_ID1};
		String[] nombre_cabeceras = new String[]{"NOMBRE", "NUM_ELEMENTOS","REF_IMAGEN"};

		return  new SimpleCursorAdapter(context, layoutItem, cursor, nombre_cabeceras, ref_controles,0) ; 
	}
	
	public Cursor getCursorLista(String query)
	{	
		Cursor cursor = null;
		try{
			BD_Manager dbm = new BD_Manager(ListadoDeListas.this);
			SQLiteDatabase db = dbm.getReadableDatabase();
				
			cursor = db.rawQuery(query, null);
			
		}catch(SQLException e){
			Log.e("**SQL FALTAPAN","Error SQL:" + e.getMessage() );
		};
		
		return cursor;	
	}
	
	public void setFont()
	{
		int[] ref_controles = new int[]{R.id.B_TXV_ID0};
		Typeface font = Typeface.createFromAsset(getAssets(), "rabiohead.ttf");
		
		for(int txvId:ref_controles){
			TextView tv = (TextView) findViewById(txvId);
			tv.setTypeface(font);
		}
	}
}


