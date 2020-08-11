// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.appins.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.util.Map;

/** The PageViewData model. */
@Fluent
public final class PageViewData extends Domain {
    /*
     * Schema version
     */
    @JsonProperty(value = "ver", required = true)
    private int ver;

    /*
     * Identifier of a page view instance. Used for correlation between page
     * view and other telemetry items.
     */
    @JsonProperty(value = "id", required = true)
    private String id;

    /*
     * Event name. Keep it low cardinality to allow proper grouping and useful
     * metrics.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /*
     * Request URL with all query string parameters
     */
    @JsonProperty(value = "url")
    private String url;

    /*
     * Request duration in format: DD.HH:MM:SS.MMMMMM. For a page view
     * (PageViewData), this is the duration. For a page view with performance
     * information (PageViewPerfData), this is the page load time. Must be less
     * than 1000 days.
     */
    @JsonProperty(value = "duration")
    private Duration duration;

    /*
     * Fully qualified page URI or URL of the referring page; if unknown, leave
     * blank
     */
    @JsonProperty(value = "referredUri")
    private String referredUri;

    /*
     * Collection of custom properties. TODO: max key length validate
     */
    @JsonProperty(value = "properties")
    private Map<String, String> properties;

    /*
     * Collection of custom measurements. TODO: max key length validate
     */
    @JsonProperty(value = "measurements")
    private Map<String, Double> measurements;

    /**
     * Get the ver property: Schema version.
     *
     * @return the ver value.
     */
    public int getVer() {
        return this.ver;
    }

    /**
     * Set the ver property: Schema version.
     *
     * @param ver the ver value to set.
     * @return the PageViewData object itself.
     */
    public PageViewData setVer(int ver) {
        this.ver = ver;
        return this;
    }

    /**
     * Get the id property: Identifier of a page view instance. Used for correlation between page view and other
     * telemetry items.
     *
     * @return the id value.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the id property: Identifier of a page view instance. Used for correlation between page view and other
     * telemetry items.
     *
     * @param id the id value to set.
     * @return the PageViewData object itself.
     */
    public PageViewData setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the name property: Event name. Keep it low cardinality to allow proper grouping and useful metrics.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: Event name. Keep it low cardinality to allow proper grouping and useful metrics.
     *
     * @param name the name value to set.
     * @return the PageViewData object itself.
     */
    public PageViewData setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the url property: Request URL with all query string parameters.
     *
     * @return the url value.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Set the url property: Request URL with all query string parameters.
     *
     * @param url the url value to set.
     * @return the PageViewData object itself.
     */
    public PageViewData setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get the duration property: Request duration in format: DD.HH:MM:SS.MMMMMM. For a page view (PageViewData), this
     * is the duration. For a page view with performance information (PageViewPerfData), this is the page load time.
     * Must be less than 1000 days.
     *
     * @return the duration value.
     */
    public Duration getDuration() {
        return this.duration;
    }

    /**
     * Set the duration property: Request duration in format: DD.HH:MM:SS.MMMMMM. For a page view (PageViewData), this
     * is the duration. For a page view with performance information (PageViewPerfData), this is the page load time.
     * Must be less than 1000 days.
     *
     * @param duration the duration value to set.
     * @return the PageViewData object itself.
     */
    public PageViewData setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Get the referredUri property: Fully qualified page URI or URL of the referring page; if unknown, leave blank.
     *
     * @return the referredUri value.
     */
    public String getReferredUri() {
        return this.referredUri;
    }

    /**
     * Set the referredUri property: Fully qualified page URI or URL of the referring page; if unknown, leave blank.
     *
     * @param referredUri the referredUri value to set.
     * @return the PageViewData object itself.
     */
    public PageViewData setReferredUri(String referredUri) {
        this.referredUri = referredUri;
        return this;
    }

    /**
     * Get the properties property: Collection of custom properties. TODO: max key length validate.
     *
     * @return the properties value.
     */
    public Map<String, String> getProperties() {
        return this.properties;
    }

    /**
     * Set the properties property: Collection of custom properties. TODO: max key length validate.
     *
     * @param properties the properties value to set.
     * @return the PageViewData object itself.
     */
    public PageViewData setProperties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the measurements property: Collection of custom measurements. TODO: max key length validate.
     *
     * @return the measurements value.
     */
    public Map<String, Double> getMeasurements() {
        return this.measurements;
    }

    /**
     * Set the measurements property: Collection of custom measurements. TODO: max key length validate.
     *
     * @param measurements the measurements value to set.
     * @return the PageViewData object itself.
     */
    public PageViewData setMeasurements(Map<String, Double> measurements) {
        this.measurements = measurements;
        return this;
    }
}