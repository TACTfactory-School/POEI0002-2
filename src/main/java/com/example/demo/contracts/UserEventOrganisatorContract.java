package com.example.demo.contracts;

public class UserEventOrganisatorContract extends BaseContract {


    public final static String TABLE = "ovg_user_event_organisator";

    public final static String COL_ID = "id";
    public final static String COL_CREATED_AT = "created_at";
    public final static String COL_UPDATED_AT = "updated_at";
    public final static String COL_ENABLE = "enable";
    public final static String COL_USER = "organisator_id";
    public final static String COL_EVENT = "event_id";

    public final static String EVENT_ORGANISATOR = "eventOrganisator";
    public final static String USER_ORGANISATOR = "userOrganisator";

    public final static String[] COLS = new String[] {
            COL_ID,
            COL_CREATED_AT,
            COL_UPDATED_AT,
            COL_ENABLE,
            COL_USER,
            COL_EVENT
    };

    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE +"(" +
            COL_ID + " bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COL_CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP," +
            COL_UPDATED_AT + " DATETIME ON UPDATE CURRENT_TIMESTAMP," +//DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
            COL_ENABLE + " BIT(1) DEFAULT 1," +
            COL_USER + " int NOT NULL," +
            COL_EVENT + " int NOT NULL" +
            ")";

    public UserEventOrganisatorContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }
}
