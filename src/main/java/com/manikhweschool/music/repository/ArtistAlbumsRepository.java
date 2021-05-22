package com.manikhweschool.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikhweschool.music.model.ArtistsAlbums;

@Repository
public interface ArtistAlbumsRepository extends JpaRepository<ArtistsAlbums,Long>{

}
