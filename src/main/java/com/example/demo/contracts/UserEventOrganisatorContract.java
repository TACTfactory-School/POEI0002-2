package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public class UserEventOrganisatorContract {

  /**
   ** The constants used by the UserEventOrganisator class.
   **/
  public static final String TABLE = "ovg_user_event_organisator";
  public static final String COL_ID = "id";
  public static final String COL_CREATED_AT = "created_at";
  public static final String COL_UPDATED_AT = "updated_at";
  public static final String COL_ENABLE = "enable";
  public static final String COL_USER = "organisator_id";
  public static final String COL_EVENT = "event_id";
  public static final String EVENT_ORGANISATOR = "eventOrganisator";
  public static final String USER_ORGANISATOR = "userOrganisator";


  /**
   * The private constructor.
   */
  private UserEventOrganisatorContract() {
  }

}
