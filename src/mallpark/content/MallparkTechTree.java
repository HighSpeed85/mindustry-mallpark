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
	static TechNode context = null;
	
	@Override
	public static void load(){
		node(copperWallLarge, () -> {
			node(copperWallHuge, () -> {
				node(copperWallGigantic);
			});
		});
		
		node(titaniumWallLarge, () -> {
			node(titaniumWallHuge, () -> {
				node(titaniumWallGigantic);
			});
		});
		
		node(mechanicalDrill, () -> {
			node(compactDrill);
		});
	}
}
		