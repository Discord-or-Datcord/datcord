package io.datcord.service.command.impl;

import io.datcord.Application;
import io.datcord.entity.command.Command;
import io.datcord.service.command.CommandService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = {Application.class})
@ExtendWith(SpringExtension.class)
public class CommandServiceImplTest {

    @Test
    public void testCommandCreate() {
        Command greetCommand = new Command();

        greetCommand.setCommandJson("{\"name\":\"greet\",\"description\":\"Greets you\",\"options\":[{\"name\":\"name\",\"description\":\"Your name\",\"type\":3,\"required\":true}]}");

        Command savedGreetCommand = commandService.create(greetCommand);

        Assertions.assertEquals(greetCommand.getId(),savedGreetCommand.getId());
    }

    @Autowired
    private CommandService commandService;
}
