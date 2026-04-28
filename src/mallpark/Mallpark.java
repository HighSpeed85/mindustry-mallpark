package mallpark;

import arc.*;
import arc.func.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.mod.*;
import mindustry.type.*;
import mallpark.content.*;

public class Mallpark extends Mod{

    public Mallpark(){
        Log.info("Loaded Mallpark constructor.");
    }

    @Override
    public void loadContent(){
		Log.info("Loading Mallpark content...");
        Log.info("Loading Mallpark blocks...");
		MallparkBlocks.load();
		Log.info("Loading Mallpark tech tree nodes...");
		MallparkTechTree.load();
    }

}
