package org.example.sports.db;

import org.example.shared.io.db.Repository;
import org.example.sports.model.Statistic;

import java.util.Optional;

public class StatisticRepository implements Repository<Statistic> {
    @Override
    public Statistic save(Statistic statistic) {
        return null;
    }

    @Override
    public Optional<Statistic> findById(Long id) {
        return Optional.empty();
    }
}
