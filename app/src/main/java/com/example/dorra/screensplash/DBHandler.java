package com.example.dorra.screensplash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    // Nom de la table Avocat
    private static final String TABLE_AVOCAT = "avocat";
    // Colonnes
    private static final String KEY_AVOCAT_MAIL = "mail";
    private static final String KEY_AVOCAT_PASSWORD = "password";
    private static final String KEY_AVOCAT_NOM = "nom";
    private static final String KEY_AVOCAT_PRENOM = "prenom";
    private static final String KEY_AVOCAT_PHOTO = "cheminPhoto";

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
        String CREATE_TABLE_AVOCAT = "CREATE TABLE" + TABLE_AVOCAT + "(" +
                KEY_AVOCAT_MAIL + "TEXT PRIMARY KEY," +
                KEY_AVOCAT_PASSWORD + "TEXT," +
                KEY_AVOCAT_NOM + "TEXT," +
                KEY_AVOCAT_PRENOM + "TEXT," +
                KEY_AVOCAT_PHOTO + "TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_TABLE_AUDIENCE);
        sqLiteDatabase.execSQL(CREATE_TABLE_DOCUMENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_DOSSIER);
        sqLiteDatabase.execSQL(CREATE_TABLE_PERSONNE_MORALE);
        sqLiteDatabase.execSQL(CREATE_TABLE_PERSONNE_PHYSIQUE);
        sqLiteDatabase.execSQL(CREATE_TABLE_AVOCAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_AUDIENCE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_DOCUMENT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_DOSSIER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_PERSONNE_MORALE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_PERSONNE_PHYSIQUE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_AVOCAT);

        onCreate(sqLiteDatabase);
    }

    public void addAudience(Audience audience){ //Ajouter une audience
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_AUDIENCE_DATE, audience.getDate());
        values.put(KEY_AUDIENCE_TYPE, audience.getType());
        sqLiteDatabase.insert(TABLE_AUDIENCE, null, values);
        sqLiteDatabase.close();
    }

    public void addAvocat(Avocat avocat){ //Ajouter un Avocat
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_AVOCAT_MAIL, avocat.getMail());
        values.put(KEY_AVOCAT_PASSWORD, avocat.getPassword()); // TODO: 24/01/2017 Utiliser un webservice pour le mot de passe
        values.put(KEY_AVOCAT_NOM, avocat.getNom());
        values.put(KEY_AVOCAT_PHOTO, avocat.getCheminPhoto()); // TODO: 24/01/2017 Enregistrer l'image dans l'app
        sqLiteDatabase.insert(TABLE_AVOCAT, null, values);
        sqLiteDatabase.close();
    }

    public void addDocument(Document document){ //Ajouter un document
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DOCUMENT_CHEMIN, document.getChemin()); // TODO: 24/01/2017 Enregistrer le doc dans l'app
        sqLiteDatabase.insert(TABLE_DOCUMENT, null, values);
        sqLiteDatabase.close();
    }

    public void addDossier(Dossier dossier){ //Ajouter un dossier
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DOSSIER_DATE, dossier.getDateAcceptaion());
        values.put(KEY_DOSSIER_TYPE, dossier.getType());
        values.put(KEY_DOSSIER_COULEUR, dossier.getCouleur());
        values.put(KEY_DOSSIER_REMARQUES, dossier.getRemarques());
        sqLiteDatabase.insert(TABLE_DOSSIER, null, values);
        sqLiteDatabase.close();
    }

    public void addPersonneMorale(PersonneMorale personneMorale){ //Ajouter une personne morale
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PERSONNE_MORALE_MATRICULE_FISCALE, personneMorale.getMatriculeFiscale());
        values.put(KEY_PERSONNE_MORALE_NOM, personneMorale.getNom());
        values.put(KEY_PERSONNE_MORALE_TYPE, personneMorale.getNom());
        values.put(KEY_PERSONNE_MORALE_SIEGE_SOCIAL, personneMorale.getSiegeSocial());
        values.put(KEY_PERSONNE_MORALE_REGISTRE_COMMERCE, personneMorale.getNumRegistreCommerce());
        sqLiteDatabase.insert(TABLE_PERSONNE_MORALE, null, values);
        sqLiteDatabase.close();
    }

    public void addPersonnePhysique(PersonnePhysique personnePhysique){ //Ajouter une personne physique
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PERSONNE_PHYSIQUE_CIN, personnePhysique.getNumCin());
        values.put(KEY_PERSONNE_PHYSIQUE_NOM, personnePhysique.getNom());
        values.put(KEY_PERSONNE_PHYSIQUE_PRENOM, personnePhysique.getPrenom());
        values.put(KEY_PERSONNE_PHYSIQUE_TEL, personnePhysique.getNumTelephone());
        values.put(KEY_PERSONNE_PHYSIQUE_ADRESSE, personnePhysique.getAdresse());
        values.put(KEY_PERSONNE_PHYSIQUE_PROFESSION, personnePhysique.getProfession());
        sqLiteDatabase.insert(TABLE_PERSONNE_PHYSIQUE, null, values);
        sqLiteDatabase.close();
    }

    public Audience getAudience(String date){ //lire une audience
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_AUDIENCE, new String[] {KEY_AUDIENCE_ID, KEY_AUDIENCE_DATE,
                KEY_AUDIENCE_TYPE}, KEY_AUDIENCE_ID + "=?", new String[] {date}, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Audience audience = new Audience(cursor.getString(0),cursor.getString(1),cursor.getString(2));
        return audience;
    }

    public Avocat getAvocat(String mail){ //lire un avocat
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_AVOCAT, new String[] {KEY_AVOCAT_MAIL, KEY_AVOCAT_PASSWORD,
                KEY_AVOCAT_NOM, KEY_AVOCAT_PRENOM, KEY_AVOCAT_PHOTO}, KEY_AVOCAT_MAIL + "=?", new String[] {mail}, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Avocat avocat = new Avocat(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
        return avocat;
    }
    // DISCONTINUED
}
