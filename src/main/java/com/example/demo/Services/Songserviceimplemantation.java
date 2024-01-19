package com.example.demo.Services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.SongRepository;
import com.example.demo.entities.Song;

@Service
public class Songserviceimplemantation implements Songservice{
	
	@Autowired
	SongRepository repo;

	@Override
	public void addsong(Song song) {
		repo.save(song);
		
	}

	@Override
	public List<Song> fetchAllSongs() {
		return repo.findAll();
}

	@Override
	public boolean songExists(String name) {
		Song song=repo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void updatesong(Song song) {
		repo.save(song);
		
	}
		}