package com.maveric.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.maveric.model.ProbeRequest;
import com.maveric.model.ProbeResponse;

@Service
public class ProbeService {
	
	private enum Direction {
        N, E, S, W;

        public Direction turnLeft() {
            return values()[(ordinal() + 3) % 4];
        }

        public Direction turnRight() {
            return values()[(ordinal() + 1) % 4];
        }
    }

    public ProbeResponse executeCommands(ProbeRequest request) {
        int x = request.getStartPosition().get(0);
        int y = request.getStartPosition().get(1);
        Direction direction = Direction.valueOf(request.getStartDirection());

        int maxX = request.getGridSize().get(0);
        int maxY = request.getGridSize().get(1);
        Set<String> obstacles = new HashSet<>();
        for (List<Integer> obs : request.getObstacles()) {
            obstacles.add(obs.get(0) + "," + obs.get(1));
        }

        List<List<Integer>> visited = new ArrayList<>();
        visited.add(Arrays.asList(x, y));

        for (char command : request.getCommands().toUpperCase().toCharArray()) {
            switch (command) {
                case 'L':
                    direction = direction.turnLeft();
                    break;
                case 'R':
                    direction = direction.turnRight();
                    break;
                case 'F':
                case 'B':
                    int dx = 0, dy = 0;
                    switch (direction) {
                        case N: dy = 1; break;
                        case E: dx = 1; break;
                        case S: dy = -1; break;
                        case W: dx = -1; break;
                    }
                    if (command == 'B') {
                        dx *= -1;
                        dy *= -1;
                    }
                    int newX = x + dx;
                    int newY = y + dy;
                    if (newX >= 0 && newY >= 0 && newX < maxX && newY < maxY && !obstacles.contains(newX + "," + newY)) {
                        x = newX;
                        y = newY;
                        visited.add(Arrays.asList(x, y));
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + command);
            }
}
        return new ProbeResponse(Arrays.asList(x, y), direction.name(), visited);    
    }}
