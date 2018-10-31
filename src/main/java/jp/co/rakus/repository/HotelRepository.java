package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.Hotel;

/**
 * ホテル情報の検索を行うリポジトリ.
 * 
 * @author risa.okumura
 *
 */
@Repository
public class HotelRepository {
	
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER= (rs,i) ->{
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 価格をもとにホテル情報を検索する.
	 * 
	 * @param price　ホテルの価格
	 * @return 入力された価格以下のホテル情報の検索結果
	 */
	public List<Hotel> findByPrice(String price) {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", Integer.parseInt(price));
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER); 
		
		return hotelList;
	}
	 

}
