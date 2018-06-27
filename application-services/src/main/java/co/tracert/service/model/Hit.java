
package co.tracert.service.model;

import java.io.Serializable;
import java.util.HashMap;
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
    "_index",
    "_type",
    "_id",
    "_score",
    "_source"
})
public class Hit implements Serializable
{

    @JsonProperty("_index")
    private String index;
    @JsonProperty("_type")
    private String type;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_score")
    private int score;
    @JsonProperty("_source")
    @Valid
    private Source source;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7097758078858482885L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hit() {
    }

    /**
     * 
     * @param id
     * @param index
     * @param source
     * @param score
     * @param type
     */
    public Hit(String index, String type, String id, int score, Source source) {
        super();
        this.index = index;
        this.type = type;
        this.id = id;
        this.score = score;
        this.source = source;
    }

    @JsonProperty("_index")
    public String getIndex() {
        return index;
    }

    @JsonProperty("_index")
    public void setIndex(String index) {
        this.index = index;
    }

    public Hit withIndex(String index) {
        this.index = index;
        return this;
    }

    @JsonProperty("_type")
    public String getType() {
        return type;
    }

    @JsonProperty("_type")
    public void setType(String type) {
        this.type = type;
    }

    public Hit withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    public Hit withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("_score")
    public int getScore() {
        return score;
    }

    @JsonProperty("_score")
    public void setScore(int score) {
        this.score = score;
    }

    public Hit withScore(int score) {
        this.score = score;
        return this;
    }

    @JsonProperty("_source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("_source")
    public void setSource(Source source) {
        this.source = source;
    }

    public Hit withSource(Source source) {
        this.source = source;
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

    public Hit withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
