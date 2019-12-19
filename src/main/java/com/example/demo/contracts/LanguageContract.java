package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public final class LanguageContract {

    /**
     * Table name.
     */
  public static final String TABLE = "ovg_languages";
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
  public static final String COL_LABEL = "label";
  /**
   * Length.
   */
  public static final int LENGTH = 255;

  /**
   * The private constructor.
   */
  private LanguageContract() {
  }

}
