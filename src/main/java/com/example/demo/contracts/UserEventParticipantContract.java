package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public class UserEventParticipantContract extends BaseContract {

  /**
   ** The constants used by the UserEventParticipant class.
   **/
  public static final String TABLE = "ovg_user_event_participant";
  public static final String COL_ID = "id";
  public static final String COL_CREATED_AT = "created_at";
  public static final String COL_UPDATED_AT = "updated_at";
  public static final String COL_ENABLE = "enable";
  public static final String COL_USER = "participant_id";
  public static final String COL_EVENT = "event_id";
  public static final String EVENT_PARTICIPANT = "eventParticipant";
  public static final String USER_PARTICIPANT = "userParticipant";

  /**
   * The private constructor.
   */
  private UserEventParticipantContract() {
  }
}



