package images;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsightsMetadata {

@SerializedName("recipeSourcesCount")
@Expose
private Integer recipeSourcesCount;
@SerializedName("bestRepresentativeQuery")
@Expose
private BestRepresentativeQuery bestRepresentativeQuery;
@SerializedName("pagesIncludingCount")
@Expose
private Integer pagesIncludingCount;
@SerializedName("availableSizesCount")
@Expose
private Integer availableSizesCount;

public Integer getRecipeSourcesCount() {
return recipeSourcesCount;
}

public void setRecipeSourcesCount(Integer recipeSourcesCount) {
this.recipeSourcesCount = recipeSourcesCount;
}

public BestRepresentativeQuery getBestRepresentativeQuery() {
return bestRepresentativeQuery;
}

public void setBestRepresentativeQuery(BestRepresentativeQuery bestRepresentativeQuery) {
this.bestRepresentativeQuery = bestRepresentativeQuery;
}

public Integer getPagesIncludingCount() {
return pagesIncludingCount;
}

public void setPagesIncludingCount(Integer pagesIncludingCount) {
this.pagesIncludingCount = pagesIncludingCount;
}

public Integer getAvailableSizesCount() {
return availableSizesCount;
}

public void setAvailableSizesCount(Integer availableSizesCount) {
this.availableSizesCount = availableSizesCount;
}

}