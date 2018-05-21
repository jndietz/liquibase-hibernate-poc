package com.dietz.liquibasedemo.service

import com.dietz.liquibasedemo.entity.Artist
import org.springframework.stereotype.Service

@Service
class ArtistService {
    def getArtistName(Artist artist) {
        artist.name
    }
}
