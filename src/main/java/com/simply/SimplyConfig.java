package com.simply;

import com.google.inject.Provides;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigObject;

@ConfigGroup("simply")
public interface SimplyConfig extends Config
{

   @ConfigItem(
           keyName = "HP Threshold",
           name = "HP Threshold",
           description = "Enter the HP cut off to be warned."
   )
   default int hpThresh()
   {
      return 20;
   }



}
