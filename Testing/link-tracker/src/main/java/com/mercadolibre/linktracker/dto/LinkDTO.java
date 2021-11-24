package com.mercadolibre.linktracker.dto;


import java.util.Objects;

public class LinkDTO {
  private Integer linkId;
  private String link;
  private String password;
  private Integer count;

  public LinkDTO(Integer linkId, String link, String password, Integer count) {
    this.linkId = linkId;
    this.link = link;
    this.password = password;
    this.count = count;
  }

  public LinkDTO() {
    this.count = 0;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getLinkId() {
    return linkId;
  }

  public void setLinkId(Integer linkId) {
    this.linkId = linkId;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void sumCount() {
    count++;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LinkDTO linkDTO = (LinkDTO) o;
    return Objects.equals(linkId, linkDTO.linkId) && Objects.equals(link, linkDTO.link) && Objects.equals(password, linkDTO.password) && Objects.equals(count, linkDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(linkId, link, password, count);
  }



}