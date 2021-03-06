// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.appins.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The DataPoint model. */
@Fluent
public final class DataPoint {
    /*
     * Namespace of the metric.
     */
    @JsonProperty(value = "ns")
    private String ns;

    /*
     * Name of the metric.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /*
     * Metric type. Single measurement or the aggregated value. TODO: add
     * default
     */
    @JsonProperty(value = "kind")
    private DataPointType kind;

    /*
     * Single value for measurement. Sum of individual measurements for the
     * aggregation.
     */
    @JsonProperty(value = "value", required = true)
    private double value;

    /*
     * Metric weight of the aggregated metric. Should not be set for a
     * measurement.
     */
    @JsonProperty(value = "count")
    private Integer count;

    /*
     * Minimum value of the aggregated metric. Should not be set for a
     * measurement.
     */
    @JsonProperty(value = "min")
    private Double min;

    /*
     * Maximum value of the aggregated metric. Should not be set for a
     * measurement.
     */
    @JsonProperty(value = "max")
    private Double max;

    /*
     * Standard deviation of the aggregated metric. Should not be set for a
     * measurement.
     */
    @JsonProperty(value = "stdDev")
    private Double stdDev;

    /**
     * Get the ns property: Namespace of the metric.
     *
     * @return the ns value.
     */
    public String getNs() {
        return this.ns;
    }

    /**
     * Set the ns property: Namespace of the metric.
     *
     * @param ns the ns value to set.
     * @return the DataPoint object itself.
     */
    public DataPoint setNs(String ns) {
        this.ns = ns;
        return this;
    }

    /**
     * Get the name property: Name of the metric.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: Name of the metric.
     *
     * @param name the name value to set.
     * @return the DataPoint object itself.
     */
    public DataPoint setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the kind property: Metric type. Single measurement or the aggregated value. TODO: add default.
     *
     * @return the kind value.
     */
    public DataPointType getKind() {
        return this.kind;
    }

    /**
     * Set the kind property: Metric type. Single measurement or the aggregated value. TODO: add default.
     *
     * @param kind the kind value to set.
     * @return the DataPoint object itself.
     */
    public DataPoint setKind(DataPointType kind) {
        this.kind = kind;
        return this;
    }

    /**
     * Get the value property: Single value for measurement. Sum of individual measurements for the aggregation.
     *
     * @return the value value.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Set the value property: Single value for measurement. Sum of individual measurements for the aggregation.
     *
     * @param value the value value to set.
     * @return the DataPoint object itself.
     */
    public DataPoint setValue(double value) {
        this.value = value;
        return this;
    }

    /**
     * Get the count property: Metric weight of the aggregated metric. Should not be set for a measurement.
     *
     * @return the count value.
     */
    public Integer getCount() {
        return this.count;
    }

    /**
     * Set the count property: Metric weight of the aggregated metric. Should not be set for a measurement.
     *
     * @param count the count value to set.
     * @return the DataPoint object itself.
     */
    public DataPoint setCount(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * Get the min property: Minimum value of the aggregated metric. Should not be set for a measurement.
     *
     * @return the min value.
     */
    public Double getMin() {
        return this.min;
    }

    /**
     * Set the min property: Minimum value of the aggregated metric. Should not be set for a measurement.
     *
     * @param min the min value to set.
     * @return the DataPoint object itself.
     */
    public DataPoint setMin(Double min) {
        this.min = min;
        return this;
    }

    /**
     * Get the max property: Maximum value of the aggregated metric. Should not be set for a measurement.
     *
     * @return the max value.
     */
    public Double getMax() {
        return this.max;
    }

    /**
     * Set the max property: Maximum value of the aggregated metric. Should not be set for a measurement.
     *
     * @param max the max value to set.
     * @return the DataPoint object itself.
     */
    public DataPoint setMax(Double max) {
        this.max = max;
        return this;
    }

    /**
     * Get the stdDev property: Standard deviation of the aggregated metric. Should not be set for a measurement.
     *
     * @return the stdDev value.
     */
    public Double getStdDev() {
        return this.stdDev;
    }

    /**
     * Set the stdDev property: Standard deviation of the aggregated metric. Should not be set for a measurement.
     *
     * @param stdDev the stdDev value to set.
     * @return the DataPoint object itself.
     */
    public DataPoint setStdDev(Double stdDev) {
        this.stdDev = stdDev;
        return this;
    }
}
