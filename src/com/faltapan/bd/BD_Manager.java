package com.faltapan.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.faltapan.staticdata.Contractor;
import com.faltapan.staticdata.Contractor.TablaFamilia;
import com.faltapan.staticdata.Contractor.TablaFamiliaProducto;
import com.faltapan.staticdata.Contractor.TablaLista;
import com.faltapan.staticdata.Contractor.TablaListaProducto;
import com.faltapan.staticdata.Contractor.TablaProducto;

public class BD_Manager extends SQLiteOpenHelper{
	
	
	static Contractor contractor = new Contractor();
    
    public BD_Manager(Context contexto) 
    {	
        super(contexto, contractor.getDbName(), null, contractor.getVersion());
    }
 
    public BD_Manager(Context contexto, String nombre, CursorFactory factory, int version) 
    {
        super(contexto, nombre, factory, version);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) 
    {
    	
    	Log.e("FALTAPAN","Estamos es:::::Oncreate DB_Manager");
    	
       db.execSQL(new CreacionDeBD().CrearTabla(new TablaLista().setEstructura()));
       db.execSQL(new CreacionDeBD().CrearTabla(new TablaProducto().setEstructura()));
       db.execSQL(new CreacionDeBD().CrearTabla(new TablaFamilia().setEstructura()));
       db.execSQL(new CreacionDeBD().CrearTabla(new TablaListaProducto().setEstructura()));
       db.execSQL(new CreacionDeBD().CrearTabla(new TablaFamiliaProducto().setEstructura()));
          
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) 
    {   
    	Log.i("FALTAPAN","En OnUpgrade DB_Manager");
    	
    	String[] tablas = {new TablaListaProducto().TABLE_NAME,new TablaFamiliaProducto().TABLE_NAME,new TablaLista().TABLE_NAME,new TablaProducto().TABLE_NAME,new TablaFamilia().TABLE_NAME};
    	String[] queries_borrado = new CreacionDeBD().BorrarTabla(tablas);
    	
    	for(String query:queries_borrado)
    	{
    		db.execSQL(query);
    		Log.i("FALTAPAN","En OnUpgrade Haciendo " + query);
    	}
 
    	db.execSQL(new CreacionDeBD().CrearTabla(new TablaLista().setEstructura()));
        db.execSQL(new CreacionDeBD().CrearTabla(new TablaProducto().setEstructura()));
        db.execSQL(new CreacionDeBD().CrearTabla(new TablaFamilia().setEstructura()));
        db.execSQL(new CreacionDeBD().CrearTabla(new TablaListaProducto().setEstructura()));
        db.execSQL(new CreacionDeBD().CrearTabla(new TablaFamiliaProducto().setEstructura()));
        
        db.execSQL("INSERT INTO T_LISTA VALUES(10,'Lunes','05/06','1010','Carrefour')");
    }

}
