
package co.tracert.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "max_score",
    "hits"
})
public class Hits implements Serializable
{

    @JsonProperty("total")
    private int total;
    @JsonProperty("max_score")
    private int maxScore;
    @JsonProperty("hits")
    @Valid
    private List<Hit> hits = new ArrayList<Hit>();
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8370155084022325708L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hits() {
    }

    /**
     * 
     * @param total
     * @param hits
     * @param maxScore
     */
    public Hits(int total, int maxScore, List<Hit> hits) {
        super();
        this.total = total;
        this.maxScore = maxScore;
        this.hits = hits;
    }

    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(int total) {
        this.total = total;
    }

    public Hits withTotal(int total) {
        this.total = total;
        return this;
    }

    @JsonProperty("max_score")
    public int getMaxScore() {
        return maxScore;
    }

    @JsonProperty("max_score")
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public Hits withMaxScore(int maxScore) {
        this.maxScore = maxScore;
        return this;
    }

    @JsonProperty("hits")
    public List<Hit> getHits() {
        return hits;
    }

    @JsonProperty("hits")
    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public Hits withHits(List<Hit> hits) {
        this.hits = hits;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Hits withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
