package silvercricket.pvp;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class PvpCooldownResetCommand extends CommandBase {
	
    @Override
    public String getCommandName ()
    {
        return "pvpCooldownReset";
    }

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return null;
	}

		@Override
		public void processCommand(ICommandSender sender, String[] args) {
			// TODO Auto-generated method stub
			
		}
	 
}
