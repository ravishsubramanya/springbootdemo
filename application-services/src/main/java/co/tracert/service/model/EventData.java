
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
    "ServiceVersion",
    "BootMode",
    "StartTime",
    "MajorVersion",
    "MinorVersion",
    "BuildVersion",
    "QfeVersion"
})
public class EventData implements Serializable
{

    @JsonProperty("ServiceVersion")
    private String serviceVersion;
    @JsonProperty("BootMode")
    private String bootMode;
    @JsonProperty("StartTime")
    private String startTime;
    @JsonProperty("MajorVersion")
    private String majorVersion;
    @JsonProperty("MinorVersion")
    private String minorVersion;
    @JsonProperty("BuildVersion")
    private String buildVersion;
    @JsonProperty("QfeVersion")
    private String qfeVersion;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6088230388074245211L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EventData() {
    }

    /**
     * 
     * @param qfeVersion
     * @param startTime
     * @param bootMode
     * @param majorVersion
     * @param serviceVersion
     * @param minorVersion
     * @param buildVersion
     */
    public EventData(String serviceVersion, String bootMode, String startTime, String majorVersion, String minorVersion, String buildVersion, String qfeVersion) {
        super();
        this.serviceVersion = serviceVersion;
        this.bootMode = bootMode;
        this.startTime = startTime;
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.buildVersion = buildVersion;
        this.qfeVersion = qfeVersion;
    }

    @JsonProperty("ServiceVersion")
    public String getServiceVersion() {
        return serviceVersion;
    }

    @JsonProperty("ServiceVersion")
    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public EventData withServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
        return this;
    }

    @JsonProperty("BootMode")
    public String getBootMode() {
        return bootMode;
    }

    @JsonProperty("BootMode")
    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    public EventData withBootMode(String bootMode) {
        this.bootMode = bootMode;
        return this;
    }

    @JsonProperty("StartTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("StartTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public EventData withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    @JsonProperty("MajorVersion")
    public String getMajorVersion() {
        return majorVersion;
    }

    @JsonProperty("MajorVersion")
    public void setMajorVersion(String majorVersion) {
        this.majorVersion = majorVersion;
    }

    public EventData withMajorVersion(String majorVersion) {
        this.majorVersion = majorVersion;
        return this;
    }

    @JsonProperty("MinorVersion")
    public String getMinorVersion() {
        return minorVersion;
    }

    @JsonProperty("MinorVersion")
    public void setMinorVersion(String minorVersion) {
        this.minorVersion = minorVersion;
    }

    public EventData withMinorVersion(String minorVersion) {
        this.minorVersion = minorVersion;
        return this;
    }

    @JsonProperty("BuildVersion")
    public String getBuildVersion() {
        return buildVersion;
    }

    @JsonProperty("BuildVersion")
    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

    public EventData withBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
        return this;
    }

    @JsonProperty("QfeVersion")
    public String getQfeVersion() {
        return qfeVersion;
    }

    @JsonProperty("QfeVersion")
    public void setQfeVersion(String qfeVersion) {
        this.qfeVersion = qfeVersion;
    }

    public EventData withQfeVersion(String qfeVersion) {
        this.qfeVersion = qfeVersion;
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

    public EventData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
