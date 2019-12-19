package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public final class UserEventParticipantContract {

    /**
     * Table name.
     */
  public static final String TABLE = "ovg_user_event_participant";
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
  public static final String COL_USER = "participant_id";
  /**
   * Column name.
   */
  public static final String COL_EVENT = "event_id";
  /**
   * Event participant.
   */
  public static final String EVENT_PARTICIPANT = "eventParticipant";
  /**
   * User participant.
   */
  public static final String USER_PARTICIPANT = "userParticipant";

  /**
   * The private constructor.
   */
  private UserEventParticipantContract() {
  }
}



