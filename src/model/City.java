package model;

public class City {
	private Long cityid;
	private String cityName;

	public Long getCityId() {
		return cityid;
	}

	public void setCityId(Long cityid) {
		this.cityid = cityid;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public City(Long cityid, String cityName) {
		super();
		this.cityid = cityid;
		this.cityName = cityName;
	}

}