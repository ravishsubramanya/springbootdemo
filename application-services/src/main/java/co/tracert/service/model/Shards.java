
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
    "total",
    "successful",
    "skipped",
    "failed"
})
public class Shards implements Serializable
{

    @JsonProperty("total")
    private int total;
    @JsonProperty("successful")
    private int successful;
    @JsonProperty("skipped")
    private int skipped;
    @JsonProperty("failed")
    private int failed;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 429768909100785982L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Shards() {
    }

    /**
     * 
     * @param total
     * @param skipped
     * @param failed
     * @param successful
     */
    public Shards(int total, int successful, int skipped, int failed) {
        super();
        this.total = total;
        this.successful = successful;
        this.skipped = skipped;
        this.failed = failed;
    }

    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(int total) {
        this.total = total;
    }

    public Shards withTotal(int total) {
        this.total = total;
        return this;
    }

    @JsonProperty("successful")
    public int getSuccessful() {
        return successful;
    }

    @JsonProperty("successful")
    public void setSuccessful(int successful) {
        this.successful = successful;
    }

    public Shards withSuccessful(int successful) {
        this.successful = successful;
        return this;
    }

    @JsonProperty("skipped")
    public int getSkipped() {
        return skipped;
    }

    @JsonProperty("skipped")
    public void setSkipped(int skipped) {
        this.skipped = skipped;
    }

    public Shards withSkipped(int skipped) {
        this.skipped = skipped;
        return this;
    }

    @JsonProperty("failed")
    public int getFailed() {
        return failed;
    }

    @JsonProperty("failed")
    public void setFailed(int failed) {
        this.failed = failed;
    }

    public Shards withFailed(int failed) {
        this.failed = failed;
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

    public Shards withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
