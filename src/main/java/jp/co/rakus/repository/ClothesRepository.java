package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.Clothes;

/**
 * 洋服の情報が入ったテーブルを操作するリポジトリ.
 * 
 * @author risa.okumura
 *
 */
@Repository
public class ClothesRepository {
	
	private static final RowMapper<Clothes> CLOTHES_ROW_MAPPER = (rs,i) ->{
		Clothes clothes = new Clothes();
		clothes.setId(rs.getInt("id"));
		clothes.setCategory(rs.getString("category"));
		clothes.setGenre(rs.getString("genre"));
		clothes.setGender(rs.getInt("gender"));
		clothes.setColor(rs.getString("color"));
		clothes.setPrice(rs.getInt("price"));
		clothes.setSize(rs.getString("size"));
		
		return clothes;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 性別と色をもとに複数検索を行う.
	 * 
	 * @param gender 性別
	 * @param color　色
	 * @return　検索結果
	 */
	public List<Clothes> findByGenderAndColor(int gender,String color){
		String sql = "SELECT id,category,genre,gender,color,price,size FROM shops WHERE gender=:gender AND color=:color ORDER BY price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		List<Clothes> clothesList = template.query(sql, param, CLOTHES_ROW_MAPPER);
		
		return clothesList;
	}
	
	
	

}
