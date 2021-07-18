package com.cat.toyrobot.service;

import com.cat.toyrobot.model.Direction;
import org.springframework.stereotype.Service;

@Service
public class TurnLeftService extends AbstractTurnService {
    @Override
    protected int getNextDirectionOrdinal(int currentDirectionOrdinal) {
        int maxDirectionOrdinal = Direction.values().length - 1;
        return currentDirectionOrdinal == maxDirectionOrdinal ? 0 : currentDirectionOrdinal + 1;
    }
}
