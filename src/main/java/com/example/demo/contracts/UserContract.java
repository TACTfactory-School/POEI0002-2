package com.example.demo.contracts;

public class UserContract extends BaseContract {

    public final static String TABLE = "ovg_user";

    public final static String COL_ID = "id";
    public final static String COL_CREATED_AT = "created_at";
    public final static String COL_UPDATED_AT = "updated_at";
    public final static String COL_ENABLE = "enable";
    public final static String COL_BIRTH_DATE = "birth_date";
    public final static String COL_CITY = "city";
    public final static String COL_DESCRIPTION = "description";
    public final static String COL_EMAIL = "email";
    public final static String COL_LAST_CONNECTION_DATE = "last_connection_date";
    public final static String COL_MARITAL_STATUS = "marital_status";
    public final static String COL_NAME = "name";
    public final static String COL_PASSWORD = "password";
    public final static String COL_PICTURE = "picture";
    public final static String COL_PROFESSION = "profession";
    public final static String COL_ROLE = "role";
    public final static String COL_SEX = "sex";
    public final static String COL_USERNAME = "username";

    public static final int LENGTH = 255;

    public final static String DEFAULT_PICTURE = "default_user.png";
    public final static String ASC_TABLE_FRIENDS = "ovg_user_friends";
    public final static String ASC_COL_FRIEND1 = "friend1_id";
    public final static String ASC_COL_FRIEND2 = "friend2_id";

    public final static String[] COLS = new String[] {
            COL_ID,
            COL_CREATED_AT,
            COL_UPDATED_AT,
            COL_ENABLE,
            COL_BIRTH_DATE,
            COL_CITY,
            COL_DESCRIPTION,
            COL_EMAIL,
            COL_LAST_CONNECTION_DATE,
            COL_MARITAL_STATUS,
            COL_NAME,
            COL_PASSWORD,
            COL_PICTURE,
            COL_PROFESSION,
            COL_ROLE,
            COL_SEX,
            COL_USERNAME
    };

    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE +"(" +
            COL_ID + " bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COL_CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP," +
            COL_UPDATED_AT + " DATETIME ON UPDATE CURRENT_TIMESTAMP," +//DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
            COL_ENABLE + " BIT(1) DEFAULT 1," +
            COL_BIRTH_DATE + " DATETIME," +
            COL_CITY + " VARCHAR("+LENGTH+") NOT NULL," +
            COL_DESCRIPTION + " VARCHAR("+LENGTH+")," +
            COL_EMAIL + " VARCHAR("+LENGTH+")," +
            COL_LAST_CONNECTION_DATE + " DATETIME," +
            COL_MARITAL_STATUS + " VARCHAR("+LENGTH+")," +
            COL_NAME + " VARCHAR("+LENGTH+")," +
            COL_PASSWORD + " VARCHAR("+LENGTH+")," +
            COL_PICTURE + " VARCHAR("+LENGTH+") DEFAULT "+DEFAULT_PICTURE+"," +
            COL_PROFESSION + " VARCHAR("+LENGTH+")," +
            COL_ROLE + " VARCHAR("+LENGTH+") NOT NULL," +
            COL_SEX + " VARCHAR("+LENGTH+")," +
            COL_USERNAME + " VARCHAR("+LENGTH+") NOT NULL" +
            ")";

    public UserContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }
}
