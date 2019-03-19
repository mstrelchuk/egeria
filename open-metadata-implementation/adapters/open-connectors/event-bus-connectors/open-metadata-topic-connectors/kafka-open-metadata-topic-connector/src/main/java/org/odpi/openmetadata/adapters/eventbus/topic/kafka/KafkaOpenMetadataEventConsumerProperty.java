package org.odpi.openmetadata.adapters.eventbus.topic.kafka;

/**
 * Configurable properties for the KafkaOpenMetadataEventConsumer
 *
 */
public enum KafkaOpenMetadataEventConsumerProperty {
	/**
	 * Controls the maximum size of the unprocessed kafka event queue. When this
	 * size is reached, we will not poll for additional events unless a poll is
	 * required to prevent Kafka from treating the consumer as dead.
	 */
	MAX_QUEUE_SIZE("event_bus_max_queue_size", "100"),
	
	/**
	 * In order to ensure that Kafka does not treat our consumer as dead, we need to
	 * poll for messages within some configured maximum poll interval. To make sure
	 * this happens, when we are deciding whether or not to poll Kafka we need to
	 * see how close we are to the time when we will exceed that maximum poll
	 * interval. If we are close enough, then we force a poll rather. This parameter
	 * controls how close to the timeout we need to do be in order to force a poll.
	 * 
	 * The value provided as a number of milliseconds.
	 */
	CONSUMER_TIMEOUT_PREVENTION_SAFETY_WINDOW_MS("timeout_prevention_safety_window_ms", "30000"),
	
	/**
	 * This specifies the poll timeout (in ms) that we provide to kafka when we poll for
	 * messages.
	 */
	POLL_TIMEOUT("poll_timeout_ms", "1000"),
	
	/**
	 * The amount of time to sleep after we encounter a Kafka error, in second
	 */
	RECOVERY_SLEEP_TIME("recovery_sleep_time_sec", "10");

	private String propertyName;
	private String defaultValue;

	KafkaOpenMetadataEventConsumerProperty(String name, String defaultValue) {
		this.propertyName = name;
		this.defaultValue = defaultValue;

	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}


}