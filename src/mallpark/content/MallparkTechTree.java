package mallpark.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

import static mallpark.content.MallparkBlocks.*;

public class MallparkTechTree {
	static TechTree.TechNode context = null;
	
	public static void load(){
		
		vanillaNode(copperWallLarge, () -> {
			node(copperWallHuge, () -> {
				node(copperWallGigantic);
			});
		});
		
		vanillaNode(titaniumWallLarge, () -> {
			node(titaniumWallHuge, () -> {
				node(titaniumWallGigantic);
			});
		});
		
		vanillaNode(mechanicalDrill, () -> {
			node(compactDrill);
		});
	}
	
	// ripped from BetaMindy until i find a more 'vanilla' solution
	private static void vanillaNode(UnlockableContent parent, Runnable children){
        context = TechTree.all.find(t -> t.content == parent);
        if(context != null){
            children.run();
        }
    }
}