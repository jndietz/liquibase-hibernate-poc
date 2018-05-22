package com.dietz.liquibasedemo.entity

import javax.persistence.*

@Entity
class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id

    int releaseYear

    String name

    @ManyToOne
    Artist artist

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Song> songs
}
