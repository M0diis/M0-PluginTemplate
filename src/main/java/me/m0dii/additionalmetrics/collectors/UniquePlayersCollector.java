package me.m0dii.additionalmetrics.collectors;

import me.m0dii.additionalmetrics.AdditionalMetricsPlugin;
import org.jetbrains.annotations.NotNull;

import com.earth2me.essentials.Essentials;
import dev.cubxity.plugins.metrics.api.metric.collector.Collector;
import dev.cubxity.plugins.metrics.api.metric.data.GaugeMetric;
import dev.cubxity.plugins.metrics.api.metric.data.Metric;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UniquePlayersCollector implements Collector {
    private final Map<String, String> EMPTY_LABELS = new HashMap<>();

    private final Essentials ess = AdditionalMetricsPlugin.getInstance().getEssentials();

    @NotNull
    @Override
    public List<Metric> collect() {
        GaugeMetric metric = new GaugeMetric("minecraft_unique_players", EMPTY_LABELS, ess.getUserMap().getUniqueUsers());

        return Collections.singletonList(metric);
    }
}
