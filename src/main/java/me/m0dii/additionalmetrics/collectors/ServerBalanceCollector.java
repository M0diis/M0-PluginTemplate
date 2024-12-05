package me.m0dii.additionalmetrics.collectors;

import com.earth2me.essentials.Essentials;
import dev.cubxity.plugins.metrics.api.metric.collector.Collector;
import dev.cubxity.plugins.metrics.api.metric.data.GaugeMetric;
import dev.cubxity.plugins.metrics.api.metric.data.Metric;
import me.m0dii.additionalmetrics.AdditionalMetricsPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ServerBalanceCollector implements Collector {
    private final Map<String, String> EMPTY_LABELS = new HashMap<>();
    private final Essentials ess = AdditionalMetricsPlugin.getInstance().getEssentials();

    @NotNull
    @Override
    public List<Metric> collect() {
        GaugeMetric metric = new GaugeMetric("minecraft_server_balance", EMPTY_LABELS,
                ess.getBalanceTop().getBalanceTopTotal());

        return Collections.singletonList(metric);
    }
}