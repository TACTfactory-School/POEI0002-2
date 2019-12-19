package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public final class UserContract {

    /**
     * Table name.
     */
  public static final String TABLE = "ovg_user";
  /**
   * Column name.
   */
  public static final String COL_ID = "id";
  /**
   * Column name.
   */
  public static final String COL_CREATED_AT = "created_at";
  /**
   * Column name.
   */
  public static final String COL_UPDATED_AT = "updated_at";
  /**
   * Column name.
   */
  public static final String COL_ENABLE = "enable";
  /**
   * Column name.
   */
  public static final String COL_BIRTH_DATE = "birth_date";
  /**
   * Column name.
   */
  public static final String COL_CITY = "city";
  /**
   * Column name.
   */
  public static final String COL_DESCRIPTION = "description";
  /**
   * Column name.
   */
  public static final String COL_EMAIL = "email";
  /**
   * Column name.
   */
  public static final String COL_LAST_CONNECTION_DATE = "last_connection_date";
  /**
   * Column name.
   */
  public static final String COL_MARITAL_STATUS = "marital_status";
  /**
   * Column name.
   */
  public static final String COL_NAME = "name";
  /**
   * Column name.
   */
  public static final String COL_PASSWORD = "password";
  /**
   * Column name.
   */
  public static final String COL_PICTURE = "picture";
  /**
   * Column name.
   */
  public static final String COL_PROFESSION = "profession";
  /**
   * Column name.
   */
  public static final String COL_ROLE = "role";
  /**
   * Column name.
   */
  public static final String COL_SEX = "sex";
  /**
   * Column name.
   */
  public static final String COL_USERNAME = "username";
  /**
   * Length.
   */
  public static final int LENGTH = 255;
  /**
   * default picture.
   */
  public static final String DEFAULT_PICTURE = "default_user.png";
  /**
   * Association table
   */
  public static final String ASC_TABLE_FRIENDS = "ovg_user_friends";
  /**
   * Association table.
   */
  public static final String ASC_COL_FRIEND2 = "friend2_id";
  /**
   * Association table.
   */
  public static final String ASC_COL_FRIEND1 = "friend1_id";

  /**
   * The private constructor.
   */
  private UserContract() {
  }

}
