/* Pandino Cloud Crew (C) 2022 */
package pcc.puppet.enforcer.fuimos.task;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public enum TaskType {
  OPEN,
  REPLY,
  BLOCK,
  UNSUBSCRIBE,
  URL_CLICK
}
