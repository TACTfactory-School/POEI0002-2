package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public final class UserEventOrganisatorContract {

    /**
     * Table name.
     */
  public static final String TABLE = "ovg_user_event_organisator";
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
  public static final String COL_USER = "organisator_id";
  /**
   * Column name.
   */
  public static final String COL_EVENT = "event_id";
  /**
   * Event organisator
   */
  public static final String EVENT_ORGANISATOR = "eventOrganisator";
  /**
   * User organisator.
   */
  public static final String USER_ORGANISATOR = "userOrganisator";


  /**
   * The private constructor.
   */
  private UserEventOrganisatorContract() {
  }

}
