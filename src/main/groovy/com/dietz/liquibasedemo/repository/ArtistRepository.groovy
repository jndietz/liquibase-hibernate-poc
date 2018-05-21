package com.dietz.liquibasedemo.repository

import com.dietz.liquibasedemo.entity.Artist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Artist findByName(String name)
}
