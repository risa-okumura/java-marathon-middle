package jp.co.rakus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Clothes;
import jp.co.rakus.repository.ClothesRepository;

/**
 * 洋服の検索情報を表示するコントローラー.
 * 
 * @author risa.okumura
 *
 */
@Controller
@Transactional
@RequestMapping("/clothes")
public class ClothesController {
	
	@Autowired
	private ClothesRepository repository;
	
	@Autowired
	private ServletContext application;

	
	/**
	 * 検索画面を表示する.
	 * 
	 * @return　検索画面
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/toClothes")
	public String toClothes() {
		
		List<Clothes> clothesList = (List<Clothes>)application.getAttribute("clothesList");
		
		if (clothesList == null) {
			clothesList = new ArrayList<>();
		}
		
		application.setAttribute("clothesList", clothesList);
		
		return "clothesSearch";
	}
	
	/**
	 * 検索結果を表示する.
	 * 
	 * @param gender　性別
	 * @param color　色
	 * @return　検索結果画面
	 */
	@RequestMapping("/clothesInfo")
	public String clothesInfo(int gender,String color) {
		List<Clothes> clothesList = repository.findByGenderAndColor(gender, color);
		application.setAttribute("clothesList", clothesList);
		
		return "clothesSearch";
	}
	
	
	
	

}
