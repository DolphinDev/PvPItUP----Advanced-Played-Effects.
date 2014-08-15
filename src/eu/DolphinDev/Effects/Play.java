package eu.DolphinDev.Effects;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.effect.TextLocationEffect;

public class Play extends JavaPlugin {
	
	
	EffectManager em;
	
	
	@Override
	public void onEnable() {
		System.out.println("Calling Instance...");
		em = new EffectManager(EffectLib.instance());
	}
  
	
	@Override
	public void onDisable() {
	     System.out.println("Ending All Current Effect's Set...");
	     em.dispose();
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("seteffect")) {
			 if(args.length == 0) {
				  Player p = (Player) sender;
				  /**
				   * Cast
				   * 
				   * 
				   */
				  p.sendMessage("[§cPvP§aIt§9UP] §4Usage /seteffect <PackageName>");
				  return true;
			 }
			 
			 if(args[0].equalsIgnoreCase("net.darkzonex44.online")) {
				 Player p = (Player) sender;
				 TextLocationEffect effect  = new TextLocationEffect(em, p.getLocation());
				 effect.text = "Current Online Player's On This Hub: " + Bukkit.getOnlinePlayers();
				 effect.infinite();
				 effect.start();
				 p.sendMessage("§4Started...");
				 
			 }
			if(args[0].equalsIgnoreCase("net.darkzonex44.text")) {
				Player p = (Player) sender;
				TextLocationEffect eff = new TextLocationEffect(em, p.getLocation());
				eff.text = "PvPItUP";
				eff.infinite();
				eff.start();
				p.sendMessage(ChatColor.DARK_RED + "Started...");
				
			}
			if(args[0].equalsIgnoreCase("net.darkzonex44.reset")) {
				em.dispose();
				sender.sendMessage("§c§lAll Effect's Have Been Reset!");
				
			}
			 
		}
		
		return false;
	
	}
	
	
	
}
