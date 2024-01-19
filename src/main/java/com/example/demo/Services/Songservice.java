package com.example.demo.Services;

import java.util.List;


import com.example.demo.entities.Song;

public interface Songservice {

	public void addsong(Song song);
	public List<Song> fetchAllSongs();
	public boolean songExists(String name);
	public void updatesong(Song song);

	

}
