package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public class EventContract {

  /**
  ** The constants used by the Event class.
  **/
  public static final String TABLE = "ovg_event";
  public static final String COL_ID = "id";
  public static final String COL_CREATED_AT = "created_at";
  public static final String COL_UPDATED_AT = "updated_at";
  public static final String COL_ENABLE = "enable";
  public static final String COL_AUTHOR = "author_id";
  public static final String COL_DUE_AT = "due_at";
  public static final String COL_DESCRIPTION = "description";
  public static final String COL_NB_PLACE = "nb_place";
  public static final String COL_PHOTO = "photo";
  public static final String COL_ADRESSE = "adresse";
  public static final String COL_CITY = "city";
  public static final String COL_CP = "cp";
  public static final String COL_TITLE = "title";
  public static final String AUTHOR = "author";
  public static final int DESC_LENGTH = 5000;
  public static final int STRING_LENGTH = 255;

  /**
   * The private constructor.
   */
  private EventContract() {
  }
}