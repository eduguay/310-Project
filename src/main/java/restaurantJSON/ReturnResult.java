package restaurantJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Name, address, minutes, price, id, phone, website, addressURL, catagory
public class ReturnResult {
	@SerializedName("address")
	@Expose
	private String formattedAddress;
	@SerializedName("phone")
	@Expose
	private String formattedPhoneNumber;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("price")
	@Expose
	private Integer priceLevel;
	@SerializedName("website")
	@Expose
	private String website;
	@SerializedName("min")
	@Expose
	private String distance;
	
	public void copyResult(Result result) {
		this.formattedAddress = result.getFormattedAddress();
		this.formattedPhoneNumber = result.getFormattedPhoneNumber();
		this.name = result.getName();
		this.priceLevel = result.getPriceLevel();
		this.website = result.getWebsite();
	}

	public String getFormattedAddress() {
	return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
	this.formattedAddress = formattedAddress;
	}

	public String getFormattedPhoneNumber() {
	return formattedPhoneNumber;
	}

	public void setFormattedPhoneNumber(String formattedPhoneNumber) {
	this.formattedPhoneNumber = formattedPhoneNumber;
	}

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public Integer getPriceLevel() {
	return priceLevel;
	}

	public void setPriceLevel(Integer priceLevel) {
	this.priceLevel = priceLevel;
	}

	public String getWebsite() {
	return website;
	}

	public void setWebsite(String website) {
	this.website = website;
	}
	
	
	public String getDistance() {
	return distance;
	}

	public void setDistance(String distance) {
	this.distance = distance;
	}
	
}
