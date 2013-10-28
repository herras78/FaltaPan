package com.faltapan.activities;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ListView;

import com.faltapan.bd.BD_Manager;

public class ListadoDeListas extends Activity{
	
	/*Lista[] listas =  new Lista[]{
	        new Lista("Compra Martes", "05/04/2013","5","Dia",R.drawable.ic_faltapan_i),
	        new Lista("Cena Domingo", "05/04/2013","6","Carrefour",R.drawable.ic_faltapan_ii),
	        new Lista("Material Escolar", "05/04/2013","7","Carrefour",R.drawable.ic_faltapan_iii),
	        new Lista("Compra Domingo", "05/04/2013","8","LIDL",R.drawable.ic_faltapan_i),
	        new Lista("Lista Cumpleaños", "05/04/2013","9","Mercadona",R.drawable.ic_faltapan_ii),
	        new Lista("Material Escolar", "05/04/2013","7","Carrefour",R.drawable.ic_faltapan_iii),
	        new Lista("Compra Martes", "05/04/2013","5","Dia",R.drawable.ic_faltapan_i),
	        new Lista("Cena Domingo", "05/04/2013","6","Carrefour",R.drawable.ic_faltapan_ii),
	        new Lista("Material Escolar", "05/04/2013","7","Carrefour",R.drawable.ic_faltapan_iii),
	        new Lista("Compra Domingo", "05/04/2013","8","LIDL",R.drawable.ic_faltapan_i),
	        new Lista("Lista Cumpleaños", "05/04/2013","9","Mercadona",R.drawable.ic_faltapan_ii),
	        new Lista("Material Escolar", "05/04/2013","7","Carrefour",R.drawable.ic_faltapan_iii)};*/
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_listado_listas);
		
		/*listado_listas = (ListView) findViewById(R.id.B_LV_0);
		AdaptadorListadoListas adaptador = new AdaptadorListadoListas(ListadoDeListas.this,R.layout.item_listado_listas,listas) ;
		listado_listas.setAdapter(adaptador);*/
	
		ListView listado_listas = (ListView) findViewById(R.id.B_LV_0);
		listado_listas.setAdapter(getAdapter());	
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
}


