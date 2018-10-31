package jp.co.rakus.repository; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.BaseballTeam;

/**
 * プロ野球チーム情報の入ったテーブルの操作を行う.
 * 
 * @author risa.okumura
 *
 */
@Repository
public class BaseBallRepository {
	
	private static final RowMapper<BaseballTeam> BASEBALL_ROW_MAPPER = (rs,i) ->{
		BaseballTeam baseballTeam = new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setLeagueName(rs.getString("league_name"));
		baseballTeam.setTeamName(rs.getString("team_name"));
		baseballTeam.setHeadquarters(rs.getString("headquarters"));
		baseballTeam.setInauguration(rs.getString("inauguration"));
		baseballTeam.setHistory(rs.getString("history"));
		return baseballTeam;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	/**
	 * 一件検索を行う.
	 * 
	 * @param id
	 * @return プロ野球チーム情報
	 */
	public BaseballTeam load(Integer id) {
		String sql = "SELECT id,league_name, team_name, headquarters, inauguration, history FROM baseball_teams WHERE id=:id;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		BaseballTeam baseballTeam = template.queryForObject(sql, param, BASEBALL_ROW_MAPPER);
		
		return baseballTeam;
	}
	
	/**
	 * 全件検索を行う.
	 * 
	 * @return 全プロ野球チーム情報
	 */
	public List<BaseballTeam> findAll (){
		String sql = "SELECT id,league_name, team_name, headquarters, inauguration, history FROM baseball_teams ORDER BY inauguration;";
		List<BaseballTeam> baseballTeamList = template.query(sql,BASEBALL_ROW_MAPPER);		
		return baseballTeamList;
	}
	

}
