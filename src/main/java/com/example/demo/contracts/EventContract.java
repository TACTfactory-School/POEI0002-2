package com.example.demo.contracts;

public class EventContract extends BaseContract {

    public final static String TABLE = "ovg_event";

    public final static String COL_ID = "id";
    public final static String COL_CREATED_AT = "created_at";
    public final static String COL_UPDATED_AT = "updated_at";
    public final static String COL_ENABLE = "enable";
    public final static String COL_AUTHOR = "author_id";
    public final static String COL_DUE_AT = "due_at";
    public final static String COL_DESCRIPTION = "description";
    public final static String COL_NB_PLACE = "nb_place";
    public final static String COL_PHOTO = "photo";
    public final static String COL_ADRESSE = "adresse";
    public final static String COL_CITY = "city";
    public final static String COL_CP = "cp";
    public final static String COL_TITLE = "title";

    public final static String AUTHOR = "author";

    public static final int DESC_LENGTH = 5000;
    public static final int STRING_LENGTH = 255;

    public final static String[] COLS = new String[] {
            COL_ID,
            COL_CREATED_AT,
            COL_UPDATED_AT,
            COL_ENABLE,
            COL_AUTHOR,
            COL_DUE_AT,
            COL_DESCRIPTION,
            COL_PHOTO,
            COL_NB_PLACE,
            COL_ADRESSE,
            COL_CP,
            COL_CITY,
            COL_TITLE
    };
    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE +"(" +
            COL_ID + " bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COL_CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP," +
            COL_UPDATED_AT + " DATETIME ON UPDATE CURRENT_TIMESTAMP," +//DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
            COL_ENABLE + " BIT(1) DEFAULT 1," +
            COL_AUTHOR + " int NOT NULL," +
            COL_DUE_AT + " DATETIME NOT NULL," +
            COL_DESCRIPTION + " VARCHAR("+DESC_LENGTH+") NOT NULL," +
            COL_PHOTO + " VARCHAR("+STRING_LENGTH+") NOT NULL," +
            COL_NB_PLACE + " int NOT NULL," +
            COL_ADRESSE + " VARCHAR("+STRING_LENGTH+")," +
            COL_CITY + " VARCHAR("+STRING_LENGTH+") NOT NULL," +
            COL_CP + " int(11) ," +
            COL_TITLE + " VARCHAR("+STRING_LENGTH+") NOT NULL" +
            ")";

    public EventContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }
}
