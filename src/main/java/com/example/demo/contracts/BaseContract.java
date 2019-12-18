package com.example.demo.contracts;

public abstract class BaseContract {

    public final String TABLE;

    public final String COL_ID;

    public final String ALIASED_COL_ID;

    public final String[] COLS;

    public final String[] ALIASED_COLS;

    public final String INSERT;

    public final String UPDATE;

    public final String DELETE;

    public final String SELECTALL;

    public final String SELECT;

    public final String CREATE_TABLE;

    public final String DROP_TABLE;

    public BaseContract(String table, String col_id, String[] cols, String createTable) {
        TABLE = table;
        COL_ID = col_id;
        COLS = cols;
        CREATE_TABLE = createTable;
        ALIASED_COL_ID = TABLE + "." + COL_ID;
        DROP_TABLE = "DROP TABLE " + TABLE;

        ALIASED_COLS = aliasedCols();
        INSERT = insert();
        UPDATE = update();
        DELETE = delete();
        SELECTALL = selectAll();
        SELECT = select();
    }

    private String[] aliasedCols() {
        String[] result = new String[COLS.length];
        for (int i = 0; i < COLS.length; i++) {
            result[i] = TABLE + "." + COLS[i];
        }
        return result;
    }

    private String insert() {
        StringBuilder result = new StringBuilder();
        result.append("INSERT INTO " + TABLE + "(");

        int j = 0;
        for (; j < COLS.length - 1; j++) {
            result.append(COLS[j] + ",");
        }
        result.append(COLS[j]);

        result.append(") VALUES(");

        for (int i = 0; i < COLS.length - 1; i++) {
            result.append("?,");
        }
        result.append("?");

        result.append(")");
        return result.toString();
    }

    private String update() {
        StringBuilder result = new StringBuilder();
        result.append("UPDATE " + TABLE + " SET ");

        int j = 1;
        for (; j < COLS.length - 1; j++) {
            result.append(COLS[j] + " = ?,");
        }
        result.append(COLS[j] + " = ? ");

        result.append(" WHERE " + COL_ID + " = ?");

        return result.toString();
    }

    private String delete() {
        StringBuilder result = new StringBuilder();

        result.append("DELETE FROM " + TABLE + " WHERE " + COL_ID + " = ?");

        return result.toString();
    }

    private String selectAll() {
        StringBuilder result = selectBase();

        return result.toString();
    }

    private String select() {
        StringBuilder result = selectBase();
        result.append(" WHERE " + COL_ID + " = ?");

        return result.toString();
    }

    private StringBuilder selectBase() {
        StringBuilder result = new StringBuilder();
        result.append("SELECT ");

        int j = 0;
        for (; j < COLS.length - 1; j++) {
            result.append(COLS[j] + ",");
        }
        result.append(COLS[j]);
        result.append(" FROM " + TABLE);
        return result;
    }
}

