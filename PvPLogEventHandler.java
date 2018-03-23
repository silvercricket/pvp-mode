package silvercricket.pvp;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import io.netty.channel.ChannelHandlerContext;




public class PvPLogEventHandler {
	public static PvPLogEventHandler INSTANCE;

	public class PlayerEvents {
		
		 @SubscribeEvent
		 public void onPlayerloggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
				Entity player = event.player;
				long savedTime = 0;
		        if(!(player.getEntityData ().getLong("PvPCooldown")>0)) {
		        	player.getEntityData ().setLong("PvPCooldown", 0);
		        }
		        else
		        {
		        	ServerConfigurationManager cfg = MinecraftServer.getServer ().getConfigurationManager ();
		        	savedTime=player.getEntityData ().getLong("PvPCooldown");
		        	//savedTime=savedTime+=MinecraftServer.getSystemTimeMillis ();
		        	player.getEntityData ().setLong("PvPCooldown",savedTime+MinecraftServer.getSystemTimeMillis () );
		        }
		        
				
			 
		 }

		 @SubscribeEvent
		 public void onPlayerLoggedOutEvent(PlayerEvent.PlayerLoggedOutEvent event) {
				Entity player = event.player;
				long savedTime = 0;
				savedTime=player.getEntityData ().getLong("PvPCooldown");
				savedTime=savedTime-MinecraftServer.getSystemTimeMillis ();
		        	player.getEntityData ().setLong("PvPCooldown",savedTime);
		       		        
		 }

		 @SubscribeEvent
		 public void onPlayerCrashEvent() {
			 
			 
			 
			 
		 }
		 

		 
		 
		 
		 
		 
}

	public static void init() {
        INSTANCE = new PvPLogEventHandler ();
        MinecraftForge.EVENT_BUS.register (INSTANCE);
	}
}
