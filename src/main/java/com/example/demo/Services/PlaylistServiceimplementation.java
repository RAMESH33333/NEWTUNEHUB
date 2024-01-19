package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.Playlistreporesotory;
import com.example.demo.entities.Playlist;

@Service
public class PlaylistServiceimplementation  implements PlaylistService
{
	@Autowired
	Playlistreporesotory repo;
@Override
	public void addPlaylist(Playlist playlist)
	{
	repo.save(playlist);
	
	}
@Override
public List<Playlist> fetchAllPlaylists() {
	// TODO Auto-generated method stub
	return repo.findAll();
	}
}
