package jp.co.rakus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Hotel;
import jp.co.rakus.repository.HotelRepository;

/**
 * ホテルの検索情報を表すコントローラー.
 * 
 * @author risa.okumura
 *
 */
@Controller
@Transactional
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private HotelRepository repository;
	
	/**
	 * ホテルの検索画面を表示する.
	 * 
	 * @return 検索画面
	 */
//	@SuppressWarnings("unchecked")
	@RequestMapping("/toHotel")
	public String toHotel() {
//		
//		List<Hotel> hotelList = (List<Hotel>)application.getAttribute("hotelList");
//		
//		if (hotelList == null) {
//			hotelList = new ArrayList<>();
//		}
//		application.setAttribute("hotelList", hotelList);
		return "hotelSearch";
	}
	
	/**
	 * ホテルの検索結果を表示する.
	 * 
	 * @param price ホテルの価格
	 * @return 検索結果画面
	 */
	@RequestMapping("/hotelInfo")
	public String hotelInfo(String price) {
		List<Hotel> hotelList = repository.findByPrice(price);
		application.setAttribute("hotelList", hotelList);
		
		return "hotelSearch";
		
	}


}
