package com.example.dorra.screensplash;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tej Eddine on 24/01/2017.
 */

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "MainDatabase";

    // Nom de la table Audience
    private static final String TABLE_AUDIENCE = "audiences";
    // Colonnes
    private static final String KEY_AUDIENCE_ID = "id";
    private static final String KEY_AUDIENCE_DATE = "date";
    private static final String KEY_AUDIENCE_TYPE = "type";

    // Nom de la table Document
    private static final String TABLE_DOCUMENT = "documents";
    // Colonnes
    private static final String KEY_DOCUMENT_ID = "docID";
    private static final String KEY_DOCUMENT_CHEMIN = "chemin";

    // Nom de la table Dossier
    private static final String TABLE_DOSSIER = "dossiers";
    // Colonnes
    private static final String KEY_DOSSIER_ID = "idDossier";
    private static final String KEY_DOSSIER_DATE = "dateAcceptaion";
    private static final String KEY_DOSSIER_COULEUR = "couleur";
    private static final String KEY_DOSSIER_REMARQUES = "remarques";
    private static final String KEY_DOSSIER_TYPE = "type";

    // Nom de la table Personne Morale
    private static final String TABLE_PERSONNE_MORALE = "personnesMorales";
    // Colonnes
    private static final String KEY_PERSONNE_MORALE_MATRICULE_FISCALE = "matriculeFiscale";
    private static final String KEY_PERSONNE_MORALE_NOM = "nom";
    private static final String KEY_PERSONNE_MORALE_TYPE = "type";
    private static final String KEY_PERSONNE_MORALE_SIEGE_SOCIAL = "siegeSocial";
    private static final String KEY_PERSONNE_MORALE_REGISTRE_COMMERCE = "numRegistreCommerce";

    // Nom de la table Personne Morale
    private static final String TABLE_PERSONNE_PHYSIQUE = "personnesPhysiques";
    // Colonnes
    private static final String KEY_PERSONNE_PHYSIQUE_CIN = "numCin";
    private static final String KEY_PERSONNE_PHYSIQUE_NOM = "nom";
    private static final String KEY_PERSONNE_PHYSIQUE_PRENOM = "prenom";
    private static final String KEY_PERSONNE_PHYSIQUE_ADRESSE = "adresse";
    private static final String KEY_PERSONNE_PHYSIQUE_TEL = "numTelephone";
    private static final String KEY_PERSONNE_PHYSIQUE_PROFESSION = "profession";




    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_AUDIENCE =  "CREATE TABLE" + TABLE_AUDIENCE + "(" +
                KEY_AUDIENCE_ID + "TEXT PRIMARY KEY," +
                KEY_AUDIENCE_DATE + "TEXT," +
                KEY_AUDIENCE_TYPE + "TEXT" + ")";
        String CREATE_TABLE_DOCUMENT = "CREATE TABLE" + TABLE_DOCUMENT + "(" +
                KEY_DOCUMENT_ID + "TEXT PRIMARY KEY," +
                KEY_DOCUMENT_CHEMIN + "TEXT" + ")";
        String CREATE_TABLE_DOSSIER = "CREATE TABLE" + TABLE_DOSSIER + "(" +
                KEY_DOSSIER_ID + "TEXT PRIMARY KEY," +
                KEY_DOSSIER_DATE + "TEXT," +
                KEY_DOSSIER_COULEUR + "TEXT," +
                KEY_DOSSIER_REMARQUES + "TEXT," +
                KEY_DOSSIER_TYPE + "TEXT" + ")";
        String CREATE_TABLE_PERSONNE_MORALE = "CREATE TABLE" + TABLE_PERSONNE_MORALE + "(" +
                KEY_PERSONNE_MORALE_MATRICULE_FISCALE + "TEXT PRIMARY KEY," +
                KEY_PERSONNE_MORALE_NOM + "TEXT," +
                KEY_PERSONNE_MORALE_TYPE + "TEXT," +
                KEY_PERSONNE_MORALE_SIEGE_SOCIAL + "TEXT," +
                KEY_PERSONNE_MORALE_REGISTRE_COMMERCE + "TEXT" + ")";
        String CREATE_TABLE_PERSONNE_PHYSIQUE = "CREATE TABLE" + TABLE_PERSONNE_PHYSIQUE + "(" +
                KEY_PERSONNE_PHYSIQUE_CIN + "TEXT PRIMARY KEY," +
                KEY_PERSONNE_PHYSIQUE_NOM + "TEXT," +
                KEY_PERSONNE_PHYSIQUE_PRENOM + "TEXT," +
                KEY_PERSONNE_PHYSIQUE_ADRESSE + "TEXT," +
                KEY_PERSONNE_PHYSIQUE_TEL + "TEXT," +
                KEY_PERSONNE_PHYSIQUE_PROFESSION + "TEXT," + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_AUDIENCE);
        sqLiteDatabase.execSQL(CREATE_TABLE_DOCUMENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_DOSSIER);
        sqLiteDatabase.execSQL(CREATE_TABLE_PERSONNE_MORALE);
        sqLiteDatabase.execSQL(CREATE_TABLE_PERSONNE_PHYSIQUE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_AUDIENCE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_DOCUMENT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_DOSSIER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_PERSONNE_MORALE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_PERSONNE_PHYSIQUE);

        onCreate(sqLiteDatabase);
    }
}
