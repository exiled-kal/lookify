package com.tseringkalden.liquify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tseringkalden.liquify.models.Song;
import com.tseringkalden.liquify.services.SongService;


public class SongsController {
	@Controller
	public class Songs {
		private final SongService songService;

		public Songs(SongService songService) {
			this.songService = songService;
		}

		@RequestMapping("/")
		public String index() {
			
		    return "index.jsp";
		}

		@RequestMapping("/dashboard")
		public String dash(Model model) {
			List<Song> songs = songService.allSongs();
			model.addAttribute("songs", songs);
			return "dashboard.jsp";
		}

		@RequestMapping("/songs/new")
		public String newSong(@ModelAttribute("song") Song song) {
			return "newsong.jsp";
		}

		@PostMapping("/songs/new")
		public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
			if (result.hasErrors()) {
				return "newsong.jsp";
			} else {
				songService.addSong(song);
				return "redirect:/dashboard";
			}
		}

		@RequestMapping("/songs/{id}")
		public String showSong(@PathVariable("id") Long id, Model model) {
			Song song = songService.findSongById(id);
			if (song != null) {
				model.addAttribute("song", song);
				return "showsong.jsp";
			} else {
				return "redirect:/dashboard";
			}
		}

		@RequestMapping("/songs/delete/{id}")
		public String destroySong(@PathVariable("id") Long id) {
			songService.destroySong(id);
			return "redirect:/dashboard";
		}

		@RequestMapping("/topTen")
		public String showTop(Model model) {
			List<Song> songs = songService.findTop10();
			model.addAttribute("songs", songs);
			return "topsong.jsp";
		}

		@PostMapping("/songs/search")
		public String searchSong(Model model, @RequestParam("searchQuery") String searchQuery) {
			List<Song> songs = songService.findSongs(searchQuery);
			model.addAttribute("songs", songs);
			return "searchresult.jsp";
		}

	}

}
