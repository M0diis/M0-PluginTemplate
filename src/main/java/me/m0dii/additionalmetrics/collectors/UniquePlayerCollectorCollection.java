package me.m0dii.additionalmetrics.collectors;

import dev.cubxity.plugins.metrics.api.metric.collector.Collector;
import dev.cubxity.plugins.metrics.api.metric.collector.CollectorCollection;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class UniquePlayerCollectorCollection implements CollectorCollection {
    private final List<Collector> collectors = Collections.singletonList(new UniquePlayersCollector());

    @NotNull
    @Override
    public List<Collector> getCollectors() {
        return this.collectors;
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public void initialize() {
        // Do nothing
    }

    @Override
    public void dispose() {
        // Do nothing
    }
}