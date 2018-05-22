package com.dietz.liquibasedemo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id

    String songName

    @ManyToOne
    Album album

}
