package io.datcord.service.command.impl;

import io.datcord.Application;
import io.datcord.entity.command.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = {Application.class})
@ExtendWith(SpringExtension.class)
public class CommandServiceImplTest {

    @Test
    @DisplayName("Command existence test")
    public void testCommandExists() {
        final int commandId = 1; //the commandId you want to test
        Command command = commandService.readCommand(commandId);
        Assertions.assertNotNull(command);
    }
    @Autowired
    private CommandServiceImpl commandService;
}
