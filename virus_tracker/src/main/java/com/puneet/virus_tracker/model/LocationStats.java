package com.puneet.virus_tracker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LocationStats {

	private String state;

	private String country;

	private int latestCount;

	private int diffFromPrevDay;

}
