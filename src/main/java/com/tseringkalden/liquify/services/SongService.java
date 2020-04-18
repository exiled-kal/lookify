package com.tseringkalden.liquify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tseringkalden.liquify.models.Song;
import com.tseringkalden.liquify.repositories.SongRepository;


@Service
public class SongService {
	private SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs() {
		return (List<Song>) songRepository.findAll();
	}
	
	public void addSong(Song song) {
		songRepository.save(song);
	}
	
	public void destroySong(Long id) {
		songRepository.deleteById(id);
	}
	
	public Song findSongById(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
	}
	
	public List<Song> findTop10() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	public List<Song> findSongs(String search) {
		return songRepository.findByArtistContaining(search);
	}
}
