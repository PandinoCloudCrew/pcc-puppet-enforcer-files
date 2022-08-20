/* Pandino Cloud Crew (C) 2022 */
package pcc.puppet.enforcer;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.agorapulse.worker.JobManager;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
class EmailDigestSimpleJobTest {

  @Inject JobManager jobManager;

  @MockBean(FallbackEmailDigestService.class)
  EmailDigestService emailDigestService = mock(EmailDigestService.class);

  @Test
  void testSendEmailsDirect() {
    jobManager.forceRun(EmailDigestSimpleJob.class);

    await()
        .atMost(2, SECONDS)
        .untilAsserted(() -> verify(emailDigestService, times(1)).sendEmail("user@example.com"));
  }
}
