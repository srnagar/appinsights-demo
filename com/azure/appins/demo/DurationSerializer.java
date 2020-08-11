package com.azure.appins.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.Duration;

public class DurationSerializer extends StdSerializer<Duration> {

  /** Classes serial ID. */
  private static final long serialVersionUID = 1L;

  public DurationSerializer() {
    super(Duration.class, false);
  }

  @Override
  public void serialize( final Duration duration, final JsonGenerator gen, final SerializerProvider provider )
      throws IOException {

    if (duration == null) { return; }
    String durationFormat =
        duration.toDays() + "." + duration.toHours() + ":" + duration.toMinutes() + ":" + duration.getSeconds() + "."
            + duration.toMillis();
    gen.writeObject(durationFormat);
  }
}
