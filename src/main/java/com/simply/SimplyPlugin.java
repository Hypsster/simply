package com.simply;

import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
//import net.runelite.client.eventbus.EventBus;

@Slf4j
@PluginDescriptor(name = "Simply")

public class SimplyPlugin extends Plugin
{
    @Inject
    Client client;

    @Inject
    SimplyConfig config;

    @Subscribe
    private void onGameTick(GameTick event)
    {
        int hitpointsTracker = client.getBoostedSkillLevel(Skill.HITPOINTS); // Stores HP Level in variable


        if (hitpointsTracker <= config.hpThresh())
        {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Your HP is low!", null);
        }

    }
    @Subscribe
    private void onGameStateChanged(GameStateChanged gameStateChanged)
    {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
        {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Welcome to runscape", null);
        }
    }

    @Provides
    SimplyConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(SimplyConfig.class);
    }


}
