package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.AlbumDAO;
import com.example.lesson02.model.Album;

// Business object (가공...로직이 있는 클래스)
@Service
public class AlbumBO {
	
	@Autowired
	private AlbumDAO albumDAO;
	
	public List<Album> getAlbumList() {
		List<Album> albumList = albumDAO.selectAlbumList();
		return albumList;
		
		// return albumDAO.selectAlbumList(); 만해줘도 무관!
	}
}
