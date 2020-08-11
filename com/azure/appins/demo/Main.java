package com.azure.appins.demo;

import com.azure.appins.ApplicationInsightsClient;
import com.azure.appins.ApplicationInsightsClientBuilder;
import com.azure.appins.models.Base;
import com.azure.appins.models.ContextTagKeys;
import com.azure.appins.models.EventData;
import com.azure.appins.models.RemoteDependencyData;
import com.azure.appins.models.RequestData;
import com.azure.appins.models.TelemetryEnvelope;
import com.azure.appins.models.TrackResponse;
import com.azure.core.http.rest.Response;
import com.azure.core.util.serializer.JacksonAdapter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  private static final String INSTRUMENTATION_KEY = "b4f83947-968d-4e2f-82ad-804be07697ae";

  public static void main(String[] args) {
    // Customize serializer to use NDJSON
    final SimpleModule ndjsonModule = new SimpleModule("Ndjson List Serializer");
    ndjsonModule.addSerializer(new NdJsonSerializer());

    final SimpleModule durationModule = new SimpleModule("Duration Serializer");
    durationModule.addSerializer(new DurationSerializer());

    JacksonAdapter jacksonAdapter = new JacksonAdapter();
    jacksonAdapter.serializer().registerModule(ndjsonModule);
    jacksonAdapter.serializer().registerModule(durationModule);

    // Create client
    ApplicationInsightsClient apiSpecClient = new ApplicationInsightsClientBuilder()
        .serializerAdapter(jacksonAdapter)
        .buildClient();

    // Create request list
    List<TelemetryEnvelope> requestList = getTelemetryRequest();

    // Send to service
    Response<TrackResponse> response = apiSpecClient.trackWithResponseAsync(requestList).block();

    // Read response
    System.out.println("Status code " + response.getStatusCode());
    System.out.println("Items received " + response.getValue().getItemsReceived());
    System.out.println("Items accepted " + response.getValue().getItemsAccepted());
    System.out.println("Errors " + response.getValue().getErrors().size());
    response.getValue().getErrors()
        .forEach(
            error -> System.out.println(error.getStatusCode() + " " + error.getMessage() + " " + error.getIndex()));
  }












  // use the generated models classes to populate the telemetry data
  private static List<TelemetryEnvelope> getTelemetryRequest() {
    List<TelemetryEnvelope> requestList = new ArrayList<>();

    TelemetryEnvelope eventData = getEventData();
    requestList.add(eventData);

    TelemetryEnvelope remoteDependency = getRemoteDependencyData();
    requestList.add(remoteDependency);

    TelemetryEnvelope request1 = getRequestData("75706a2ac9456288", "200");
    requestList.add(request1);

    TelemetryEnvelope request2 = getRequestData("f6610a3f5c00d010", "404");
    requestList.add(request2);
    return requestList;
  }

  private static TelemetryEnvelope getRequestData(String id, String responseCode) {
    TelemetryEnvelope telemetryEnvelope = getTelemetryEnvelope(
        "Microsoft.ApplicationInsights.b4f83947968d4e2f82ad804be07697ae.Request");

    Base base = new Base();
    base.setBaseType("RequestData");

    RequestData requestData = new RequestData()
        .setVer(2)
        .setId(id)
        .setDuration(Duration.ofMillis(265))
        .setResponseCode(responseCode)
        .setSuccess(true)
        .setUrl("http://localhost:8080/http-dependency/success")
        .setName("GET /http-dependency/success");

    base.setBaseData(requestData);
    telemetryEnvelope.setData(base);

    return telemetryEnvelope;
  }

  private static TelemetryEnvelope getRemoteDependencyData() {
    TelemetryEnvelope telemetryEnvelope = getTelemetryEnvelope(
        "Microsoft.ApplicationInsights.b4f83947968d4e2f82ad804be07697ae.RemoteDependency");

    Base base = new Base();
    base.setBaseType("RemoteDependencyData");
    RemoteDependencyData remoteDependencyData = new RemoteDependencyData()
        .setVer(2)
        .setName("GET /200")
        .setId("48ddeeeb10c0bf4c")
        .setResultCode("200")
        .setDuration(Duration.ofMillis(259))
        .setSuccess(true)
        .setType("Http (tracked component)")
        .setTarget("httpstatuses.com");

    base.setBaseData(remoteDependencyData);
    telemetryEnvelope.setData(base);

    return telemetryEnvelope;
  }

  private static TelemetryEnvelope getEventData() {
    TelemetryEnvelope telemetryEnvelope = getTelemetryEnvelope(
        "Microsoft.ApplicationInsights.b4f83947968d4e2f82ad804be07697ae.Event");

    Base base = new Base();
    base.setBaseType("EventData");
    Map<String, String> properties = new HashMap<>();
    properties.put("one", "-1-");
    properties.put("two", "-2-");

    EventData eventData = new EventData()
        .setName("myName")
        .setProperties(properties);

    base.setBaseData(eventData);
    telemetryEnvelope.setData(base);
    return telemetryEnvelope;
  }

  private static TelemetryEnvelope getTelemetryEnvelope(String name) {
    Map<String, String> tags = new HashMap<>();
    tags.put(ContextTagKeys.AI_INTERNAL_SDK_VERSION.toString(), "java:3.0.0-PREVIEW.5");
    tags.put(ContextTagKeys.AI_CLOUD_ROLE_INSTANCE.toString(), "MININT-PLOJ2RD");
    tags.put(ContextTagKeys.AI_INTERNAL_NODE_NAME.toString(), "MININT-PLOJ2RD");
    tags.put(ContextTagKeys.AI_OPERATION_ID.toString(), "f364119ed1ff3bcda0d4ee0896cf785f");
    return new TelemetryEnvelope()
        .setVer(1)
        .setName(name)
        .setSampleRate(100.0f)
        .setIKey(INSTRUMENTATION_KEY)
        .setTags(tags)
        .setTime(OffsetDateTime.now());
  }

}
