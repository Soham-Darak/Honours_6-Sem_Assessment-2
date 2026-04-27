package com.rcoem.devops.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("test")
@ContextConfiguration(classes ={DevopsService.class})
@ExtendWith(MockitoExtension.class)
public class DevopsServiceTest {
    @InjectMocks
    DevopsService devopsService;

    @Test
    public void testPath(){
        String path = devopsService.getPath();
        assert path.equalsIgnoreCase("invoked in null");
    }
}
