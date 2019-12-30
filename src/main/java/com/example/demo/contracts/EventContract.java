package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public final class EventContract {
  /**
 * Database table name.
 */
public static final String TABLE = "ovg_event";
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
  public static final String COL_AUTHOR = "author_id";
  /**
   * Column name.
   */
  public static final String COL_DUE_AT = "due_at";
  /**
   * Column name.
   */
  public static final String COL_DESCRIPTION = "description";
  /**
   * Column name.
   */
  public static final String COL_NB_PLACE = "nb_place";
  /**
   * Column name.
   */
  public static final String COL_NB_FREE = "nb_free";
  /**
   * Column name.
   */
  public static final String COL_PHOTO = "photo";
  /**
   * Column name.
   */
  public static final String COL_ADRESSE = "adresse";
  /**
   * Column name.
   */
  public static final String COL_CITY = "city";
  /**
   * Column name.
   */
  public static final String COL_CP = "cp";
  /**
   * Column name.
   */
  public static final String COL_TITLE = "title";
  /**
   * Column name.
   */
  public static final String AUTHOR = "author";
  /**
   * Maximum length of description.
   */
  public static final int DESC_LENGTH = 5000;
  /**
   * Length of other strings.
   */
  public static final int STRING_LENGTH = 255;

  /**
   * The private constructor.
   */
  private EventContract() {
  }
}
