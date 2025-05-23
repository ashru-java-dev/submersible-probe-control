package com.maveric.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProbeRequest {
	@Size(min = 2, max = 2)
	private List<Integer> gridSize;
	private List<List<Integer>> obstacles = new ArrayList<>();
	@Size(min = 2, max = 2)
	private List<Integer> startPosition;
	private String startDirection;
	private String commands;

	public List<Integer> getGridSize() {
		return gridSize;
	}

	public void setGridSize(List<Integer> gridSize) {
		this.gridSize = gridSize;
	}

	public List<List<Integer>> getObstacles() {
		return obstacles;
	}

	public void setObstacles(List<List<Integer>> obstacles) {
		this.obstacles = obstacles;
	}

	public List<Integer> getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(List<Integer> startPosition) {
		this.startPosition = startPosition;
	}

	public String getStartDirection() {
		return startDirection;
	}

	public void setStartDirection(String startDirection) {
		this.startDirection = startDirection;
	}

	public String getCommands() {
		return commands;
	}

	public void setCommands(String commands) {
		this.commands = commands;
	}

}
