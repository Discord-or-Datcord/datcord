package io.datcord.service.command.impl;

import io.datcord.Application;
import io.datcord.service.command.CommandService;
import io.datcord.service.command.GuildCommandAssociationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.Collections;

@SpringBootTest(classes = {Application.class})
@ExtendWith(SpringExtension.class)
public class GuildCommandAssociationImplTest {
    @Test
    public void testGuildCommandAssociationForGuildId() {
        Collection<Integer> commandIdForGuildId = guildCommandAssociationService.readAllCommandIdForGuildId(10L);
        Assertions.assertEquals(Collections.EMPTY_LIST , commandIdForGuildId);
    }
    @Test
    public void testGuildIdAssociationForCommandId() {
        Collection<Long> guildIdForCommandId = guildCommandAssociationService.readAllGuildIdForCommandId(1);
        Assertions.assertEquals(Collections.EMPTY_LIST , guildIdForCommandId);
    }

    @Autowired
    private GuildCommandAssociationService guildCommandAssociationService;
}
