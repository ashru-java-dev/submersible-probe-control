package com.maveric.model;

import java.util.List;

import lombok.Data;

@Data
public class ProbeResponse {
	private List<Integer> finalPosition;
	private String finalDirection;
	private List<List<Integer>> visited;

	public ProbeResponse(List<Integer> finalPosition, String finalDirection, List<List<Integer>> visited) {
		this.finalPosition = finalPosition;
		this.finalDirection = finalDirection;
		this.visited = visited;
	}

	public List<Integer> getFinalPosition() {
		return finalPosition;
	}

	public String getFinalDirection() {
		return finalDirection;
	}

	public List<List<Integer>> getVisited() {
		return visited;
	}
}
