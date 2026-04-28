package mallpark.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.*;
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
	
	// stuff ripped from BetaMindy until i find a more 'vanilla' solution
	private static void vanillaNode(UnlockableContent parent, Runnable children){
        context = TechTree.all.find(t -> t.content == parent);
        if(context != null){
            children.run();
        }
    }
	
	private static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objective> objectives, Runnable children){
        TechNode node = new TechNode(context, content, requirements);
        if(objectives != null) node.objectives = objectives;

        TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }

    private static void node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        node(content, requirements, null, children);
    }

    private static void node(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives, children);
    }

    private static void node(UnlockableContent content, Runnable children){
        node(content, content.researchRequirements(), children);
    }

    private static void node(UnlockableContent block){
        node(block, () -> {});
    }

    private static void nodeProduce(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives.add(new Produce(content)), children);
    }

    private static void nodeProduce(UnlockableContent content, Runnable children){
        nodeProduce(content, Seq.with(), children);
    }

    private static void nodeProduce(UnlockableContent content){
        nodeProduce(content, Seq.with(), () -> {});
    }
}