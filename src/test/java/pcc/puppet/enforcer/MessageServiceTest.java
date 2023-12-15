/* Pandino Cloud Crew (C) 2022 */
package pcc.puppet.enforcer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.agorapulse.permissions.PermissionException;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.utils.DefaultSecurityService;
import io.micronaut.security.utils.SecurityService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
class MessageServiceTest {

  @MockBean(DefaultSecurityService.class)
  SecurityService securityService = mock(SecurityService.class);

  Authentication authentication = mock(Authentication.class);

  @Inject MessageService messageService;

  @BeforeEach
  void setup() {
    when(securityService.getAuthentication()).thenReturn(Optional.of(authentication));
    when(authentication.getName()).thenReturn("author");
  }

  @Test
  void testSaveMessageAsValidAuthor() {
    Message message = new Message("author", "body");
    Message saved = messageService.save(message);
    assertEquals(message, saved);
  }

  @Test
  void testSaveMessageAsInvalidAuthor() {
    Message message = new Message("notanauthor", "body");
    assertThrows(PermissionException.class, () -> messageService.save(message));
  }
}