package pvpmode;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod (modid = "pvp-mode", version = "1.1.0", acceptableRemoteVersions = "*")
public class PvPMode
{
	public static Configuration config;
	
	//Config options
	public static boolean blockCreatureDamage = false;
	
	@EventHandler
	public void preinit (FMLPreInitializationEvent event)
	{
		config = new Configuration (event.getSuggestedConfigurationFile ());
		syncConfig ();
	}
	
    @EventHandler
    public void init (FMLInitializationEvent event)
    {
		PvPEventHandler.init ();
    }
    
    @EventHandler
    public void serverLoad (FMLServerStartingEvent event)
    {
    	event.registerServerCommand (new PvPCommand ());
    }
    
    public static void syncConfig ()
    {
    	try
    	{
            config.load();

            Property blockNPCDamageProperty = config.get
            		(Configuration.CATEGORY_GENERAL, "Block Creature Damage", false);

            blockCreatureDamage = blockNPCDamageProperty.getBoolean ();
        }
    	catch (Exception e)
    	{
            
        }
    	
    	if (config.hasChanged ()) config.save ();
    }
}
