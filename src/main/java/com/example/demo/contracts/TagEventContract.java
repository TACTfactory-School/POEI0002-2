package com.example.demo.contracts;

/**
 * Utility class for defining constants.
 * @author Cheikh E.
 */

public class TagEventContract extends BaseContract {

  /**
   ** The constants used by the TagEvent class.
   **/
  public static final String TABLE = "ovg_tag_event";
  public static final String COL_ID = "id";
  public static final String COL_CREATED_AT = "created_at";
  public static final String COL_UPDATED_AT = "updated_at";
  public static final String COL_ENABLE = "enable";
  public static final String COL_EVENT = "event_id";
  public static final String COL_TAG = "tag_id";
  public static final String TAG = "tag";
  public static final String EVENT = "event";

  /**
   * The private constructor.
   */
  private TagEventContract() {
  }


}

