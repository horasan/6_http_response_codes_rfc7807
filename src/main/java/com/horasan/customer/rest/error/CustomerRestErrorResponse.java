package com.horasan.customer.rest.error;

import java.net.URI;
import java.time.LocalDateTime;

import org.zalando.problem.StatusType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRestErrorResponse {
	private LocalDateTime timeStamp;
	private URI type;
	private String title;
	private String detail;
	private StatusType statusType;

}
