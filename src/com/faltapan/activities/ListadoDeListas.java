package com.faltapan.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.faltapan.supportclass.Lista;
import com.faltapan.adapters.AdaptadorListadoListas;

public class ListadoDeListas extends Activity{
	
	ListView listado_listas;
	
	Lista[] listas =  new Lista[]{
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
	        new Lista("Material Escolar", "05/04/2013","7","Carrefour",R.drawable.ic_faltapan_iii)};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_listado_listas);
		
		listado_listas = (ListView) findViewById(R.id.B_LV_0);
		AdaptadorListadoListas adaptador = new AdaptadorListadoListas(ListadoDeListas.this,R.layout.item_listado_listas,listas) ;
		listado_listas.setAdapter(adaptador);
	}

}


