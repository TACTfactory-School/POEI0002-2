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
 * @author renau
 *
 */
@MappedSuperclass
public class EntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "The generated database ID", readOnly = true)
  private Long id;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  private Boolean enable;

  protected EntityBase() {
    super();
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Boolean getEnable() {
    return enable;
  }

  public void setEnable(final Boolean enable) {
    this.enable = enable;
  }


}
