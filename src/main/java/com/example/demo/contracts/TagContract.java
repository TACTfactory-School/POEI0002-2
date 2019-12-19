package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public class TagContract {

  /**
   ** The constants used by the Tag class.
   **/
  public static final String TABLE = "ovg_tags";
  public static final String COL_ID = "id";
  public static final String COL_CREATED_AT = "created_at";
  public static final String COL_UPDATED_AT = "updated_at";
  public static final String COL_ENABLE = "enable";
  public static final String COL_LABEL = "label";
  public static final int LENGTH = 255;

  /**
   * The private constructor.
   */
  private TagContract() {
  }

}