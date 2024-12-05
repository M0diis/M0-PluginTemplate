package me.m0dii.additionalmetrics.collectors;

import dev.cubxity.plugins.metrics.api.metric.collector.Collector;
import dev.cubxity.plugins.metrics.api.metric.collector.CollectorCollection;
import me.m0dii.additionalmetrics.AdditionalMetricsPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class ServerBalanceCollectorCollection implements CollectorCollection {
    private final List<Collector> collectors = Collections.singletonList(new ServerBalanceCollector());

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
        AdditionalMetricsPlugin.getInstance().getEssentials().getBalanceTop().calculateBalanceTopMapAsync();
    }

    @Override
    public void dispose() {
        // Do nothing
    }
}