package com.example.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Services.Songservice;
import com.example.demo.entities.Song;

@Controller
public class SongController {
	@Autowired
	 Songservice service;
	 @PostMapping("/addsong")
	 public String addsong(@ModelAttribute Song song)
	 {
		 boolean songsStatus=service.songExists(song.getName());
		 if(songsStatus==false)
		 {
			service.addsong(song);
			System.out.println("song added sucessfully");
			
		 }
		 else {
			 System.out.println("song already exists");
		 }

		 return "adminHome";
	 }

@GetMapping("/viewSongs")
public String viewsongs(Model model)
{
	List<Song>songsList=service.fetchAllSongs();
	model.addAttribute("songs",songsList);
	
	return "displaysongs";
	
}
@GetMapping("/playSongs")
public String playSongs(Model model)
{
	boolean premiumUser=true;
	if(premiumUser==true)
	{
		List<Song>songsList=service.fetchAllSongs();
		return"displayssongs";
	}
		else {
			return"makepayment";
		
		}
	
}
}
