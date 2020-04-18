package com.tseringkalden.liquify.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tseringkalden.liquify.models.Song;


//telling spring that this is a repository

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findTop10ByOrderByRatingDesc();
	List<Song> findByArtistContaining(String search);
}
    // this method retrieves all songs from a specific artist
    // this method retrieves the 10 songs with the highest ratings
	

