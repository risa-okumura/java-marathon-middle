package jp.co.rakus.domain;


/**
 * プロ野球チームの情報を表すドメイン.
 * 
 * @author risa.okumura
 *
 */
public class BaseballTeam {
	
	/**　id */
	private Integer id;
	/**　リーグ名 */
	private String leagueName;
	/**　チーム名 */
	private String teamName;
	/**　本拠地名 */
	private String headquarters;
	/**　発足年月日 */
	private String inauguration;
	/**　チームの歴史 */
	private String history;
	
	@Override
	public String toString() {
		return "BaseballTeam [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquarters="
				+ headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}

}
