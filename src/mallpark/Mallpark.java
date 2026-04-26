package mallpark;

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
        Log.info("Loading content...");
		MallparkBlocks.load();
    }

}
