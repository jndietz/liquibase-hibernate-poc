package com.dietz.liquibasedemo

import com.dietz.liquibasedemo.entity.Album
import com.dietz.liquibasedemo.entity.Artist
import com.dietz.liquibasedemo.entity.Song
import com.dietz.liquibasedemo.repository.ArtistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class ArtistRepositoryIntSpec extends Specification {

    @Autowired
    ArtistRepository repository

    def "repository can persist data"() {
        given: "a new artist"
            def songs = [new Song(songName: "White Knuckles"), new Song(songName: "Ties That Bind")]
            def albums = [new Album(name: "The Last Hero"), new Album(name: "Blackbird", songs: songs)]
            def artist = new Artist(name: "Mark Tremonti")
            def anotherArtist = new Artist(name: "Alter Bridge", albums: albums)

        when: "the artist is saved to the database"
            repository.save(artist)
            repository.save(anotherArtist)

        then: "the artist can be retrieved"
            repository != null
            artist.id == 1
            anotherArtist.id == 2
            anotherArtist.albums.size() == 2
            def album = anotherArtist.albums.find { it -> it.name == "Blackbird" }
            album.songs.size() == 2
    }
}
