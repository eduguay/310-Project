package images;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestRepresentativeQuery {

@SerializedName("text")
@Expose
private String text;
@SerializedName("displayText")
@Expose
private String displayText;
@SerializedName("webSearchUrl")
@Expose
private String webSearchUrl;

public String getText() {
return text;
}

public void setText(String text) {
this.text = text;
}

public String getDisplayText() {
return displayText;
}

public void setDisplayText(String displayText) {
this.displayText = displayText;
}

public String getWebSearchUrl() {
return webSearchUrl;
}

public void setWebSearchUrl(String webSearchUrl) {
this.webSearchUrl = webSearchUrl;
}

}