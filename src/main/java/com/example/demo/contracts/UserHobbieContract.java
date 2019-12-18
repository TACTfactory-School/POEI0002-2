package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public class UserHobbieContract extends BaseContract {

  /**
   ** The constants used by the UserHobbie class.
   **/
  public static final String TABLE = "ovg_user_hobbie";
  public static final String COL_ID = "id";
  public static final String COL_CREATED_AT = "created_at";
  public static final String COL_UPDATED_AT = "updated_at";
  public static final String COL_ENABLE = "enable";
  public static final String COL_USER = "user_id";
  public static final String COL_HOBBIE = "hobbie_id";
  public static final String HOBBIE = "hobbie";
  public static final String USER_HOBBIE = "user";

  /**
   * The private constructor.
   */
  private UserHobbieContract() {
  }
}
