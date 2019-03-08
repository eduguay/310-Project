package restaurantJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("formatted_address")
@Expose
private String formattedAddress;
@SerializedName("formatted_phone_number")
@Expose
private String formattedPhoneNumber;
@SerializedName("geometry")
@Expose
private Geometry geometry;
@SerializedName("name")
@Expose
private String name;
@SerializedName("price_level")
@Expose
private Integer priceLevel;
@SerializedName("website")
@Expose
private String website;

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

public Geometry getGeometry() {
return geometry;
}

public void setGeometry(Geometry geometry) {
this.geometry = geometry;
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

}