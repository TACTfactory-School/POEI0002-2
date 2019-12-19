package com.example.demo.entities;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


/**
 * Extended by all entities.
 * @author renau
 */
@MappedSuperclass
public class EntityBase {

  /**
 * Id of the entity.
 */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "The generated database ID", readOnly = true)
  private Long id;

  /**
 * Creation date.
 */
  @CreationTimestamp
  private LocalDateTime createdAt;
  /**
 * Last modification date.
 */
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  /**
 * allow the desactivation of an entity.
 */
  private Boolean enable;

  protected EntityBase() {
    super();
  }

  /**
   * @return the id.
   */
  public Long getId() {
    return id;
  }

  /**
   * @return the creation date.
   */
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Set the creation date.
   * @param createdAt creation date in LocalDateTime.
   */
  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return Return the date of the last modification.
   */
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Set the last modification date.
   * @param updatedAt last modification date in LocalDateTime.
   */
  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * Set the id.
   * @param id Entity id.
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @return the enabled boolean.
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * Set the enabled boolean.
   * @param enable Wether the entity is enabled or not.
   */
  public void setEnable(final Boolean enable) {
    this.enable = enable;
  }


}
