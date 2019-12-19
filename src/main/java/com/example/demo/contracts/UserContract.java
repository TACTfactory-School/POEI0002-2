package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public class UserContract {

  /**
   ** The constants used by the User class.
   **/
  public static final String TABLE = "ovg_user";
  public static final String COL_ID = "id";
  public static final String COL_CREATED_AT = "created_at";
  public static final String COL_UPDATED_AT = "updated_at";
  public static final String COL_ENABLE = "enable";
  public static final String COL_BIRTH_DATE = "birth_date";
  public static final String COL_CITY = "city";
  public static final String COL_DESCRIPTION = "description";
  public static final String COL_EMAIL = "email";
  public static final String COL_LAST_CONNECTION_DATE = "last_connection_date";
  public static final String COL_MARITAL_STATUS = "marital_status";
  public static final String COL_NAME = "name";
  public static final String COL_PASSWORD = "password";
  public static final String COL_PICTURE = "picture";
  public static final String COL_PROFESSION = "profession";
  public static final String COL_ROLE = "role";
  public static final String COL_SEX = "sex";
  public static final String COL_USERNAME = "username";
  public static final int LENGTH = 255;
  public static final String DEFAULT_PICTURE = "default_user.png";
  public static final String ASC_TABLE_FRIENDS = "ovg_user_friends";
  public static final String ASC_COL_FRIEND2 = "friend2_id";
  public static final String ASC_COL_FRIEND1 = "friend1_id";

  /**
   * The private constructor.
   */
  private UserContract() {
  }

}
