package com.manikhweschool.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikhweschool.music.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album,String>{

}
