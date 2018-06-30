
package co.tracert.service.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@timestamp",
    "type",
    "level",
    "host",
    "record_number",
    "thread_id",
    "source_name",
    "computer_name",
    "beat",
    "log_name",
    "provider_guid",
    "process_id",
    "opcode",
    "user",
    "event_data",
    "message",
    "event_id"
})
public class Source implements Serializable
{

    @JsonProperty("@timestamp")
    private String timestamp;
    @JsonProperty("type")
    private String type;
    @JsonProperty("level")
    private String level;
    @JsonProperty("host")
    @Valid
    private Host host;
    @JsonProperty("record_number")
    private String recordNumber;
    @JsonProperty("thread_id")
    private int threadId;
    @JsonProperty("source_name")
    private String sourceName;
    @JsonProperty("computer_name")
    private String computerName;
    @JsonProperty("beat")
    @Valid
    private Beat beat;
    @JsonProperty("log_name")
    private String logName;
    @JsonProperty("provider_guid")
    private String providerGuid;
    @JsonProperty("process_id")
    private int processId;
    @JsonProperty("opcode")
    private String opcode;
    @JsonProperty("user")
    @Valid
    private User user;
    @JsonProperty("event_data")
    @Valid
    private EventData eventData;
    @JsonProperty("message")
    private String message;
    @JsonProperty("event_id")
    private int eventId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5984294626238311532L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }

    /**
     * 
     * @param beat
     * @param host
     * @param recordNumber
     * @param threadId
     * @param processId
     * @param type
     * @param eventData
     * @param opcode
     * @param message
     * @param timestamp
     * @param level
     * @param eventId
     * @param providerGuid
     * @param sourceName
     * @param logName
     * @param computerName
     * @param user
     */
    public Source(String timestamp, String type, String level, Host host, String recordNumber, int threadId, String sourceName, String computerName, Beat beat, String logName, String providerGuid, int processId, String opcode, User user, EventData eventData, String message, int eventId) {
        super();
        this.timestamp = timestamp;
        this.type = type;
        this.level = level;
        this.host = host;
        this.recordNumber = recordNumber;
        this.threadId = threadId;
        this.sourceName = sourceName;
        this.computerName = computerName;
        this.beat = beat;
        this.logName = logName;
        this.providerGuid = providerGuid;
        this.processId = processId;
        this.opcode = opcode;
        this.user = user;
        this.eventData = eventData;
        this.message = message;
        this.eventId = eventId;
    }

    @JsonProperty("@timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("@timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Source withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Source withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    public Source withLevel(String level) {
        this.level = level;
        return this;
    }

    @JsonProperty("host")
    public Host getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(Host host) {
        this.host = host;
    }

    public Source withHost(Host host) {
        this.host = host;
        return this;
    }

    @JsonProperty("record_number")
    public String getRecordNumber() {
        return recordNumber;
    }

    @JsonProperty("record_number")
    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public Source withRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
        return this;
    }

    @JsonProperty("thread_id")
    public int getThreadId() {
        return threadId;
    }

    @JsonProperty("thread_id")
    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public Source withThreadId(int threadId) {
        this.threadId = threadId;
        return this;
    }

    @JsonProperty("source_name")
    public String getSourceName() {
        return sourceName;
    }

    @JsonProperty("source_name")
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Source withSourceName(String sourceName) {
        this.sourceName = sourceName;
        return this;
    }

    @JsonProperty("computer_name")
    public String getComputerName() {
        return computerName;
    }

    @JsonProperty("computer_name")
    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public Source withComputerName(String computerName) {
        this.computerName = computerName;
        return this;
    }

    @JsonProperty("beat")
    public Beat getBeat() {
        return beat;
    }

    @JsonProperty("beat")
    public void setBeat(Beat beat) {
        this.beat = beat;
    }

    public Source withBeat(Beat beat) {
        this.beat = beat;
        return this;
    }

    @JsonProperty("log_name")
    public String getLogName() {
        return logName;
    }

    @JsonProperty("log_name")
    public void setLogName(String logName) {
        this.logName = logName;
    }

    public Source withLogName(String logName) {
        this.logName = logName;
        return this;
    }

    @JsonProperty("provider_guid")
    public String getProviderGuid() {
        return providerGuid;
    }

    @JsonProperty("provider_guid")
    public void setProviderGuid(String providerGuid) {
        this.providerGuid = providerGuid;
    }

    public Source withProviderGuid(String providerGuid) {
        this.providerGuid = providerGuid;
        return this;
    }

    @JsonProperty("process_id")
    public int getProcessId() {
        return processId;
    }

    @JsonProperty("process_id")
    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public Source withProcessId(int processId) {
        this.processId = processId;
        return this;
    }

    @JsonProperty("opcode")
    public String getOpcode() {
        return opcode;
    }

    @JsonProperty("opcode")
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public Source withOpcode(String opcode) {
        this.opcode = opcode;
        return this;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    public Source withUser(User user) {
        this.user = user;
        return this;
    }

    @JsonProperty("event_data")
    public EventData getEventData() {
        return eventData;
    }

    @JsonProperty("event_data")
    public void setEventData(EventData eventData) {
        this.eventData = eventData;
    }

    public Source withEventData(EventData eventData) {
        this.eventData = eventData;
        return this;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public Source withMessage(String message) {
        this.message = message;
        return this;
    }

    @JsonProperty("event_id")
    public int getEventId() {
        return eventId;
    }

    @JsonProperty("event_id")
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Source withEventId(int eventId) {
        this.eventId = eventId;
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

    public Source withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
