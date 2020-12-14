package vo;

public class Geo {
	private String name;
	private double lat;
	private double lng;
	private String url;
	private int branchnum;
	public Geo() {
	}
	public Geo(String name, double lat, double lng, String url, int branchnum) {
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.url = url;
		this.branchnum = branchnum;
	}
	public String getName() {
		return name;
	}
	public double getLat() {
		return lat;
	}
	public double getLng() {
		return lng;
	}
	public String getUrl() {
		return url;
	}
	public int getBranchnum() {
		return branchnum;
	}
	@Override
	public String toString() {
		return "Geo [name=" + name + ", lat=" + lat + ", lng=" + lng + ", url=" + url + ", branchnum=" + branchnum
				+ "]";
	}
	
}
