
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
@JsonPropertyOrder({ "took", "timed_out", "num_reduce_phases", "_shards", "hits" })
public class WindowEvent implements Serializable {

	@JsonProperty("took")
	private int took;
	@JsonProperty("timed_out")
	private boolean timedOut;
	@JsonProperty("num_reduce_phases")
	private int numReducePhases;
	@JsonProperty("_shards")
	@Valid
	private Shards shards;
	@JsonProperty("hits")
	@Valid
	private Hits hits;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -2602156157549629359L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public WindowEvent() {
	}

	/**
	 * 
	 * @param hits
	 * @param shards
	 * @param timedOut
	 * @param took
	 * @param numReducePhases
	 */
	public WindowEvent(int took, boolean timedOut, int numReducePhases, Shards shards, Hits hits) {
		super();
		this.took = took;
		this.timedOut = timedOut;
		this.numReducePhases = numReducePhases;
		this.shards = shards;
		this.hits = hits;
	}

	@JsonProperty("took")
	public int getTook() {
		return took;
	}

	@JsonProperty("took")
	public void setTook(int took) {
		this.took = took;
	}

	public WindowEvent withTook(int took) {
		this.took = took;
		return this;
	}

	@JsonProperty("timed_out")
	public boolean isTimedOut() {
		return timedOut;
	}

	@JsonProperty("timed_out")
	public void setTimedOut(boolean timedOut) {
		this.timedOut = timedOut;
	}

	public WindowEvent withTimedOut(boolean timedOut) {
		this.timedOut = timedOut;
		return this;
	}

	@JsonProperty("num_reduce_phases")
	public int getNumReducePhases() {
		return numReducePhases;
	}

	@JsonProperty("num_reduce_phases")
	public void setNumReducePhases(int numReducePhases) {
		this.numReducePhases = numReducePhases;
	}

	public WindowEvent withNumReducePhases(int numReducePhases) {
		this.numReducePhases = numReducePhases;
		return this;
	}

	@JsonProperty("_shards")
	public Shards getShards() {
		return shards;
	}

	@JsonProperty("_shards")
	public void setShards(Shards shards) {
		this.shards = shards;
	}

	public WindowEvent withShards(Shards shards) {
		this.shards = shards;
		return this;
	}

	@JsonProperty("hits")
	public Hits getHits() {
		return hits;
	}

	@JsonProperty("hits")
	public void setHits(Hits hits) {
		this.hits = hits;
	}

	public WindowEvent withHits(Hits hits) {
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

	public WindowEvent withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}
