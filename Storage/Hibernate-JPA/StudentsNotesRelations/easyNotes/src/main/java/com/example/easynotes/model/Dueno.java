package com.example.easynotes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student {

@Id
@GeneratedValue
Long id;

@OneToMany
Set<Subject> subjects = new HashSet<>();

}
