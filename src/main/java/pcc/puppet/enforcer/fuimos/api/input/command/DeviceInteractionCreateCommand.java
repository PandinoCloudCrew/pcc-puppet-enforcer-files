/* Pandino Cloud Crew (C) 2022 */
package pcc.puppet.enforcer.fuimos.api.input.command;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import pcc.puppet.enforcer.fuimos.payload.property.InteractionChannel;
import pcc.puppet.enforcer.fuimos.payload.property.InteractionDirection;
import pcc.puppet.enforcer.fuimos.payload.property.InteractionPlan;
import pcc.puppet.enforcer.fuimos.payload.property.InteractionSource;

@Data
@Builder
@Serdeable
public class DeviceInteractionCreateCommand {
  @NonNull private String id;
  @NonNull private String messageId;
  @NonNull private String deviceId;
  @NonNull private String address;
  @Nullable private String payload;
  @NonNull private InteractionPlan interactionPlan;
  @NonNull private InteractionChannel channel;
  @NonNull private InteractionSource source;
  @NonNull private InteractionDirection direction;
  @Nullable private Instant createAt;
  @Nullable private Instant receivedAt;
}