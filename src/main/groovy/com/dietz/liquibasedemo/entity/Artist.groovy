package com.dietz.liquibasedemo.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id

    String name

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Album> albums
}
