package com.example.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Services.PlaylistService;
import com.example.demo.Services.Songservice;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;

@Controller
public class PlaylistController {
	@Autowired
	Songservice songservice;
	@Autowired
	PlaylistService playlistService;
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model)
	{
		List<Song>songsList=songservice.fetchAllSongs();
		model.addAttribute("songs",songsList);
		return "createPlaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
	playlistService.addPlaylist(playlist);
	List<Song> songList=playlist.getSongs();
	for(Song s:songList)
	{
		s.getPlaylist().add(playlist);
		//update song object i db
		songservice.updatesong(s);
	}
	return "adminHome";
	
	}
	@GetMapping("/viewPlaylists")
	public String viewPlaylist(Model model)
	{
		List<Playlist>allPlaylists=playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists",allPlaylists);
		return"displayPlaylists";
	}
}

	
