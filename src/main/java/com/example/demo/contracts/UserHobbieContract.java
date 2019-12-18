package com.example.demo.contracts;

public class UserHobbieContract extends BaseContract {

    public final static String TABLE = "ovg_user_hobbie";

    public final static String COL_ID = "id";
    public final static String COL_CREATED_AT = "created_at";
    public final static String COL_UPDATED_AT = "updated_at";
    public final static String COL_ENABLE = "enable";
    public final static String COL_USER = "user_id";
    public final static String COL_HOBBIE = "hobbie_id";

    public final static String HOBBIE = "hobbie";
    public final static String USER_HOBBIE = "user";

    public final static String[] COLS = new String[] {
            COL_ID,
            COL_CREATED_AT,
            COL_UPDATED_AT,
            COL_ENABLE,
            COL_USER,
            COL_HOBBIE
    };

    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE +"(" +
            COL_ID + " bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COL_CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP," +
            COL_UPDATED_AT + " DATETIME ON UPDATE CURRENT_TIMESTAMP," +//DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
            COL_ENABLE + " BIT(1) DEFAULT 1," +
            COL_USER + " int NOT NULL," +
            COL_HOBBIE + " int NOT NULL" +
            ")";

    public UserHobbieContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }
}
